package com.tp.TP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Specialite;

public interface SpecialiteRepository extends CrudRepository<Specialite, Integer> {
	List<Specialite> findByModule(Module module);
	Specialite findByNomSpec(String nomSpec);
	
}
