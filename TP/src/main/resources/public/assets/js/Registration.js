/**
 * 
 */

$(document).ready(function(){
	$('#subBtn').click(function(){
		var idUni = $('#idUni').val();
		$.get("http://localhost:8080/TP/logins/"+idUni,function(){
			$.each(resp, function(index, item) {
    			console.log(item);
				
			});
		});
	});
});