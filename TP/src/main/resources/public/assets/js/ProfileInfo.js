/**
 * Traitement Javascript pour la page ProfileInfo.html
 */
$(document).ready(function(){
	//Recuperation des variables globales
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	var identite = window.sessionStorage.getItem('identite');
	
	//Traitement pour Etudiant
	if(identite == 'etu'){
		//Set le menu de l'espace Etudiant
		$('#menu ul').append('<li><a href="PrincipalEtu.html">Home</a></li><li><a href="Library.html">Library</a></li><li><a href="NotesEtu.html">Results/Marks</a></li><li><a href="ProfileInfo.html">Profile Info</a></li><li><a href="about.html">About Site</a></li><li><a href="ConnexionEtu.html">Deconnexion</a></li>');
		
		//Remplir les champs avec les données de L'Etudiant
		$('#idUni').html(currentSession.idEtudiant);
		$('#nom').html(currentSession.nomEtu);
		$('#prenom').html(currentSession.prenomEtu);
		$('#identite').html('Daigaku Seito');
		$('th.spemod').html('Speciality');
		$('#spemod').html(currentSession.spec.nomSpec);
		$('th.ModSpe').html('List of Modules');
		$.get("http://localhost:8080/TP/specialites/"+currentSession.spec.idSpec +"/modules",function(resp){
			$.each(resp,function(index,item){
				$('#ModSpe ul').append('<li id=mod-'+item.idModule+'>'+item.nomModule+'</li>');
			})
		});
		
		
	}
	//Traitement pour Professeur
	else{
		//Set le menu de l'espace Professeur
		$('#menu ul').append('<li><a href="PrincipalProf.html">Home</a></li><li><a href="NotesProf.html">Marks Setting</a></li><li><a href="ProfileInfo.html">Profile Info</a></li><li><a href="about.html">About Site</a></li><li><a href="ConnexionProf.html">Deconnexion</a></li>');
		
		
		
		//Remplir les champs avec les données du professeur
		$('#idUni').html(currentSession.idProf);
		$('#nom').html(currentSession.nom);
		$('#prenom').html(currentSession.prenom);
		$('#identite').html('Daigaku Kyoushi');
		$('th.spemod').html('Module');
		$('#spemod').html(currentSession.spec.nomSpec);
		$('th.ModSpe').html('Speciality');
		$('#ModSpe').empty();
		$('#ModSpe').html(currentSession.module.spe.nomSpec);
	}
})