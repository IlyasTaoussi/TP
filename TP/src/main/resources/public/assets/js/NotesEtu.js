/**
 * 
 */
$(document).ready(function(){
	
	var currentSession = JSON.parse(window.sessionStorage.getItem('currentSession'));
	$.get("http://localhost:8080/TP/specialites/"+currentSession.spec.idSpec+"/modules",function(resp){
		$.each(resp,function(index,item){
			$('#mod-select').append('<option value="mod-'+item.idModule+'">'+item.nomModule+'</option>');
		})
	})
	
	
	$('#mod-select').change(function(){
		$('#note-body').empty();
		let idInput = $('#mod-select').val().replace('mod-','');
		$.get("http://localhost:8080/TP/notes/"+currentSession.idEtudiant+'/'+idInput,function(resp){
			$.each(resp, function(index, item){
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