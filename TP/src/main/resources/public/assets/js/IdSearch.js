/**
 * 
 */
$(document).ready(function(){
	$('#subBtn').click(function(){
		var idInput = $('#idUni').val();
		var choix = $('#choix').val();
		if(choix.localeCompare("etu")){
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
				$.each(resp,function(index,data){
					console.log(data);
					window.sessionStorage.setItem("newRegister", data);
					window.sessionStorage.setItem("choix", choix);
				});
			});
		}else{
			$.get("http://localhost:8080/TP/professeurs/"+idInput,function(resp){
				$.each(resp,function(index,data){
					console.log(data);
					window.sessionStorage.setItem("newRegister", data);
					window.sessionStorage.setItem("choix", choix);
				});
			});
		}
	});
});