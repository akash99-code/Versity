package c;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reportcontroller
 */
@WebServlet("/reportcontroller")
public class reportcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reportcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out=response.getWriter();
        //out.write("help me god");
        String menu="<option selected disabled value=\"\">Select Year</option>";
		try{
			Connection con = DatabaseConnection.initializeDatabase(); 
	        Statement st = con.createStatement(); 
	        ResultSet rs = st.executeQuery("select year from teaches group by year"); 
	        while(rs.next())
	        {
	        	menu+="<option value=\""+rs.getInt("year")+"\">"+rs.getInt("year")+"</option>";
	        	
	        }
	        st.close(); 
	        con.close();   
	        out.println(menu);
	        out.flush();
	        out.close();

			} 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        }
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String[]> stus=new ArrayList<String[]>();
		ArrayList<String[]> classes=new ArrayList<String[]>();
		String arr[];
		String name=request.getParameter("name");
		String id="";
		String sem=request.getParameter("sem");
		String year=request.getParameter("year");

		report jb =new report();
		try{
			
			Connection con = DatabaseConnection.initializeDatabase(); 
	        Statement st = con.createStatement(); 
	        ResultSet rs = st.executeQuery("select id from instructor where name=\""+name+"\"");
	        rs.next();
	        id=rs.getString("id");
	        rs= st.executeQuery("select student.id, student.name from instructor inner join advisor on instructor.id=advisor.i_id inner join student on student.id=advisor.s_id where instructor.id=\""+id +"\""); 
	        while(rs.next())
	        {
	        	arr=new String[2];
	        	arr[1]=rs.getString("name");
	        	arr[0]=rs.getString("ID");
	        	stus.add(arr);
	        }
	        rs= st.executeQuery("select time_slot.day,time_slot.start_hr,time_slot.start_min,time_slot.end_hr,time_slot.end_min,section.course_id from section inner join teaches on section.course_id=teaches.course_id and section.semester=teaches.semester and section.year=teaches.year and section.sec_id=section.sec_id inner join time_slot on section.time_slot_id=time_slot.time_slot_id where teaches.id=\""+id+"\" and teaches.year="+year+" and teaches.semester=\""+sem+"\""); 
	        while(rs.next())
	        {
	        	arr=new String[6];
	        	arr[0]=rs.getString("day");
	        	arr[1]=Integer.toString(rs.getInt("start_hr"));
	        	arr[2]=Integer.toString(rs.getInt("start_min"));
	        	arr[3]=Integer.toString(rs.getInt("end_hr"));
	        	arr[4]=Integer.toString(rs.getInt("end_min"));
	        	arr[5]=rs.getString("course_id");
	        	
	        	classes.add(arr);
	        }

	        
	        jb.setName(name);
	        jb.setSem(sem);
	        jb.setYear(year);
	        jb.setStudents(stus);
	        jb.setClasses(classes);
	        st.close(); 
	        con.close();
	        
			} 
	        catch (Exception e) { 
	        	jb=null;
	            e.printStackTrace(); 
	        }
			request.setAttribute("jb",jb);
			RequestDispatcher view = request.getRequestDispatcher("reportview.jsp");
			view.forward(request, response);
		}
	

}
