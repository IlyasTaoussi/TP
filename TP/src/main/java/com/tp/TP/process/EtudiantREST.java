package com.tp.TP.process;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    public Etudiant addEtudiant(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom){
        Etudiant e = new Etudiant(nom, prenom);
        etudiantRepository.save(e);
        return e;
    }
}