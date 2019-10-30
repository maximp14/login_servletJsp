<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets\css\welcome.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<div class="navbar navbar-expand-lg navbar-light bg-light">	
	<h5 class="font-italic">Hello ${username} </h5>
	<form action="Logout">
	<button type="submit" value="Logout" class="btn btn-primary ml-auto">Log out</button>
	</form>
	</div>
	
		
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); /// HTTP 1.1
		response.setHeader("Pragma", "no-cache"); /// HTTP 1.0
		response.setHeader("Expires", "0"); /// proxies
		
		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}	
	%>
	

	
	<!--<form action="Logout">
	<button type="submit" value="Logout" class="btn btn-primary">Log out</button>
	</form>-->
</body>
</html>