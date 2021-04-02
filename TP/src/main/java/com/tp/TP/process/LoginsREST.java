package com.tp.TP.process;

import java.util.Optional;

import javax.ws.rs.Consumes;
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
import com.tp.TP.ressource.HashClass;
import com.tp.TP.ressource.LoginInput;
import com.tp.TP.ressource.Logins;
import com.tp.TP.ressource.Professeur;

@Path("logins")
public class LoginsREST {
	
	@Autowired
	private LoginsRepository loginsRepository; //Repository de la classe Logins
	@Autowired
	private EtudiantRepository etudiantRepository; //Repository de la classe Etudiant
	@Autowired
	private ProfesseurRepository professeurRepository; //Repository de la classe Professeur
	
	// POST
	// Methode pour ajouter une entité Logins dans la BDD
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Logins addLogin(Logins m) {
        loginsRepository.save(m);
        return m;
    }
	
	// PATCH /{id}
	// Methode Pour Recuperer L'utilisateur(Etudiant/Professeur) et Enregistrer les nouveaux Logins à leur Entité dans la BDD
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response setLogin(@PathParam("id") int id, LoginInput L) {
		Optional<Etudiant> optE = etudiantRepository.findById(id);
		Optional<Professeur> optP = professeurRepository.findById(id);
		String hashed;
		try {
			String PassToHash = HashClass.StringToSHA256Hash(L.getPasswd());
			hashed = PassToHash;
		} catch (Exception e) {
			System.err.println("Hash Function Error !!");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		Optional<Logins> optL = loginsRepository.findByMailOrPassword(L.getEmail(), hashed);
		if(!optL.isPresent()){
			if(!optE.isPresent()) {
				if(!optP.isPresent()) {
					return Response.status(Response.Status.NOT_FOUND).build();
				}
				Professeur p = optP.get();
				p.setLogin(loginsRepository.save(new Logins(L.getEmail(),hashed)));
				professeurRepository.save(p);
				return Response.ok(p).build();
			}
		
			Etudiant e = optE.get();
			e.setLogin(loginsRepository.save(new Logins(L.getEmail(),hashed)));
			etudiantRepository.save(e);
			return Response.ok(e).build();
		}
		else {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}
	
}
