$(function() {
	
	$('#btn-request').click(function() {
		
/*		$.ajax({
			url: '/ajax-jquery/get-alunos', 
			method: 'get', 
			success: function(response) {
				$('#container').html(response);
			}
		});*/
		
		$.get('/ajax-jquery/get-alunos', function (response) {
			$('#container').html(response);
		});
		
	});
	
});