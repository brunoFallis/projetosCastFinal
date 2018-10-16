$(function() {

    $('#cidade').blur(function(){

        $('#container').html('');

        var cidade = $(this).val();

        $.ajax({
            url: 'http://localhost:8080/clima/'+cidade,
            contentType: 'application/json',
            method: 'GET',
            success: function(response){
                $.each(response, function(i, e){
                    var div = $('<div style="border: 1px solid black;width:300px;height:100px">'
                                      +'<img src="http://openweathermap.org/img/w/10d.png" height="50" width="50">'
                                      +'<p>' + e.tempMin + ' Cº - ' + e.tempMax + ' Cº ' + e.data + '</p>'
                               +'<div>');
                    $('#container').append(div);
                });
            }
        })

    });

});