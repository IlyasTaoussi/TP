package com.tp.TP.ressource;

//Classe/Objet pour Enregistrer Une Note dans la BDD
public class NoteInput {
	private int idMod;
	private double note;
	
	public NoteInput(int idMod, double note) {
		super();
		this.idMod = idMod;
		this.note = note;
	}
	
	public NoteInput() {
		super();
		
	}

	public int getIdMod() {
		return idMod;
	}

	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}
	
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
}
