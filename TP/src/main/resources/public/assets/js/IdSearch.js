/**
 * 
 */
$(document).ready(function(){

	$('#subBtn').click(function(){
		let idInput = $('#idUni').val();
		let choix = $('#choix').val();
		if(choix == 'etu'){
			$.get("http://localhost:8080/TP/etudiants/"+idInput,function(resp){
					console.log(resp);
					window.sessionStorage.setItem("newRegister", JSON.stringify(resp));
					window.sessionStorage.setItem("choix", choix);
					window.location.replace("http://localhost:8080/Registration.html");	
			});
		}else{
			$.get("http://localhost:8080/TP/professeurs/"+idInput,function(resp){
					console.log(resp);
					window.sessionStorage.setItem("newRegister", JSON.stringify(resp));
					window.sessionStorage.setItem("choix", choix);
					window.location.replace("http://localhost:8080/Registration.html");	
				});
		}
		return false;
	});
});