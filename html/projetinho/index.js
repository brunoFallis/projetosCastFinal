$(function() {

	$('#btn-listar').click(function() {

		$('#container').load('lista.html', carregaTabela);
	});

	$('#container').on('click', '.btn-alterar', function() {
		
		var cpf = $(this).val();
		var tr = $(this).closest('tr').children('td');
		
		$('#container').load('cadastro.html', function(){
			
			$('#cpf').attr('disabled', 'true').val(cpf);
			
			$('#nome').val(tr[1].innerHTML);
			$('#email').val(tr[2].innerHTML);
			
			$('#numero').val(tr[5].innerHTML);
			$('#complemento').val(tr[6].innerHTML);
			
			$('#btn-salvar').click(function(){
				
				var dadosPessoa = $('#formPessoa').serializeArray();
				var dadosEndereco = $('#formEndereco').serializeArray();

				var dadosPessoa = mapeiaParaJson(dadosPessoa);
				var dadosEndereco = mapeiaParaJson(dadosEndereco);

				dadosPessoa.enderecoDTO = dadosEndereco;
				dadosPessoa.cpf = $('#cpf').val();
				
				$.ajax({
					url: 'http://localhost:8080/test',
					contentType: 'application/json',
					method: 'PUT',
					data: JSON.stringify(dadosPessoa),
					success: function(){
						$('#container').html('');
					}
				});
				
			});
			
		});
		

		
		
	});
	
	$('#container').on('click', '.btn-excluir', function(){
		
		var cpf = $(this).val();

		$(this).closest('tr').remove();
		
		$.ajax({
			url: 'http://localhost:8080/test/'+cpf,
			contentType: 'application/json',
			method: 'DELETE'
		})
		
	});
	
	$('#btn-cadastrar').click(function() {
		
		$('#container').load('cadastro.html', function() {

			$('#btn-salvar').click(function(event){
			
				var dadosPessoa = $('#formPessoa').serializeArray();
				var dadosEndereco = $('#formEndereco').serializeArray();
	
				var dadosPessoa = mapeiaParaJson(dadosPessoa);
				var dadosEndereco = mapeiaParaJson(dadosEndereco);
	
				dadosPessoa.enderecoDTO = dadosEndereco;
	
				$.ajax({
					url: 'http://localhost:8080/test',
					contentType: 'application/json',
					method: 'POST',
					data: JSON.stringify(dadosPessoa),
					success: function(){
						$('#container').html('');
					}
				})
	
				event.preventDefault();
				
			});
		});
	});

	$('#container').on('blur', "#cep", function() {
		$.get('https://viacep.com.br/ws/'+$(this).val()+'/json/', function(response){
			
			$('#logradouro').val(response.logradouro);

			$('#bairro').val(response.bairro);
			$('#cidade').val(response.localidade);
			$('#uf').val(response.uf);

		})
	})
	
	function mapeiaParaJson(array) {
		var dadosJson = {};
		$.map(array, function(n, i) {
			dadosJson[n['name']] = n['value'];
		});
		return dadosJson;
	}
	
	function carregaTabela() {
	
		$.get('http://localhost:8080/test', function(response) {

			var listaPessoas = response;
			
			var table = $('table');
			
			for (var i = 0; i < listaPessoas.length; i++) {
				
				var tr = $('<tr></tr>');
				
				tr.append($('<td>'+listaPessoas[i].cpf+'</td>'));
				tr.append($('<td>'+listaPessoas[i].nome+'</td>'));
				tr.append($('<td>'+listaPessoas[i].email+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.cep+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.logradouro+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.numero+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.complemento+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.bairro+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.cidade+'</td>'));
				tr.append($('<td>'+listaPessoas[i].enderecoDTO.uf+'</td>'));
				
				var tdExcluir = $('<td></td>');
				var buttonExcluir = $('<button>Excluir</button>');
				
				buttonExcluir.attr('value', listaPessoas[i].cpf);
				buttonExcluir.addClass('btn-excluir');
				
				tdExcluir.append(buttonExcluir);
				
				var tdAlterar = $('<td></td>');
				var buttonAlterar = $('<button>Alterar</button>');
				
				buttonAlterar.attr('value', listaPessoas[i].cpf);
				buttonAlterar.addClass('btn-alterar');
				
				tdAlterar.append(buttonAlterar);
				
				tr.append(tdAlterar)
				tr.append(tdExcluir);
				
				table.append(tr);
				
			}
		});
	}
});