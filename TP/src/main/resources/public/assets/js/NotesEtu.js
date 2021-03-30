/**
 * 
 */
$(document).ready(function(){
	
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	$.get("http://localhost:8080/TP/specialites/"+currentSession.spec.idSpec+"/modules",function(resp){
		$.each(resp,function(index,item){
			$('#mod-select').append('<option value="mod-${item.idModule}">'+item.nomModule+'</option>');
		})
	})
	
	
	$('#mod-select').change(function(){
		$('#note-body').empty();
		let idInput = $('#mod-select').val().replace('mod-','');
		$.get("http://localhost:8080/TP/notes/"+currentSession.idEtu+'/'+idInput,function(resp){
			$.each(resp, function(index, item){
				console.log(item);
				setNoteTable(item);
			})
		})
		
	});
	
	function setNoteTable(data){
		$.get("http://localhost:8080/TP/modules/"+data.module.idModule+"professeurs",function(resp){
			$('#note-body').append('<tr id="'+data.idNote+'">');
			$('#note-body').append('<td>'+data.idModule.nomModule +'<td>');
			$('#note-body').append('<td>'+resp.nom +'<td>');
			$('#note-body').append('<td>'+resp.prenom+'<td>');
			$('#note-body').append('<td>'+data.note+'<td>');
			$('#note-body').append('</tr>');
		})

	}
	
})