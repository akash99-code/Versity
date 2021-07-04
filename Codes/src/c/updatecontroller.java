package c;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import c.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatecontroller
 */
@WebServlet("/updatecontroller")
public class updatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		/**response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");*/
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out=response.getWriter();
        //out.write("help me god");
        String menu="<option selected disabled value=\"\">Select Department</option>";
		try{
			Connection con = DatabaseConnection.initializeDatabase(); 
	        Statement st = con.createStatement(); 
	        ResultSet rs = st.executeQuery("select dept_name from department"); 
	        while(rs.next())
	        {
	        	menu+="<option value=\""+rs.getString("dept_name")+"\">"+rs.getString("dept_name")+"</option>";
	        	
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
		String desig=request.getParameter("desig");
		String name=request.getParameter("name");
		String depts=request.getParameter("depts");
		String id=request.getParameter("id");
		String extra=request.getParameter("extra");
		System.out.println(desig+" "+name+" "+depts+" "+id+" "+extra);
		try{
			Connection con = DatabaseConnection.initializeDatabase(); 
	        Statement st = con.createStatement(); 
	        st.executeUpdate("insert into "+desig+" values("+id+",\""+name+"\",\""+depts+"\","+extra+")"); 
	        st.close(); 
	        con.close();   
	        request.setAttribute("err", null);
	        request.setAttribute("name", name);
	        
			} 
			catch(SQLException se){
				request.setAttribute("err", se.getMessage());
		   }
	        catch (Exception e) { 
	        	request.setAttribute("err", e.getMessage());
	        	
	        }
		    finally
		    {	
		    	RequestDispatcher view = request.getRequestDispatcher("update.jsp");
		    	view.forward(request, response);
			}
		
		}

}
