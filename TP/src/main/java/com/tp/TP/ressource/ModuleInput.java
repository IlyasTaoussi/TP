package com.tp.TP.ressource;

public class ModuleInput {
	private String nomModule;
	private int idSpec;
	
	
	public ModuleInput() {
		super();
	}
	
	
	public ModuleInput(String nomModule, int idSpec) {
		super();
		this.nomModule = nomModule;
		this.idSpec = idSpec;
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
