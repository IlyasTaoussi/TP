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
	private int idModule;
	
	private String nomModule;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Specialite spe;

	public Module(String nomModule, Specialite spe) {
		super();
		this.nomModule = nomModule;
		this.spe = spe;
	}

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
	
	
}
