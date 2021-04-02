package com.tp.TP.ressource;

//Classe/Objet pour Enregistrer Un Professeur dans la BDD
public class ProfInput {
	private int idMod;
	private String nomProf;
	private String prenomProf;
	
	public ProfInput() {
		super();
	}

	public int getIdMod() {
		return idMod;
	}

	public void setIdMod(int idMod) {
		this.idMod = idMod;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}
	
	
}
