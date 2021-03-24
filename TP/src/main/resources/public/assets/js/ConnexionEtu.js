/**
 * 
 */
$(document).ready(function(){
	$('#subEt').click(function(){
		let email = $('#input-mail').val();
		let passwd = $('#input-psw').val();
		$.ajax({
		    	type: "POST",
		    	url: "http://localhost:8080/TP/etudiants/logins",
		    	data: JSON.stringify({ "email": email, "passwd" : passwd}),
		    	contentType: "application/json; charset=utf-8",
		    	dataType: "json",
		    	success: function(data){
		    		console.log(data);
					window.sessionStorage.setItem("currentSession",data);
			//		window.location.replace("http://localhost:8080/PrincipalEtu.html");		
				},
				error: function (jqXHR, ajaxOptions, thrownError) {
        			alert("something went wrong");
    			}
			});
	});
});