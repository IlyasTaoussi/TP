/**
 * 
 */
$(document).ready(function(){
	window.sessionStorage.setItem("identite","etu");
	$('#subEt').click(function(){
		var email = $('#input-mail').val();
		var passwd = $('#input-psw').val();
		$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/etudiants/logins",
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					window.sessionStorage.setItem("currentSession",data);
				}
			});
	});
});