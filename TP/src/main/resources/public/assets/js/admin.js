/**
 * 
 */
$(document).ready(function(){
	$.get("http://localhost:8080/TP/specialites",function(resp){
    	$.each(resp, function(index, item) {
    		console.log(item);
    		$('#spe-select').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
			$('#spe-select2').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
		});
    });
	
	$.get("http://localhost:8080/TP/modules",function(resp){
    	$.each(resp, function(index, item) {
    		console.log(item);
			$('#mod-select').append('<option value="spe-'+item.idModule+'" >'+item.nomModule+'</option>');
    	});
    });
    
    $('#button-spe').click(function(){
		var nomSpec = $('#spe-input').val();
			$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/specialites",
		    	data: JSON.stringify({ "nomSpec": nomSpec}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					$('#spe-select').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					$('#spe-select2').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');}
			});
		
		
		$('#spe-input').val('');
		return false;
	});
	
	$('#button-mod').click(function(){
		var idSpec = $('#spe-select').val().replace('spe-','');
		var nomModule = $('#mod-input').val();
		
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/modules",
		    data: JSON.stringify({ "nomModule": nomModule, "idSpec" : idSpec}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
		    	$('#mod-select').append('<option value="livre-'+data.idModule+'">'+data.nomModule+'</option>');
			}
		});
		
	});
	
	
	

})