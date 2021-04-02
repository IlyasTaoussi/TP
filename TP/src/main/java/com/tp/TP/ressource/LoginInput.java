package com.tp.TP.ressource;

//Classe/Objet pour Enregistrer Un Login dans la BDD
public class LoginInput {
	private String email;
	private String passwd;
	
	public LoginInput() {
		super();
	
	}
	
	public LoginInput(String email, String passwd) {
		super();
		this.email = email;
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}
