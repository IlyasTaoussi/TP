package com.tp.TP.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.Logins;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
	List<Etudiant> findByNomEtu(String nomEtu);
	List<Etudiant> findByPrenomEtu(String prenomEtu);
	Etudiant findByLoginEtu(Logins loginEtu);
	
}
