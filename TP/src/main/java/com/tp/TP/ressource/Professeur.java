package com.tp.TP.ressource;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Professeur implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProf;

	private String nomProf;
	private String prenomProf;
	
	@OneToOne
	@JoinColumn(name = "idLogin")
	private Logins loginProf;
	
	@OneToOne
	@JoinColumn(name = "idModule")
	private Module module;
	
	public Professeur(String nomProf, String prenomProf) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
	}

	public Professeur() {
		super();
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

	public String getNom() {
		return nomProf;
	}

	public void setNom(String nom) {
		this.nomProf = nom;
	}

	public String getPrenom() {
		return prenomProf;
	}

	public void setPrenom(String prenom) {
		this.prenomProf = prenom;
	}

	public Logins getIdLogin() {
		return loginProf;
	}

	public void setIdLogin(Logins loginProf) {
		this.loginProf = loginProf;
	}

	public Module getIdModule() {
		return module;
	}

	public void setIdModule(Module module) {
		this.module = module;
	}
	
	
}