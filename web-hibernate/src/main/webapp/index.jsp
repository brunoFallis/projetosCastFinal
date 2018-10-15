<%@page import="br.com.cast.entidade.Post"%>
<%@page import="br.com.cast.persistencia.PostDao"%>
<%@page import="java.util.List"%>
<html>
<body>
<h2>Hello World!</h2>

	<%
	PostDao dao = new PostDao();
	Post post = dao.buscarPorId(1);
	%>
	
	<div>
		<%= post.getTextoComImagens() %>
	</div>


</body>
</html>
