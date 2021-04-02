package com.tp.TP.ressource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Etudiant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int idEtudiant; //Id de l'Etudiant
	
	private String nomEtu; //Nom de l'Etudiant
	
	private String prenomEtu; //Prenom de l'Etudiant

	@OneToOne
	@JoinColumn(name = "idLogin")
	private Logins loginEtu; // Logins de L'etudiant
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idSpec")
	private Specialite spec; //Specialité de l'etudiant
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Note> notes; //liste des notes de l'etudiant
	
	
	/*
	 * Constructeurs
	 */
	public Etudiant() {
		super();
	}
	
	public Etudiant(int idEtudiant, String nomEtu, String prenomEtu, Logins loginEtu, Specialite spec) {
		super();
		this.idEtudiant = idEtudiant;
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.loginEtu = loginEtu;
		this.spec = spec;
		this.notes = new ArrayList<>();
	}
	
	public Etudiant(String nomEtu, String prenomEtu, Specialite spec) {
		super();
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.spec = spec;
		this.notes = new ArrayList<>();
	}

	public Etudiant(String nomEtu, String prenomEtu) {
		super();
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.notes = new ArrayList<>();
	}
	
	/*
	 * Getters , Setters
	 */
	
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
		return spec;
	}

	public void setSpec(Specialite spec) {
		this.spec = spec;
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nomEtu + ", prenom=" + prenomEtu + ", login="
				+ loginEtu + ", Specialité=" + spec + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEtudiant;
		result = prime * result + ((loginEtu == null) ? 0 : loginEtu.hashCode());
		result = prime * result + ((nomEtu == null) ? 0 : nomEtu.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((prenomEtu == null) ? 0 : prenomEtu.hashCode());
		result = prime * result + ((spec == null) ? 0 : spec.hashCode());
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
		Etudiant other = (Etudiant) obj;
		if (idEtudiant != other.idEtudiant)
			return false;
		if (loginEtu == null) {
			if (other.loginEtu != null)
				return false;
		} else if (!loginEtu.equals(other.loginEtu))
			return false;
		if (nomEtu == null) {
			if (other.nomEtu != null)
				return false;
		} else if (!nomEtu.equals(other.nomEtu))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (prenomEtu == null) {
			if (other.prenomEtu != null)
				return false;
		} else if (!prenomEtu.equals(other.prenomEtu))
			return false;
		if (spec == null) {
			if (other.spec != null)
				return false;
		} else if (!spec.equals(other.spec))
			return false;
		return true;
	}

	
	
	
}
