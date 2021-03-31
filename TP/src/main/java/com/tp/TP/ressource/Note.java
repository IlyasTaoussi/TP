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
	
	@OneToOne
	private Module mod;
	
	private double note;

	public Note() {
		super();
	}

	public Note(Module mod, double note) {
		super();
		this.mod = mod;
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

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNote;
		result = prime * result + ((mod == null) ? 0 : mod.hashCode());
		long temp;
		temp = Double.doubleToLongBits(note);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Note other = (Note) obj;
		if (idNote != other.idNote)
			return false;
		if (mod == null) {
			if (other.mod != null)
				return false;
		} else if (!mod.equals(other.mod))
			return false;
		if (Double.doubleToLongBits(note) != Double.doubleToLongBits(other.note))
			return false;
		return true;
	}
	
	
}
