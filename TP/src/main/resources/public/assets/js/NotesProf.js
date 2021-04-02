/**
 *  Traitement Javascript pour la page NotesProf.html
 */
$(document).ready(function(){
	//Variables globales à utiliser partout
	var student;
	var idEtu;
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	
	//Recuperation de la liste des Etudiants ayant la même specialité que l'utilisateur
	$.get("http://localhost:8080/TP/specialites/"+currentSession.module.spe.idSpec+"/etudiants",function(resp){
		$.each(resp,function(index,item){
			$('#etu-select').append('<option value="etu-'+item.idEtudiant+'">'+item.nomEtu+' '+item.prenomEtu+'</option>');
		})
	})
	
	//Detection du changement de l'element HTML 
	$('#etu-select').change(function(){
		//Vide le tableau
		$('#note-body').empty();
		//Ajouter la ligne pour ajouter une note
		$('#note-body').append('<tr><td class="mod"></td><td class="nom"></td><td class="prenom"></td><td><input type="number" placeholder="Give Mark" id="note-input" required></td><td><button class="btn-sub" >Add</button></td></tr>');
		if($('#etu-select').val() == ''){
			//Rendre le tableau invisible si aucun Etudiant choisi
			$('div#profil').addClass("hidden").removeClass("visible");
		}else{
			//Rendre le tableau visible quand un etudiant est choisi
			$('div#profil').removeClass("hidden").addClass("visible");
			let idInput = $('#etu-select').val().replace('etu-','');
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
				//Recuperation des données de l'etudiant choisi et remplir le tableau avec les données de l'etudiant'
				student = resp;
				setEtudiantProfile(resp);
			})
		}
	})
	
	function setEtudiantProfile(data){
		$.get("http://localhost:8080/TP/notes/"+data.idEtudiant+"/"+currentSession.module.idModule,function(resp){
			$.each(resp, function(index,item){
				$('#note-body').append('<tr><td class="mod">'+currentSession.module.nomModule+'</td><td class="nom">'+data.nomEtu+'</td><td class="prenom">'+data.prenomEtu+'</td><td id="note-'+item.idNote+'">'+item.note+'</td><td><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></td></tr>');
				
				
			})
		})
		
		
		$('#etu-nom').html(data.nomEtu);
		$('#etu-prenom').html(data.prenomEtu);
		idEtu = data.idEtudiant;
		$('#etu-spe').html(data.spec.nomSpec);
		$('td.nom').html(data.nomEtu);
		$('td.prenom').html(data.prenomEtu);
		$('td.mod').html(currentSession.module.nomModule);
	}
	
	//Fournir à chaque bouton Ajouter present dans le tableau selectioné la fonction Ajout dans la BDD et dans le document 
	$('#note-body').delegate("td button.btn-sub", "click", function() {
    	let note = $('#note-input').val();
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/notes/"+student.idEtudiant,
		    data: JSON.stringify({ "idMod" : currentSession.module.idModule ,"note": note}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
				//Succes de l'ajout dans la BDD et l'ajout ensuite dans le tableau
				$('#note-body').append('<tr id="note-'+data.idNote+'"><td class="mod">'+currentSession.module.nomModule+'</td><td class="nom">'+student.nomEtu+'</td><td class="prenom">'+student.prenomEtu+'</td><td>'+data.note+'</td><td><button class="btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></td></tr>');
			},
			error: function(){
				//Erreur
				alert('Error while Request Processing');
			}
		})
		
		
		$('#note-input').val('');
    });
	
	//Fournir à chaque bouton supprimer present dans le tableau selectioné la fonction Suppression dans la BDD et dans le document 
	$('#note-body').delegate("td button.btn-danger", "click", function() {
    	let idNote = $(this).parent().parent().attr('id').replace('note-','');
		
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/TP/notes/"+idEtu+"/"+idNote ,
		    dataType: "json",
		    success: function(data){
				//succes de la suppression de la BDD et la suppression ensuite du tableau 
		    	$('#note-'+idNote).remove();
		    },
			error: function(){
				//Erreur
				alert('Error while Request Processing');
			}
		});	
    });
})