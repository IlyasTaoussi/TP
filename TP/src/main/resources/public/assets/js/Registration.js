/**
 * Traitement Javascript pour la page Registration.html
 */
$(document).ready(function(){
	
	
	//Recuperation des variables globales
	var currentReg = JSON.parse(window.sessionStorage.getItem("newRegister"));
	var choix = window.sessionStorage.getItem("choix");
	
	//Verification des condition pour Traitement des JSON sans Erreur
	if(choix == 'etu'){
		$('#nom-output').html(currentReg.nomEtu);
		$('#prenom-output').html(currentReg.prenomEtu);
		$('#spemod-output').html(currentReg.spec.nomSpec);
	}else{
		$('#nom-output').html(currentReg.nom);
		$('#prenom-output').html(currentReg.prenom);
		$('#spemod-output').html(currentReg.module.nomModule);
	}
	
	//Bouton pour lancer la requete PATCH
	$('#setLogBtn').click(function(){
		let email = $('#mail-input').val();
		let passwd = $('#psw-input').val();
		if(choix == 'etu'){
			$.ajax({
				type: "PATCH",
		    	url: "http://localhost:8080/TP/logins/"+currentReg.idEtudiant,
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
					//Succes
		    		alert('Account Created ! Yatta !! Omedetou !!!!');
					//Redirection à la page de connexion
					window.location.assign("http://localhost:8080/ConnexionEtu.html")
				},
				error: function(){
					//Erreur
					alert('Credintials Already Exists , Please Modify them !');
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
					//Succes
		    		alert('Account Created ! Yatta !! Omedetou !!!! ');
					//Redirection à la page de connexion
					window.location.assign("http://localhost:8080/ConnexionProf.html");
				},
				error: function(){
					//Erreur
					alert('Credintials Already Exists , Please Modify them !');
				}
			});
		}
	})
	
	
});