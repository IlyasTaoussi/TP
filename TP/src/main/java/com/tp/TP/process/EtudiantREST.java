package com.tp.TP.process;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.EtudiantRepository;
import com.tp.TP.ressource.Etudiant;

@Path("etudiants")
public class EtudiantREST {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Etudiant addEtudiant(Etudiant E){
        return etudiantRepository.save(E);
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> getAllEtudiants(){
		List<Etudiant> etudiants = new ArrayList<>();
		etudiantRepository.findAll().forEach(etudiants::add);
		return etudiants;
	}
	
}
