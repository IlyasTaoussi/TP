package com.tp.TP.ressource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ModEt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idModEt;
	@OneToOne
	private Etudiant etudiant;
	@OneToOne
	private Module module;
	
	//Constructor
	//Getters , Setters
	
}
