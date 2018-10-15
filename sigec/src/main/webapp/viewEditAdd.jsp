<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<form action="AltAdd" method="post" enctype="multipart/form-data">
	<input type="text" name="title" value="${sessionScope.comment.title}" ${param['view']} required>
	<input type="text" name="description" value="${sessionScope.comment.description}" ${param['view']} required>
	
	<c:if test="${param['view'].equals('disabled')}">
		<img width="200" src="/sigec/Download?file=${sessionScope.image.path}&id_comment=${param['id_comment']}">
	</c:if>
	
	<c:if test="${!param['view'].equals('disabled')}">
		<input type="file" name="file" required>
	</c:if>
	
	<button type="submit" name="save" value="${sessionScope.op}">save</button>
	<input type="hidden" name="id_comment" value="<%=request.getParameter("id_comment")%>">
	
	<p>${sessionScope.op}</p>
</form>

</body>
</html>