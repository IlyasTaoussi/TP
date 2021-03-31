/**
 * 
 */
$(document).ready(function(){
	var student;
	var idEtu;
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	
	$.get("http://localhost:8080/TP/specialites/"+currentSession.module.spe.idSpec+"/etudiants",function(resp){
		$.each(resp,function(index,item){
			$('#etu-select').append('<option value="etu-'+item.idEtudiant+'">'+item.nomEtu+' '+item.prenomEtu+'</option>');
		})
	})
	
	$('#etu-select').change(function(){
		$('#note-body').empty();
		$('#note-body').append('<tr><td class="mod"></td><td class="nom"></td><td class="prenom"></td><td><input type="number" placeholder="Give Mark" id="note-input" required></td><td><button class="btn-sub" >Add</button></td></tr>');
		if($('#etu-select').val() == ''){
			$('div#profil').addClass("hidden").removeClass("visible");
		}else{
			$('div#profil').removeClass("hidden").addClass("visible");
			let idInput = $('#etu-select').val().replace('etu-','');
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
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
	
	$('#note-body').delegate("td button.btn-sub", "click", function() {
    	let note = $('#note-input').val();
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/notes/"+student.idEtudiant,
		    data: JSON.stringify({ "idMod" : currentSession.module.idModule ,"note": note}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
				$('#note-body').append('<tr id="note-'+data.idNote+'"><td class="mod">'+currentSession.module.nomModule+'</td><td class="nom">'+student.nomEtu+'</td><td class="prenom">'+student.prenomEtu+'</td><td>'+data.note+'</td><td><button class="btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" >X</button></td></tr>');
			},
			error: function(){
				alert('Error !!');
			}
		})
		
		
		$('#note-input').val('');
    });
	
	$('#note-body').delegate("td button.btn-danger", "click", function() {
    	let idNote = $(this).parent().parent().attr('id').replace('note-','');
		
    	$.ajax({
		    type: "DELETE",
		    url: "http://localhost:8080/TP/notes/"+idEtu+"/"+idNote ,
		    dataType: "json",
		    success: function(data){
		    	$('#note-'+idNote).remove();
		    },
			error: function(){
				alert('Error while Request Processing');
			}
		});	
    });
})