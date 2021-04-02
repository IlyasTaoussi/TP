/**
 *  Traitement Javascript pour la page IdSearch.html
 */
$(document).ready(function(){
	
	//Bouton pour effectuer la recherche de l'ID de l'utilisateur dans la BDD 
	$('#subBtn').click(function(){
		let idInput = $('#idUni').val();
		let choix = $('#choix').val();
		//Recuperation et Verification de la donnée (Etu/Prof)
		if(choix == 'etu'){
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
					//Recuperer les données de L'utilisateur'
					window.sessionStorage.setItem("newRegister", JSON.stringify(resp));
					window.sessionStorage.setItem("choix", choix);
					//Diriger l'utilisateur vers la page de l'inscription'
					window.location.assign("http://localhost:8080/Registration.html");	
			});
		}else{
			$.get("http://localhost:8080/TP/professeurs/"+idInput,function(resp){
					window.sessionStorage.setItem("newRegister", JSON.stringify(resp));
					window.sessionStorage.setItem("choix", choix);
					window.location.assign("http://localhost:8080/Registration.html");	
				});
		}
		return false;
	});
});