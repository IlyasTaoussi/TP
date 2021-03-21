package com.tp.TP.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.LoginsRepository;
import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Professeur;

@Path("professeurs")

public class ProfesseurREST {
	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private LoginsRepository loginsRepository;
	
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("logins")
	public Response getLoginEtu(LoginInput LI) {
		Optional<Logins> optL = loginsRepository.findByMailAndPassword(LI.getEmail(), LI.getPasswd());
		if(!optL.isPresent())
			Response.status(Response.Status.NOT_FOUND).build();
		Optional<Professeur> optP = professeurRepository.findByLoginProf(optL.get());
		if(!optP.isPresent())
			Response.status(Response.Status.NOT_FOUND).build();
		
		Professeur P = optP.get();
		return Response.ok(P).build();
	}
}
