
<form id="formCadastro">

	<input type="hidden" id="teste" name="option" value="<%=request.getParameter("op")%>"/>
	
	<input placeholder="name" type="text" name="name" value="<%=request.getParameter("n")%>"/>
	<input placeholder="email" type="email" name="email" value="<%=request.getParameter("e")%>"/>
	<input placeholder="adress" type="text" name="adress" value="<%=request.getParameter("a")%>"/>
	<input placeholder="date birth" type="date" name="date value="<%=request.getParameter("d")%>""/>
	<input placeholder="password" type="text" name="pass"/>
	
	<button id="btn-salvar">salvar</button>
	
	<button id="btn-salvar-alteracao" style="display:none">salvar alteracao</button>
	
</form>