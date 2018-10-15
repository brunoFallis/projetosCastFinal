$(function() {
	
	$('#btn-listar').click(function() {
		
		/*$.get('Teste', function(response) {
			$('#container').html(response);
		})*/
		
		$('#container').load('list.jsp');
			
	});
	
	$('#btn-cadastrar').click(function() {
		
		$('#container').load('add.jsp','op=add');
			
	});
	
	$('#container').on('click','#btn-salvar',function(){
		
		var dadosSerializados = $('#formCadastro').serialize();
		
		$.post('TesteDois', dadosSerializados)
		
			.done(function(retorno){
				$('#container').html(retorno);
			});
			
	});
	
	$('#container').on('click','#btn-excluir',function(){
		
		$.post('TesteDois', {id: $(this).val(), option: 'x'})
		
			.done(function(retorno){
				$('#container').html(retorno);
			});
		
	});
	
	$('#container').on('click','#btn-alterar',function(event){
		
		var listTd = $(this).closest('tr').children('td');
		
		var nome = listTd[0];
		var email = listTd[1];
		var adress = listTd[2];
		var date = listTd[3];
			
		$('#container').load('add.jsp', {
				
				op:	'a', 
				n:	nome.html,
				e: 	email.html,
				a: 	adress.html,
				d:	date.html
		});
		
	});
	
	$('#container').on('click','#btn-salvar-alteracao',function(){
				
	});
	
});