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
	private int idProf; // Id du Professeur

	private String nomProf; // Nom du Professeur
	private String prenomProf; // Prenom du Professeur
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idLogin")
	private Logins loginProf; // Logins du Professeur
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "idModule")
	private Module module; // Module du Professeur
	
	/*
	 * Constructors
	 */
	
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

	/*
	 *Getters , Setters , Override Methods 
	 */
	
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


	@Override
	public String toString() {
		return "Professeur [idProf=" + idProf + ", nomProf=" + nomProf + ", prenomProf=" + prenomProf + ", loginProf="
				+ loginProf + ", module=" + module + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProf;
		result = prime * result + ((loginProf == null) ? 0 : loginProf.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((nomProf == null) ? 0 : nomProf.hashCode());
		result = prime * result + ((prenomProf == null) ? 0 : prenomProf.hashCode());
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
		Professeur other = (Professeur) obj;
		if (idProf != other.idProf)
			return false;
		if (loginProf == null) {
			if (other.loginProf != null)
				return false;
		} else if (!loginProf.equals(other.loginProf))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (nomProf == null) {
			if (other.nomProf != null)
				return false;
		} else if (!nomProf.equals(other.nomProf))
			return false;
		if (prenomProf == null) {
			if (other.prenomProf != null)
				return false;
		} else if (!prenomProf.equals(other.prenomProf))
			return false;
		return true;
	}
	
	
}
