/**
 * 
 */
$(document).ready(function(){
	$.get("http://localhost:8080/TP/specialites",function(resp){
    	$.each(resp, function(index, item) {
    		$('#spe-select').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
			$('#spe-select2').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
			$('#spe-select3').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>')
		});
    });
	
	$.get("http://localhost:8080/TP/modules",function(resp){
    	$.each(resp, function(index, item) {
			$('#mod-select').append('<option value="mod-'+item.idModule+'" >'+item.nomModule+'</option>');
    	});
    });
    
    $('#button-spe').click(function(){
		let nomSpec = $('#spe-input').val();
			$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/specialites",
		    	data: JSON.stringify({ "nomSpec": nomSpec}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					$('#spe-select').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					$('#spe-select2').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					$('#spe-select3').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					},
				
			});
		
		
		$('#spe-input').val('');
		return false;
	});
	
	$('#button-mod').click(function(){
		let idSpec = $('#spe-select').val().replace('spe-','');
		let nomModule = $('#mod-input').val();
		
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/modules",
		    data: JSON.stringify({ "nomModule": nomModule, "idSpec" : idSpec}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
		    	$('#mod-select').append('<option value="mod-'+data.idModule+'">'+data.nomModule+'</option>');
			}
		});
		
		$('#mod-input').val('');
		return false;
	});
	
	$('#button-etu').click(function(){
		let idSpec = $('#spe-select2').val().replace('spe-','');
		let nomEtu = $('#nomEtu-input').val();
		let prenomEtu = $('#prenomEtu-input').val();
		console.log(JSON.stringify({ "nomEtu": nomEtu, "prenomEtu": prenomEtu, "idSpec" : idSpec}));
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/etudiants",
		    data: JSON.stringify({ "nomEtu": nomEtu, "prenomEtu": prenomEtu, "idSpec" : idSpec}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
			}
		})
	});
	
	$('#button-prof').click(function(){
		let idMod = $('#mod-select').val().replace('mod-','');
		let nomProf = $('#nomProf-input').val();
		let prenomProf = $('#prenomProf-input').val();
		console.log(JSON.stringify({ "idMod" : idMod ,"nomProf": nomProf, "prenomProf": prenomProf}));
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/professeurs",
		    data: JSON.stringify({ "idMod" : idMod ,"nomProf": nomProf, "prenomProf": prenomProf}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
			}
		})
	});
	
	$('#spe-select3').change(function(){
		$('#mod-select').empty();
		let value = $('#spe-select3').val().replace('spe-','');
		$.get("http://localhost:8080/TP/specialites/"+value+"/modules",function(resp){
			$.each(resp, function(index, item){
				$('#mod-select').append('<option value="mod-'+item.idModule+'" >'+item.nomModule+'</option>');
			})
		})
	});
});