package com.tp.TP.ressource;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Module implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModule;
	
	private String nomModule;
	
	@ManyToMany
	private ArrayList<Specialite> specs;

	public Module(String nomModule) {
		super();
		this.nomModule = nomModule;
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
