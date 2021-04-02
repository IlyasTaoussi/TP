package com.tp.TP.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.LoginsRepository;
import com.tp.TP.repository.ModuleRepository;
import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.ressource.HashClass;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.ProfInput;
import com.tp.TP.ressource.Professeur;

@Path("professeurs")

public class ProfesseurREST {
	@Autowired
	private ProfesseurRepository professeurRepository; //Repository de la classe Professeur
	@Autowired
	private LoginsRepository loginsRepository;	//Repository de la classe Logins
	@Autowired
	private ModuleRepository moduleRepository;	//Repository de la classe Module
	
	// POST
	//Methode POST Pour Créer et Ajouter un nouveau Professeur à la Base de Données
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfesseur(ProfInput inP) {
		Optional<Module> optM = moduleRepository.findById(inP.getIdMod());
		if(!optM.isPresent())
			return Response.status(Response.Status.NOT_FOUND).build();
        Professeur p = new Professeur(inP.getNomProf(), inP.getPrenomProf(),optM.get());
		professeurRepository.save(p);
        return Response.ok(p).build();
    }
	
	// GET
	// Methode GET qui renvoie tous les Professeurs dans la BDD (Unused)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professeur> getAllProfesseurs(){
		List<Professeur> profs = new ArrayList<>();
		professeurRepository.findAll().forEach(profs::add);
		return profs;
	}
	
	// POST /logins
	//Methode qui va mettre à jour les Logins d'Un Professeur et l'enregistre dans la BDD 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("logins")
	public Response getLoginProf(LoginInput LI) {
		String hashed;
		try {
			String PassToHash = HashClass.StringToSHA256Hash(LI.getPasswd());
			hashed = PassToHash;
		} catch (Exception e) {
			System.err.println("Hash Function Error !!");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		Optional<Logins> optL = loginsRepository.findByMailAndPassword(LI.getEmail(),hashed);
		if(!optL.isPresent())
			return Response.status(Response.Status.NOT_FOUND).build();
		Optional<Professeur> optP = professeurRepository.findByLoginProf(optL.get());
		if(!optP.isPresent())
			return Response.status(Response.Status.NOT_FOUND).build();
		
		Professeur P = optP.get();
		return Response.ok(P).build();
	}
	
	// GET /{idInput}
	// Methode qui reçoit un id et Renvoie le professeur correspondant
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idInput}")
	public Response getProf(@PathParam("idInput") int idInput) {
		Optional<Professeur> optP = professeurRepository.findById(idInput);
		if(!optP.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Professeur E = optP.get();
		return Response.ok(E).build();
		
	}
}
