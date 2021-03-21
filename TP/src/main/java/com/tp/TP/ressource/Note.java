package com.tp.TP.ressource;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	private Module mod;
	@OneToOne(cascade=CascadeType.ALL)
	private Etudiant et;
	
	private double note;

	public Note() {
		super();
	}

	public Note(Module mod, Etudiant et, double note) {
		super();
		this.mod = mod;
		this.et = et;
		this.note = note;
	}

	public int getIdNote() {
		return idNote;
	}

	public void setIdNote(int idNote) {
		this.idNote = idNote;
	}

	public Module getMod() {
		return mod;
	}

	public void setMod(Module mod) {
		this.mod = mod;
	}

	public Etudiant getEt() {
		return et;
	}

	public void setEt(Etudiant et) {
		this.et = et;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
}
