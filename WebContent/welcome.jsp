<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Welcome Page Test</h1>
	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); /// HTTP 1.1
		response.setHeader("Pragma", "no-cache"); /// HTTP 1.0
		response.setHeader("Expires", "0"); /// proxies
		
		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}	
	%>
	
	<h2>Hello</h2> ${username}
	
	<a href="videos.jsp">Videos Here</a>
	
	<form action="Logout">
	<button type="submit" value="Logout" class="btn btn-primary">Log out</button>
	</form>
</body>
</html>