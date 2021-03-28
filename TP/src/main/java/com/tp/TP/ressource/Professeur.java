package com.tp.TP.ressource;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idLogin")
	private Logins loginProf;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "idModule")
	private Module module;
	
	public Professeur(String nomProf, String prenomProf) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
	}
	
	public Professeur(String nomProf, String prenomProf, Module module) {
		super();
		this.nomProf = nomProf;
		this.prenomProf = prenomProf;
		this.module = module;
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

	public Logins getLogin() {
		return loginProf;
	}

	public void setLogin(Logins loginProf) {
		this.loginProf = loginProf;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	
}
