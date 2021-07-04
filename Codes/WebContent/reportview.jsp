<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="c.report, java.util.*" %>
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
<% report jb=(report)request.getAttribute("jb"); 
	if(jb==null)
	{out.print("<p> Instructor does not exist, Try again.<p></body></head>");return;}
 	 %>

<center>

 	<p style="font-size:20px; line-height:1px"> ~ Workload Report of ${jb.getName()} ~</p>
 	 <table style="border-collapse: collapse;">
		<c:choose><c:when test="${jb.getStudents().size()!=0}">
			<tbody>
				<tr><td> Guided Students -</td></tr>
			</tbody>
			<tbody id="list">
				<tr>
					<td>Name</td>
					<td>ID</td>
				<tr>
				<c:forEach items="${jb.getStudents()}" var="item">
				 <tr>
				    <td>${item[1]}</td>
				    <td>${item[0]}</td>
		    
				 </tr>
				</c:forEach>		
			</tbody>
		</c:when>
		<c:otherwise>
			<tbody>
				<tr><td>&nbsp;</td></tr>
				<tr><td> Guided Students - None</td></tr>
			</tbody>
		</c:otherwise>
		</c:choose>
		<c:choose><c:when test="${jb.getClasses().size()!=0}">    	
			<tbody>
				<tr><td>&nbsp;</td></tr>
				<tr><td> Classes taken on ${jb.getSem()}, ${jb.getYear()} -</td></tr>
			</tbody>
			<tbody id="list">
				<tr>
					<td>Day</td>
					<td>Start Hour</td>
					<td>Start Min</td>
					<td>Stop Hour</td>
					<td>Stop Min</td>
					<td>Course ID</td>
				<tr>
				<c:forEach items="${jb.getClasses()}" var="item">
				 <tr>
				    <td>${item[0]}</td>
				    <td>${item[1]}</td>
				    <td>${item[2]}</td>
				    <td>${item[3]}</td>
				    <td>${item[4]}</td>
				    <td>${item[5]}</td>
				 </tr>
				</c:forEach>		
			</tbody>
		</c:when>
		<c:otherwise>
			<tbody>
				<tr><td>&nbsp;</td></tr>
				<tr><td> No Classes taken on ${jb.getSem()}, ${jb.getYear()} </td></tr>
			</tbody>
		</c:otherwise>
		</c:choose>
	</table>

	
		
	
</center>	
</body>
</html>