package com.tp.TP.ressource;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logins implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLogin ;
	private String mail;
	private String password;
	
	public Logins() {
		super();
	}

	public Logins(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Logins [idLogin=" + idLogin + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
	
}
