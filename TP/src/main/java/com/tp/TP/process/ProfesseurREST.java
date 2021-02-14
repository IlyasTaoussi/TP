package com.tp.TP.process;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.ressource.Professeur;

@Path("professeurs")

public class ProfesseurREST {
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professeur addProfesseur(@QueryParam("nom") String nom, @QueryParam("prenom") String prenom){
        Professeur p = new Professeur(nom, prenom);
        professeurRepository.save(p);
        return p;
    }
}
