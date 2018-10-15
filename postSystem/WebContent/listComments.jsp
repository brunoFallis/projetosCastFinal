<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="dao" class="br.com.cast.postSystem.persistence.CommentDAO"/>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="ViewAltAdd">
	<button name="view" value="add">Add comment</button>
</form>

<table>
	<tr>
		<th>Title</th>
		<th>Description</th>
		<th>Actions</th>
	</tr>
	<c:forEach var="comment" items="${dao.commentsById(sessionScope.logged.id)}">
	<tr>
		<td>${comment.title}</td>
		<td>${comment.description}</td>
		<td>
			<form action="ViewAltAdd" method="post">
				<button type="submit" name = "view" value="disabled">
					View
				</button>
			 	<button type="submit" name = "view"	>
			 		Edit
			 	</button>
				<button name="del" value="${comment.id}" formaction="Delete">
					Delete
				</button>
				<input type="hidden" name="id_comment" value="${comment.id}">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>