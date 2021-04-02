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
	private int idLogin ; //ID du Compte Login
	private String mail; //Mail du Compte Login	
	private String password; // Mot de Passe du Compte Login
	
	/*
	 * Constructeurs
	 */
	
	public Logins() {
		super();
	}

	public Logins(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}

	/*
	 * Getters , Setters , Override Methods
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLogin;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logins other = (Logins) obj;
		if (idLogin != other.idLogin)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
}
