/**
 * 
 */
$(document).ready(function(){
	var currentReg = JSON.parse(window.sessionStorage.getItem("newRegister"));
	console.log(currentReg.nom);
	var choix = window.sessionStorage.getItem("choix");
	if(choix.localeCompare('etu')){
		$('#nom-output').html(currentReg.nomEtu);
		$('#prenom-output').html(currentReg.prenomEtu);
		$('#spemod-output').html(currentReg.spec.nomSpec);
	}else{
		$('#nom-output').html(currentReg.nom);
		$('#prenom-output').html(currentReg.prenom);
		$('#spemod-output').html(currentReg.module.nomModule);
	}
	
	$('#setLogBtn').click(function(){
		var email = $('#mail-input').val();
		var passwd = $('#psw-input').val();
		if(choix.localeCompare("etu")){
			$.ajax({
				type: "PATCH",
		    	url: "http://localhost:8080/TP/logins/"+currentReg.idEtudiant,
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					window.location.replace("http://localhost:8080/ConnexionEtu.html")
				}
			});
		}else{
			$.ajax({
				type: "PATCH",
		    	url: "http://localhost:8080/TP/logins/"+currentReg.idProf,
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);	
					window.location.replace("http://localhost:8080/ConnexionProf.html");
				}
			});
		}
	})
})