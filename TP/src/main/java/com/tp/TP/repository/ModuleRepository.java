package com.tp.TP.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.Specialite;

public interface ModuleRepository extends CrudRepository<Module, Integer> {
	Module findByNomModule(String nomModule);
	List<Module> findBySpecialite(Specialite specialite);
	
}
