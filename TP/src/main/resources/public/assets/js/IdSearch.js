/**
 * 
 */
$(document).ready(function(){

	$('#subBtn').click(function(){
		let idInput = $('#idUni').val();
		let choix = $('#choix').val();
		console.log(choix);
		if(choix.localeCompare("etu")){
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
				$.each(resp,function(index,data){
					console.log(data);
					window.sessionStorage.setItem("newRegister", data);
					window.sessionStorage.setItem("choix", choix);
					window.location.replace("http://localhost:8080/Registration.html");	
				});
			});
		}else{
			$.get("http://localhost:8080/TP/professeurs/"+idInput,function(resp){
				$.each(resp,function(index,data){
					console.log(data);
					window.sessionStorage.setItem("newRegister", data);
					window.sessionStorage.setItem("choix", choix);
					window.location.replace("http://localhost:8080/Registration.html");	
				});
			});
		}
	});
});