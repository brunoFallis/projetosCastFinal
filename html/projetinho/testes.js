$(function() {

    $('#btn').click(function(){

        var city = $('#city').val();

        $.get('api.openweathermap.org/data/2.5/weather?q='+city+',br&appid=31f812f79352d564bb09619ef42bd33b&units=metric&lang=pt',
             function(response){
                $('#container').append(response);
             });

    });

});