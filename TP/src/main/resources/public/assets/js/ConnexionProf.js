/**
 * 
 */
$(document).ready(function(){
	window.sessionStorage.setItem("identite","prof");
	$('#subPr').click(function(){
		let email = $('#input-mail').val();
		let passwd = $('#input-psw').val();
		$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/professeurs/logins",
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					window.sessionStorage.setItem("currentSession",JSON.stringify(data));
					window.location.replace("http://localhost:8080/PrincipalProf.html");
				},
				error : function(){
					alert('Introvable !!');
				}
			});
	});
	
	
	
});