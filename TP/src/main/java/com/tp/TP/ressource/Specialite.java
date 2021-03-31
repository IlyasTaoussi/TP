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
	
	public Specialite(){
		super();
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSpec;
		result = prime * result + ((nomSpec == null) ? 0 : nomSpec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Specialite other = (Specialite) obj;
		if (idSpec != other.idSpec)
			return false;
		if (nomSpec == null) {
			if (other.nomSpec != null)
				return false;
		} else if (!nomSpec.equals(other.nomSpec))
			return false;
		return true;
	}

	
}
