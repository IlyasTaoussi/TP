package com.tp.TP.ressource;

//Classe/Objet pour Enregistrer Un Etudiant dans la BDD
public class EtudiantInput {
	
	private String nomEtu;
	private String prenomEtu;
	private int idSpec;
	
	public EtudiantInput() {
		super();
	}

	public EtudiantInput(String nomEtu, String prenomEtu, int idSpec) {
		super();
		this.nomEtu = nomEtu;
		this.prenomEtu = prenomEtu;
		this.idSpec = idSpec;
	}

	public String getNomEtu() {
		return nomEtu;
	}

	public void setNomEtu(String nomEtu) {
		this.nomEtu = nomEtu;
	}

	public String getPrenomEtu() {
		return prenomEtu;
	}

	public void setPrenomEtu(String prenomEtu) {
		this.prenomEtu = prenomEtu;
	}

	public int getIdSpec() {
		return idSpec;
	}

	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}
	
	
}
