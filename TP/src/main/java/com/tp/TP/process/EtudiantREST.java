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

import com.tp.TP.repository.EtudiantRepository;
import com.tp.TP.repository.LoginsRepository;
import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;

@Path("etudiants")
public class EtudiantREST {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private LoginsRepository loginsRepository;
	
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("logins")
	public Response getLoginEtu(LoginInput LI) {
		Optional<Logins> optL = loginsRepository.findByMailAndPassword(LI.getEmail(), LI.getPasswd());
		if(!optL.isPresent())
			Response.status(Response.Status.NOT_FOUND).build();
		Optional<Etudiant> optE = etudiantRepository.findByLoginEtu(optL.get());
		if(!optE.isPresent())
			Response.status(Response.Status.NOT_FOUND).build();
		
		Etudiant E = optE.get();
		return Response.ok(E).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idInput}")
	public Response getEtu(@PathParam("idInput") int idEtu) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		if(!optE.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Etudiant E = optE.get();
		return Response.ok(E).build();
		
	}
}
