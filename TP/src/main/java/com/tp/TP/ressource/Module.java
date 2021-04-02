package com.tp.TP.ressource;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Module implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModule; // ID du module
	
	private String nomModule; // Nom du module
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Specialite spe; // La specialite du module

	/*
	 * Constructeur
	 */
	
	public Module(String nomModule, Specialite spe) {
		super();
		this.nomModule = nomModule;
		this.spe = spe;
	}
	
	/*
	 * Getters , Setters , Override Methods
	 */

	public Specialite getSpe() {
		return spe;
	}

	public void setSpe(Specialite spe) {
		this.spe = spe;
	}

	public Module() {
		super();
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	@Override
	public String toString() {
		return "Module [idModule=" + idModule + ", nomModule=" + nomModule + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idModule;
		result = prime * result + ((nomModule == null) ? 0 : nomModule.hashCode());
		result = prime * result + ((spe == null) ? 0 : spe.hashCode());
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
		Module other = (Module) obj;
		if (idModule != other.idModule)
			return false;
		if (nomModule == null) {
			if (other.nomModule != null)
				return false;
		} else if (!nomModule.equals(other.nomModule))
			return false;
		if (spe == null) {
			if (other.spe != null)
				return false;
		} else if (!spe.equals(other.spe))
			return false;
		return true;
	}
	
	
}
