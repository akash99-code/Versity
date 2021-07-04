<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
    
        <%@ page import="c.Student, java.util.*" %>
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
<% ArrayList<String[]> x=(ArrayList<String[]>)request.getAttribute("courses");
					if(x.size()==0){out.print("<p>~ No Matches Found...<p></body></head>");return;} %>
<em style="font-size:11px;"> ~ similar courses . . .</em>
<center>

 	 <table style="border-collapse: collapse;">
			<tbody id="list">
				
				<tr>
					<td>Title</td>
					<td>Department</td>
					<td>Course ID</td>
					<td>Credits</td>
				<tr>
				<c:forEach items="${courses}" var="item">
				 <tr>
				    <td>${item[1]}</td>
				    <td>${item[2]}</td>
				    <td>${item[0]}</td>
				    <td>${item[3]}</td>
				 </tr>
				</c:forEach>
	
			</tbody>
	</table>

	
		
	
</center>	
</body>
</html>