package com.tp.TP.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Professeur;

public interface ProfesseurRepository extends CrudRepository<Professeur, Integer>{
	List<Professeur> findByNomProf(String nomProf);
	List<Professeur> findByPrenomProf(String prenomProf);
	Optional<Professeur> findByModule(Module module);
	Optional<Professeur> findByLoginProf(Logins loginProf);
}
