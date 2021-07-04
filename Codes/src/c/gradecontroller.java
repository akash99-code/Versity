package c;

import java.io.IOException;
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
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class gradecontroller
 */
//@WebServlet("/gradecontroller")
@WebServlet(name = "gradecontroller", urlPatterns = {"/gradecontroller"})
public class gradecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gradecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
		ArrayList<String[]> stus=new ArrayList<String[]>();
		String arr[];
		Connection con = DatabaseConnection.initializeDatabase(); 
        Statement st = con.createStatement(); 
        ResultSet rs = st.executeQuery("select student.ID, name, group_concat(grade) as grades from takes inner join student on student.ID=takes.ID group by ID;");
        while(rs.next())
        {
        	arr=new String[3];
        	arr[0]=rs.getString("ID");
        	arr[1]=rs.getString("name");
        	arr[2]=rs.getString("grades");
        	stus.add(arr);
        }
        st.close(); 
        con.close();
        request.setAttribute("stus",stus);
		RequestDispatcher view = request.getRequestDispatcher("gradeview.jsp");
		view.forward(request, response);
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
		
	
	}

}
