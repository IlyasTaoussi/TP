/**
 * Traitement Javascript pour la page admin.html
 */
$(document).ready(function(){
	
	//Service GET Pour Recuperer la liste de toutes les specialités dans le document
	$.get("http://localhost:8080/TP/specialites",function(resp){
    	$.each(resp, function(index, item) {
    		$('#spe-select').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
			$('#spe-select2').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>');
			$('#spe-select3').append('<option value="spe-'+item.idSpec+'" >'+item.nomSpec+'</option>')
		});
    });
	
	//Service GET pour Recuperer la liste de tous les modules dans le document
	$.get("http://localhost:8080/TP/modules",function(resp){
    	$.each(resp, function(index, item) {
			$('#mod-select').append('<option value="mod-'+item.idModule+'" >'+item.nomModule+'</option>');
    	});
    });
    
	//Bouton qui Execute la requete POST et enregistre la specialité dans la BDD
    $('#button-spe').click(function(){
		let nomSpec = $('#spe-input').val();
			$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/specialites",
		    	data: JSON.stringify({ "nomSpec": nomSpec}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log("success");
					$('#spe-select').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					$('#spe-select2').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					$('#spe-select3').append('<option value="spe-'+data.idSpec+'" >'+data.nomSpec+'</option>');
					},
				
			});
		
		
		$('#spe-input').val('');
		return false;
	});
	
	//Bouton qui Execute la requete POST et enregistre le module dans la BDD
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
		    	console.log("success");
		    	$('#mod-select').append('<option value="mod-'+data.idModule+'">'+data.nomModule+'</option>');
			}
		});
		
		$('#mod-input').val('');
		return false;
	});
	
	//Bouton qui Execute la requete POST et enregistre l'etudiant dans la BDD
	$('#button-etu').click(function(){
		let idSpec = $('#spe-select2').val().replace('spe-','');
		let nomEtu = $('#nomEtu-input').val();
		let prenomEtu = $('#prenomEtu-input').val();
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/etudiants",
		    data: JSON.stringify({ "nomEtu": nomEtu, "prenomEtu": prenomEtu, "idSpec" : idSpec}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log("Adding Student Successful");
			}
		})
		$('#nomEtu-input').val('');
		$('#prenomEtu-input').val('');
		
	});
	
	//Bouton qui Execute la requete POST et enregistre le professeur dans la BDD
	$('#button-prof').click(function(){
		let idMod = $('#mod-select').val().replace('mod-','');
		let nomProf = $('#nomProf-input').val();
		let prenomProf = $('#prenomProf-input').val();
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/professeurs",
		    data: JSON.stringify({ "idMod" : idMod ,"nomProf": nomProf, "prenomProf": prenomProf}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log("Adding Sensei Successful");
			}
		})
		
		$('#nomProf-input').val('');
		$('#prenomProf-input').val('');
	});
	
	//Methode .change() qui detecte le changement de la valeur de l'element HTML (Specialite) et execute le traitement (Recuperer la liste des modules liée à la Specilaite) 
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