/**
 * 
 */
$(document).ready(function(){
	var student;
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	
	$.get("http://localhost:8080/TP/specialites/"+currentSession.module.spe.idSpec+"/etudiants",function(resp){
		$.each(resp,function(index,item){
			console.log(item);
			$('#etu-select').append('<option value="etu-'+item.idEtudiant+'">'+item.nomEtu+' '+item.prenomEtu+'</option>');
		})
	})
	
	$('#etu-select').change(function(){
		$('#note-body').empty();
		$('#note-body').append('<tr>'
							+'<td class="mod"></td>'
							+'<td class="nom"></td>'
							+'<td class="prenom"></td>'
							+'<td ><input type="number" placeholder="Give Mark" id="note-input" required></td>'
							+'<td><button id="subNoteBtn" >Add</button></td>'
						+'</tr>');
		if($('#etu-select').val() == ''){
			$('div#profil').addClass("hidden").removeClass("visible");
		}else{
			$('div#profil').removeClass("hidden").addClass("visible");
			let idInput = $('#etu-select').val().replace('etu-','');
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
				console.log(resp);
				student = resp;
				setEtudiantProfile(resp);
			})
		}
	})
	
	$('#subNoteBtn').click(function(){
		let note = $('#note-input').val();
		$.ajax({
			type: "POST",
		    url: "http://localhost:8080/TP/notes/"+student.idEtudiant,
		    data: JSON.stringify({ "idMod" : currentSession.module.idModule ,"note": note}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
				$('#note-body').append('<tr>');
				$('#note-body').append('<td class="mod">'+currentSession.module.nomModule+'</td>');
				$('#note-body').append('<td class="nom">'+student.nomEtu+'</td>');
				$('#note-body').append('<td class="prenom">'+student.prenomEtu+'</td>');
				$('#note-body').append('<td id="note-'+data.idNote+'">'+data.note+'</td>');
				$('#note-body').append('</tr>');
			}
		})
		
		
		$('#note-input').val('');
		return false;
	});
	
	function setEtudiantProfile(data){
		$.get("http://localhost:8080/TP/notes/"+data.idEtudiant+"/"+currentSession.module.idModule,function(resp){
			$.each(resp, function(index,item){
				$('#note-body').append('<tr>');
				$('#note-body').append('<td class="mod">'+currentSession.module.nomModule+'</td>');
				$('#note-body').append('<td class="nom">'+data.nomEtu+'</td>');
				$('#note-body').append('<td class="prenom">'+data.prenomEtu+'</td>');
				$('#note-body').append('<td id="note-'+item.idNote+'">'+item.note+'</td>');
				$('#note-body').append('</tr>');
			})
		})
		
		
		$('#etu-nom').html(data.nomEtu);
		$('#etu-prenom').html(data.prenomEtu);
		$('#etu-id').html(data.idEtudiant);
		$('#etu-spe').html(data.spec.nomSpec);
		$('td.nom').html(data.nomEtu);
		$('td.prenom').html(data.prenomEtu);
		$('td.mod').html(currentSession.module.nomModule);
	}
})