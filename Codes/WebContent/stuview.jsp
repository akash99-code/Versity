<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="c.Student, java.util.*" %>
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
 padding:3px 5px 3px 5px;
}


</style>
</head>
<body style=" height:100%; margin:10px; padding-left:20px; font-size:15px; letter-spacing: 1.5px; font-family: 'Poppins', sans-serif;" >
<% Student jb=(Student)request.getAttribute("jb"); 
	if(jb==null)
	{out.print("<p> Wrong Student ID Entered, Try again.<p></body></head>");return;}
 	 %>
<em style="font-size:11px;"> ~ searched details . . .</em>
<center>

 	
 	 <table style="border-collapse: collapse;">
			<tbody>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td>Student's Name	</td>
					<td >&emsp;:&emsp;${jb.getName()}</td>
				<tr>
				<tr>
					<td>ID	</td>
					<td>&emsp;:&emsp;${jb.getRoll()}</td>
				<tr>	
				<tr>
					<td>Department	</td>
					<td>&emsp;:&emsp;${jb.getDepartment()}</td>
				<tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td> Enrolled Courses ~</td></tr>
				<%if(jb.getCourses().size()==0)
				{
					out.print("<tr><td>&emsp;None</td></tr></tbody></table></center></body></html>");
					return;
				}%>
			</tbody>
			<tbody id="list">
				
				<tr>
					<td>Course ID</td>
					<td>Title</td>
					<td>Credits</td>
					<td>Grades</td>
				<tr>
				<c:forEach items="${jb.getCourses()}" var="item">
				 <tr>
				    <td>${item[0]}</td>
				    <td>${item[1]}</td>
				    <td>${item[2]}</td>
				    <td><c:choose>
    					<c:when test="${item[3]==null}">---</c:when>    
    					<c:otherwise>${item[3]}</c:otherwise>
						</c:choose>
						</td>
				 </tr>
				</c:forEach>	
				
				
				
			</tbody>
	</table>

	
		
	
</center>	
</body>
</html>