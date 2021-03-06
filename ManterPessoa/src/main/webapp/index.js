$(function() {

	$('#btn-listar').click(function() {

		$.get('salvar', function(response) {

			$('#container').load('lista.html', function() {

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
				
			})

		})
	});

	$('#container').on('click', '.btn-alterar', function() {
		
		var cpf = $(this).val();
		var tr = $(this).closest('tr').children('td');
		
		
		$('#container').load('cadastro.html', function(){
			
			var inputs = $('form').
			
			$('#cpf').attr('disabled', 'true').val(cpf);
			
			for (var i = 1; i < array.length - 2; i++) {
				
			}
			
			
		});
		
//		$.ajax({
//			url: 'salvar',
//			type: 'PUT',
//			data: $(this).val()
//		})
		
		
	});
	
	$('#container').on('click', '.btn-excluir', function(){
		
		$(this).closest('tr').remove();
		
		$.ajax({
			url: 'salvar',
			type: 'DELETE',
			data: $(this).val()
		})
		
	});
	
	$('#btn-cadastrar').click(function() {
		$('#container').load('cadastro.html');
	});

	$('#container').on('click', '#btn-salvar', function(event) {

		var dadosPessoa = $('#formPessoa').serializeArray();
		var dadosEndereco = $('#formEndereco').serializeArray();

		var dadosPessoa = mapeiaParaJson(dadosPessoa);
		var dadosEndereco = mapeiaParaJson(dadosEndereco);

		dadosPessoa.enderecoDTO = dadosEndereco;

		$.post('salvar', JSON.stringify(dadosPessoa));

		event.preventDefault();

	});

	function mapeiaParaJson(array) {
		var dadosJson = {};
		$.map(array, function(n, i) {
			dadosJson[n['name']] = n['value'];
		});
		return dadosJson;
	}

	$('#container').on('blur', "#cep", function() {
		alert('teste');
	})

});