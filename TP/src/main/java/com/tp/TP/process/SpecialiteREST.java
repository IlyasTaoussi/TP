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
import com.tp.TP.repository.ModuleRepository;
import com.tp.TP.repository.SpecialiteRepository;
import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.Specialite;

@Path("specialites")
public class SpecialiteREST {
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Specialite addSpecialite(Specialite sp){
        specialiteRepository.save(sp);
        return sp;
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idSpe}/modules")
	public Response listeModules(@PathParam("idSpe") int idSpe){
		Optional<Specialite> optS = specialiteRepository.findById(idSpe);
		if(!optS.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
		
		List<Module> listM = moduleRepository.findBySpe(optS.get());
		if(listM.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		
		return Response.ok(listM).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idSpe}/etudiants")
	public Response listeEtudiants(@PathParam("idSpe") int idSpe){
		Optional<Specialite> optS = specialiteRepository.findById(idSpe);
		if(!optS.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
		
		List<Etudiant> listEt = etudiantRepository.findBySpec(optS.get());
		if(listEt.isEmpty()) return Response.status(Response.Status.NOT_FOUND).build();
		
		return Response.ok(listEt).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Specialite> getAllSpe() {
		List<Specialite> specs = new ArrayList<>();
		specialiteRepository.findAll().forEach(specs::add);
		return specs;
	}
}
