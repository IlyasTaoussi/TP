package com.tp.TP.ressource;

//Classe/Objet pour Enregistrer Un Module dans la BDD

public class ModuleInput {
	private String nomModule;
	private int idSpec;
	
	
	public ModuleInput() {
		super();
	}


	public String getNomModule() {
		return nomModule;
	}
	
	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}
	
	public int getIdSpec() {
		return idSpec;
	}
	
	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}
	
	
}
