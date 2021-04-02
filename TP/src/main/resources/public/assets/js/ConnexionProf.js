/**
 * Traitement Javascript pour la page ConnexionProf.html
 */
$(document).ready(function(){
	
	//Enregistrer L'identité de l'utilisateur (Etudiant) pour un traitement dans un autre document
	window.sessionStorage.setItem('identite','prof');
	
	//Boutton Responsable Pour Se Connecter et Acceder à la page principale
	$('#subPr').click(function(){
		let email = $('#input-mail').val();
		let passwd = $('#input-psw').val();
		$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/professeurs/logins",
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
					//enregistrer la session (données) de l'utilisateur
					window.sessionStorage.setItem("currentSession",JSON.stringify(data));
					//diriger l'utilisateur vers la page principale
					window.location.assign("http://localhost:8080/PrincipalProf.html");
				},
				error : function(){
					alert('Introvable !!');
				}
			});
	});
	
	
	
});