$(function() {

    $('#cidade').blur(function(){

        var cidade = $(this).val();

        $.ajax({
            url: 'http://localhost:8080/clima/'+cidade,
            contentType: 'application/json',
            method: 'GET',
            success: function(response){
                $.each(response, function(i, e){
                    var div = $('<div>'
                                      +'<p>'+e.umidade+'</p>'
                                      +'<p>'+e.pressao+'</p>'
                                      +'<p>'+e.tempMin+'</p>'
                                      +'<p>'+e.tempMax+'</p>'
                                      +'<p>'+e.data+'</p>'
                               +'<div>');
                    $('#container').append(div);
                })
            }
        })

    });

});