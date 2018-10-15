<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!--<%//@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>-->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body id="bLog">
	<div class="container">
		<% 
			String msg = (String) request.getAttribute("errorMsg"); 
			if (msg != null) {
		 %>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
			   <%=msg%>
			   <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    	<span aria-hidden="true">&times;</span>
			   </button>
			</div>
		 <% } %>
		
			<form action="logIn" method="post" class="d">
			
				<label id="log">LogIn</label>
			
				<div class="form-group">
				
					<input type="text" class="form-control" name="user" placeholder="type user">
				
				</div>
				
				<div class="form-group">
					
					<input type="password" class="form-control" name="pass" placeholder="type password">
				
				</div>
					
				<button name="alt" type="submit" class="btn btn-success">Sign in</button>
			
				<button name="alt" value="add" type="submit" class="btn btn-secondary" formaction="altadd.jsp">Sign up</button>
			
			</form>
			 
	</div>
</body>
</html>