package com.tp.TP.ressource;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Etudiant implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idEtudiant;
	private String nomEtu;
	private String prenomEtu;

	@OneToOne
	private Logins loginEtu;
	
	@OneToOne
	@JoinColumn(name = "idSpec")
	private Specialite Spec;

	public Etudiant(int idEtudiant, String nomEtu, String prenomEtu, Logins loginEtu, Specialite spec) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.loginEtu = loginEtu;
		Spec = spec;
	}

	public Etudiant() {
		super();
	}

	public Etudiant(String nomEtu, String prenomEtu) {
		super();
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNomEtu() {
		return nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	public String getPrenomEtu() {
		return prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	public Logins getLogin() {
		return loginEtu;
	}

	public void setLogin(Logins loginEtu) {
		this.loginEtu = loginEtu;
	}

	public Specialite getSpec() {
		return Spec;
	}

	public void setSpec(Specialite spec) {
		Spec = spec;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nomEtu + ", prenom=" + prenomEtu + ", login="
				+ loginEtu + ", Specialité=" + Spec + "]";
	}

	
	
}
