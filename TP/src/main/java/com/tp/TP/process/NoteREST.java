package com.tp.TP.process;

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
import com.tp.TP.repository.NoteRepository;
import com.tp.TP.ressource.Etudiant;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.Note;
import com.tp.TP.ressource.NoteInput;

@Path("notes")
public class NoteREST {
	
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idEtu}")
	public Response setNote(@PathParam("idEtu") int idEtu, NoteInput nIn) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		Optional<Module> optM = moduleRepository.findById(nIn.getIdMod());
		if((!optE.isPresent()) || (!optM.isPresent())) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Etudiant e = optE.get();
		Note n = new Note(optM.get(),optE.get() ,nIn.getNote());
		e.getNotes().add(n);
		noteRepository.save(n);
		etudiantRepository.save(e);
		return Response.ok(n).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idEtu}")
	public Response getNotes(@PathParam("idEtu") int idEtu) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		if((!optE.isPresent())) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(optE.get()).build();
	}
	
	
}
