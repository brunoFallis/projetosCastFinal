<%@page import="br.com.cast.persistence.ContactDAO"%>
<%@page import="br.com.cast.models.Contact"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%
	  ContactDAO cDao = new ContactDAO();
	  List<Contact> listContacts = cDao.listContacts();  
	%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="css/style.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<meta charset="ISO-8859-1">

<title>List Contacts</title>
</head>
<body id="bIndex">
	<div class="col-sm-12">
		<table class="table table-dark table-hover table-bordered table-sm" id="list">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Adress</th>
				<th>Date of Birth</th>
				<th colspan="2" class="">Actions</th>
			</tr>
			<%for(Contact c : listContacts) {%>
			<tr>
				<td><%=c.getName()%></td>
				<td><%=c.getEmail()%></td>
				<td><%=c.getAdress()%></td>
				<td><%=c.getDateBirth()%></td>
				<td>
					<form action="del" method="post">
						<button name="delete" type="submit" class="btn btn-danger" value="<%=c.getId()%>">
							<i class="far fa-trash-alt"></i>
						</button>
						<button name="alt" type="submit" formaction="altadd.jsp" class="btn btn-info" value="<%=c.getId()%>">
							<i class="far fa-edit"></i>
						</button>
					</form>
				</td>
			</tr>
			<%}%>
		</table>
		<form action="altadd.jsp" method="post">
			<button name="alt" type="submit" class="btn btn-success" value="add">
				Add Contact
			</button>
			<button name="log" type="submit" class="btn btn-secondary" formaction="logout" value="log" style="float:right">
				Logout
			</button>
		</form>
	</div>

</body>
</html>