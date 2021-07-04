package c;

import c.Student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;


import c.DatabaseConnection;

/**
 * Servlet implementation class controller
 */
@WebServlet("/stucontroller")
public class stucontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stucontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
            try{
        	Student jb=new Student();
        	ArrayList<String[]> courses=new ArrayList<String[]>();
            String arr[];
           	String Roll = request.getParameter("roll");
            Connection con = DatabaseConnection.initializeDatabase(); 
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery("select name,dept_name from student where ID="+Roll); 
            
            if(!rs.next())
            {	
            	jb=null;
            }
            else
            {
            jb.setRoll(Roll);
            jb.setName(rs.getString("name"));
            jb.setDepartment(rs.getString("dept_name"));
             rs = st.executeQuery("select course.course_id,course.title,course.credits,takes.grade from course inner join takes on course.course_id=takes.course_id where takes.ID="+Roll);          
            while(rs.next())
            {
            	arr=new String[4];
            	arr[0]=rs.getString("course_id");
            	arr[3]=rs.getString("grade");
            	arr[1]=rs.getString("title");
            	arr[2]=rs.getString("credits");
            	courses.add(arr);  	 
            }
            jb.setCourses(courses);
            }
            st.close(); 
            con.close();
    		request.setAttribute("jb",jb);
    		HttpSession session= request.getSession();
    		session.setAttribute("jb",jb);
    		
    		RequestDispatcher view = request.getRequestDispatcher("stuview.jsp");
    		//response.sendRedirect("result.jsp");   
    		view.forward(request, response);
             
  
 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
	}

}
