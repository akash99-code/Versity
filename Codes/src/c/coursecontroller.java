package c;

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
@WebServlet("/coursecontroller")
public class coursecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coursecontroller() {
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
        	ArrayList<String[]> courses=new ArrayList<String[]>();
            String arr[];
           	String title = request.getParameter("title");
            Connection con = DatabaseConnection.initializeDatabase(); 
            Statement st = con.createStatement(); 
            ResultSet rs = st.executeQuery("select * from course where title like '%"+title+"%'"); 
            while(rs.next())
            {
            	arr=new String[4];
            	arr[0]=rs.getString("course_id");
            	arr[1]=rs.getString("title");
            	arr[2]=rs.getString("dept_name");
            	arr[3]=rs.getString("credits");
            	courses.add(arr);  	 
            }
            st.close(); 
            con.close();
    		request.setAttribute("courses",courses);
    		HttpSession session= request.getSession();
    		session.setAttribute("courses",courses);
    		RequestDispatcher view = request.getRequestDispatcher("coursesview.jsp");
    		//response.sendRedirect("result.jsp");   
    		view.forward(request, response);

        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
	}

}
 