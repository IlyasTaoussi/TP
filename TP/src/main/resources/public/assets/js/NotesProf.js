/**
 * 
 */
$(document).ready(function(){
	var student;
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	$.get("http://localhost:8080/TP/specialites/"+currentSession.module.spec.idSpec+"/etudiants",function(resp){
		$.each(resp,function(index,item){
			$('#etu-select').append('<option value="etu-${item.idEtu}">'+item.nomEtu+' '+item.prenomEtu+'</option>');
		})
	})
	
	$('#etu-select').change(function(){
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
		    url: "http://localhost:8080/TP/notes/"+student.idEtu,
		    data: JSON.stringify({ "idMod" : currentSession.module.idModule ,"note": note}),
		    contentType: "application/json; charset=utf-8",
		    dataType: "json",
		    success: function(data){
		    	console.log(data);
				$('#note-body').append('<tr>');
				$('#note-body').append('<td id="mod">'+currentSession.module.nomModule+'</td>');
				$('#note-body').append('<td id="etu-nom">'+student.nomEtu+'</td>');
				$('#note-body').append('<td id="etu-prenom">'+student.prenomEtu+'</td>');
				$('#note-body').append('<td id="note-'+data.idNote+'">'+data.note+'</td>');
				$('#note-body').append('</tr>');
			}
		})
		
		
		$('#note-input').val('');
		return false;
	});
	
	function setEtudiantProfile(data){
		$.get("http://localhost:8080/TP/notes/"+data.idEtu+"/"+currentSession.module.idModule,function(resp){
			$.each(resp, function(index,item){
				$('#note-body').append('<tr>');
				$('#note-body').append('<td id="mod"></td>');
				$('#note-body').append('<td id="etu-nom"></td>');
				$('#note-body').append('<td id="etu-prenom"></td>');
				$('#note-body').append('<td id="note-'+item.idNote+'">'+item.note+'</td>');
				$('#note-body').append('</tr>');
			})
		})
		
		
		$('#etu-nom').html(data.nomEtu);
		$('#etu-prenom').html(data.prenomEtu);
		$('#etu-id').html(data.idEtu);
		$('#etu-spe').html(data.spec.nomSpec);
		$('#mod').html(currentSession.module.nomModule);
	}
})