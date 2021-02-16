package com.tp.TP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Professeur;

public interface ProfesseurRepository extends CrudRepository<Professeur, Integer>{
	List<Professeur> findByNomProf(String nomProf);
	List<Professeur> findByPrenomProf(String prenomProf);
	Professeur findByModule(Module module);
	Professeur findByLoginProf(Logins loginProf);
}
