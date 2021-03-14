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

import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.ressource.Professeur;

@Path("professeurs")

public class ProfesseurREST {
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Professeur addProfesseur(Professeur p) {
        professeurRepository.save(p);
        return p;
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professeur> getAllEtudiants(){
		List<Professeur> profs = new ArrayList<>();
		professeurRepository.findAll().forEach(profs::add);
		return profs;
	}
}
