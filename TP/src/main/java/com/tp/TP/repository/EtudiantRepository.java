package com.tp.TP.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Specialite;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {
	List<Etudiant> findByNomEtu(String nomEtu);
	List<Etudiant> findByPrenomEtu(String prenomEtu);
	List<Etudiant> findBySpec(Specialite spec);
	Optional<Etudiant> findByLoginEtu(Logins Login);
}
