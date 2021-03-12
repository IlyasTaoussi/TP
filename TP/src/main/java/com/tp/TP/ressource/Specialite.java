package com.tp.TP.ressource;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialite implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSpec;
	
	private String nomSpec;
	

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

	
}
