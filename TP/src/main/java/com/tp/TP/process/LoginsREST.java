package com.tp.TP.process;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.EtudiantRepository;
import com.tp.TP.repository.LoginsRepository;
import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Professeur;

@Path("logins")
public class LoginsREST {
	
	@Autowired
	private LoginsRepository loginsRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Logins addLogin(Logins m) {
        loginsRepository.save(m);
        return m;
    }
	
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response setLogin(@PathParam("id") int id, LoginInput L) {
		Optional<Etudiant> optE = etudiantRepository.findById(id);
		Optional<Professeur> optP = professeurRepository.findById(id);
		
		if(!optE.isPresent()) {
			if(!optP.isPresent()) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			Professeur p = optP.get();
			p.setLogin(new Logins(L.getEmail(),L.getPasswd()));
			professeurRepository.save(p);
			return Response.ok(p).build();
		}
		
		Etudiant e = optE.get();
		e.setLogin(new Logins(L.getEmail(),L.getPasswd()));
		etudiantRepository.save(e);
		return Response.ok(e).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idUni}/professeurs")
	public Response getIdProf(@PathParam("idUni") int idUni) {
		Optional<Professeur> optP = professeurRepository.findById(idUni);

		if(!optP.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Professeur p = optP.get();
		professeurRepository.save(p);
		return Response.ok(p).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idUni}/etudiants")
	public Response getIdEtu(@PathParam("idUni") int idUni) {
		Optional<Etudiant> optE = etudiantRepository.findById(idUni);
		
		if(!optE.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		Etudiant e = optE.get();
		etudiantRepository.save(e);
		return Response.ok(e).build();
	}
}
