<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap">

<style>
#list{
 width:100%;
 text-align:center;
 
}
#list td{
border:1px solid #ddd;
 padding:6px 8px 6px 8px;
}


</style>
</head>
<body style=" height:100%; margin:10px; padding-left:20px; font-size:15px; letter-spacing: 1.5px; font-family: 'Poppins', sans-serif;" >
<% 
	ArrayList<String[]> stus=(ArrayList<String[]>)request.getAttribute("stus"); 
	if(stus.size()==0)
	{out.print("<p>No records found..<p></body></head>");return;}
 	 %>
<center>
<p> Academic details of Students:</p>

 	
 	 <table style="border-collapse: collapse;">
			
			<tbody id="list">
				
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Grades</td>
					<td>Status</td>
				</tr>
				
			<%
				int f=0,p=0;
				for(String item[]:stus)
					{
						out.print("<tr>");
						out.print("<td>"+item[0]+"</td>");
						out.print("<td>"+item[1]+"</td>");
						out.print("<td>"+item[2]+"</td>");
						if(item[2].length()-item[2].replace("F", "").length()<2)
						{
							out.print("<td>Passed</td>");
							p++;
						}
						else
						{ 
							out.print("<td>Failed</td>");
							f++;
						}
					
						out.print("</tr>");
					}%>
					
									 
				    			
			</tbody>
	</table>
	
	<%  out.print("<p>Number of Students Passed - "+p+"</p>");
		out.print("<p>Number of Students Failed - "+f+"</p>");
		%>
	</center>
	
</body>
</html>
