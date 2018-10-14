<%@page import="br.com.cast.persistence.ContactDAO"%>
<%@page import="br.com.cast.models.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Alter Add</title>

<style>
.d{
	height: 250px;
	width: 320px;
	margin: 0 auto;
	text-align: center;
}
body{
	margin-top: 60px;
	background-image: url("css/gif-add.gif");
}
input{
	margin-top: 5px;
}
</style>

</head>
<body>

	<% 
	String id = request.getParameter("alt");
	Contact c = new Contact();
	if(id!=null && !id.isEmpty() && !id.equals("add") && !id.equals("s")){
		ContactDAO cDao = new ContactDAO();
		 c = cDao.searchById((Integer.parseInt(id)));
	}else{
		c.setName(""); c.setEmail(""); c.setAdress(""); c.setDateBirth("");c.setPass("");
	}%>
	
	<div class="d">
		<form action="addAlt" method="post">
			
			<label style="font-size:25px;font-weight: bold">Sign Up</label>
			
			<div class="form-group">
				<input placeholder="name" type="text" name="name" class="form-control" value="<%=c.getName()%>">
				<input placeholder="email" type="email" name="email" class="form-control" value="<%=c.getEmail()%>">
				<input placeholder="adress" type="text" name="adress" class="form-control" value="<%=c.getAdress()%>">
				<input placeholder="date birth" type="date" name="date" class="form-control" value="<%=c.getDateBirth()%>">
				<input placeholder="password" type="text" name="pass" class="form-control" value="<%=c.getPass()%>">
			</div>
				<button name="send" type="submit" class="btn btn-success col-md-12" value="${param.alt}">
					<i class="far fa-save"></i>
				</button>
		</form>
	</div>
	
</body>
</html>