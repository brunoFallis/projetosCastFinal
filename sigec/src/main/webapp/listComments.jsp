<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="br.com.cast.sigec.persistence.CommentDAO"/>    

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">

	<form action="ViewAltAdd" method="post">
		<button name="view" value="add">Add comment</button>
	</form>
	
	<table class="table table-dark">
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="comment" items="${dao.commentsByPage(sessionScope.logged.id, sessionScope.page)}">
		<tr>
			<td>${comment.title}</td>
			<td>${comment.description}</td>
			<td>
				<form action="ViewAltAdd" method="post">
					<button type="submit" name = "view" value="disabled" class="btn btn-outline-secondary">
						View
					</button>
				 	<button type="submit" name = "view"	class="btn btn-outline-warning">
				 		Edit
				 	</button>
					<button name="del" value="${comment.id}" formaction="Delete" class="btn btn-outline-danger">
						Delete
					</button>
					<input type="hidden" name="id_comment" value="${comment.id}">
				</form>
			</td>
		</tr>
		</c:forEach>
	</table>
	<form action="ViewAltAdd" method="get">
		<button name="page" value="prev" ${sessionScope.page == 0 ? 'disabled' : ''} class="btn btn-warning" >
			Prev
		</button>
		<button name="page" value="next" ${sessionScope.page >= dao.getTotalComments(sessionScope.logged.id) ? 'disabled' : ''} class="btn btn-warning">
			Next
		</button>
	</form>

</div>

</body>
</html>