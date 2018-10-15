<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="br.com.cast.hibernate_brunao.persistence.*" %>   
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<jsp:useBean id="dao" class="br.com.cast.hibernate_brunao.persistence.ContactDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1><%=dao.searchById(3)%></h1>

</body>
</html>