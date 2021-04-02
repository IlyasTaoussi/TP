/**
 *  Traitement Javascript pour la page NotesEtu.html
 */
$(document).ready(function(){
	//Recuperer du stockage de la session les données de l'utilisateur
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	//Recuperer la liste des modules selon la specialité de l'utilisateur'
	$.get("http://localhost:8080/TP/specialites/"+currentSession.spec.idSpec+"/modules",function(resp){
		$.each(resp,function(index,item){
			//Ajout des données reçus dans le tableau
			$('#mod-select').append('<option value="mod-'+item.idModule+'">'+item.nomModule+'</option>');
		})
	})
	//Recuperer toute la liste des notes de l'Etudiant'
	$.get("http://localhost:8080/TP/notes/"+currentSession.idEtudiant,function(resp){
			$.each(resp, function(index, item){
				//Ajouter les données Au tableau
				setNoteTable(item);
			})
		})
	
	//Detecter le changement de la valeur dans l'element HTML
	$('#mod-select').change(function(){
		//vider le tableau pour les nouvelles données demandées par l'utilisateur'
		$('#note-body').empty();
		let idInput = $('#mod-select').val().replace('mod-','');
		$.get("http://localhost:8080/TP/notes/"+currentSession.idEtudiant+'/'+idInput,function(resp){
			$.each(resp, function(index, item){
				//Ajouter les données Au tableau
				setNoteTable(item);
			})
		})
		
	});
	
	function setNoteTable(data){
		$.get("http://localhost:8080/TP/modules/"+data.mod.idModule+"/professeurs",function(resp){
			$('#note-body').append('<tr id="'+data.idNote+'">'
									+'<td>'+data.mod.nomModule +'</td>'
									+'<td>'+resp.nom +'</td>'
									+'<td>'+resp.prenom+'</td>'
									+'<td>'+data.note+'</td>'
									+'</tr>');
		})

	}
	
})