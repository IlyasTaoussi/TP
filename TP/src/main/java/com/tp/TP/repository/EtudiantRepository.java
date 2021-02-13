package com.tp.TP.repository;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
	
}
