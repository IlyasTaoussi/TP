package com.tp.TP.ressource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNote;
	
	@OneToOne
	private ModEt modEt;
	
	private int note;
	//Constructor
	//Getters , Setters 
}
