<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap">

</head>
<body style=" height:100%; margin:10px; padding-left:20px; font-size:15px; letter-spacing: 1.5px; font-family: 'Poppins', sans-serif;">

<div>
      <%
      	if(request.getAttribute("err")!=null)
    	{
      		out.println("ERROR occured while updating the record<br>");
      		out.print("Error Message >>  "+request.getAttribute("err"));
    	}
      	else
      	{
      		out.print("Record for "+request.getAttribute("name")+" was updated successfully");		
      	}
     %>   
</div>       

</body>
</html>