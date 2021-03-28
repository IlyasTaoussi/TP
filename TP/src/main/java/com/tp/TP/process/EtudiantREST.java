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
import com.tp.TP.repository.SpecialiteRepository;
import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.EtudiantInput;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Specialite;

@Path("etudiants")
public class EtudiantREST {
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private LoginsRepository loginsRepository;
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEtudiant(EtudiantInput EI){
		Optional<Specialite> optS = specialiteRepository.findById(EI.getIdSpec());
		if(!optS.isPresent())
			return Response.status(Response.Status.NOT_FOUND).build();
		
		Etudiant E = new Etudiant(EI.getNomEtu(), EI.getPrenomEtu(), optS.get());
        etudiantRepository.save(E);
        return Response.ok(E).build();
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
	//	Optional<Logins> optL = loginsRepository.findByMail(LI.getEmail());
		if(!optL.isPresent())
			return Response.status(Response.Status.TOO_MANY_REQUESTS).build();
		Optional<Etudiant> optE = etudiantRepository.findByLoginEtu(optL.get());
		if(!optE.isPresent())
			return Response.status(Response.Status.BAD_REQUEST).build();
		
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
