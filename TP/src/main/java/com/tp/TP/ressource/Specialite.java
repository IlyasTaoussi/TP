package com.tp.TP.ressource;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Specialite implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSpec;
	
	private String nomSpec;
	
	@OneToMany
	private ArrayList<Etudiant> etudiants;
	
	@OneToMany
	private ArrayList<Module> modules;

	public Specialite(String nomSpec) {
		super();
		this.nomSpec = nomSpec;
	}

	public int getIdSpec() {
		return idSpec;
	}

	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}

	public String getNomSpec() {
		return nomSpec;
	}

	public void setNomSpec(String nomSpec) {
		this.nomSpec = nomSpec;
	}

	public ArrayList<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(ArrayList<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public ArrayList<Module> getModules() {
		return modules;
	}

	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}
	
	
}
