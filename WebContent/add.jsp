<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets\css\register.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add new book</title>
</head>
<body>
	<div class="frame">
		<div class="container">	
			<div class="wrap">
				<form class="form" action="AddBook" method="post">
				  <div class="form-group">
			    	<label class="labelsign" for="exampleInputUser">Name</label>
			    	<input type="text" name="bname" class="form-control" placeholder="Book name" required>   
			  	  </div>
			  	  <div class="form-group">
			    	<label class="labelsign" for="exampleInputPassword1">Author</label>
			    	<input type="text" name="bauthor" class="form-control" placeholder="Author" required>
			  	  </div>			   	 
			  		<button type="submit" class="btn btn-primary">Register</button> 
			  	</form>
			 </div>	
		</div>  
	</div>
</body>
</html>