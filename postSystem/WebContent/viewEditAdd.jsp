<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cast.postSystem.persistence.*, br.com.cast.postSystem.entities.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
<form action="altAdd" method="post" enctype="multipart/form-data">
	<input type="text" name="title" value="${sessionScope.comment.title}" ${param['view']}>
	<input type="text" name="description" value="${sessionScope.comment.description}" ${param['view']}>
	
	<c:if test="${sessionScope.comment.id != null}">
		<img alt="image" src="/postSystem/Download?file=">
	</c:if>
	
	<input type="file" name="file">
	<button type="submit" name="save" value="${sessionScope.op}">save</button>
	<input type="hidden" name="id_comment" value="<%=request.getParameter("id_comment")%>">
</form>

</body>
</html>