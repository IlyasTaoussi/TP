package com.tp.TP.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
	private NoteRepository noteRepository; // Repository de la classe Note
	@Autowired
	private EtudiantRepository etudiantRepository; // Repository de la classe Etudiant
	@Autowired
	private ModuleRepository moduleRepository; // Repository de la classe Module
	
	// POST /{idEtu}
	// Methode pour Ajouter une note à l'Etudiant avec l'ID present dans le @Path
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idEtu}")
	public Response setNote(@PathParam("idEtu") int idEtu, NoteInput nIn) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		Optional<Module> optM = moduleRepository.findById(nIn.getIdMod());
		if((!optM.isPresent())) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		if((!optE.isPresent())) {
			return Response.status(Response.Status.BAD_GATEWAY).build();
		}
		
		Etudiant e = optE.get();
		Note n = new Note(optM.get(),nIn.getNote());
		e.getNotes().add(n);
		
		noteRepository.save(n);
		etudiantRepository.save(e);
		return Response.ok(n).build();
	}
	
	// GET /{idEtu}
	// Methode pour recuperer la liste des notes de L'etudiant avec l'ID dans le @Path
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idEtu}")
	public Response getNotes(@PathParam("idEtu") int idEtu) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		if((!optE.isPresent())) {
			return Response.status(Response.Status.FORBIDDEN).build();
		}
		return Response.ok(optE.get().getNotes()).build();
	}
	
	// GET /{idEtu}/{idMod}
	// Methode Pour Recuprer La liste des notes de l'Etudiant Ayant L'idEtu dans le @Path et concernant le Module avec l'idMod dans le @Path
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idEtu}/{idMod}")
	public Response getNotesMod(@PathParam("idEtu") int idEtu, @PathParam("idMod") int idMod) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		if((!optE.isPresent())) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		List<Note> notesM = new ArrayList<>(); 
		optE.get().getNotes().forEach(n -> {if(n.getMod().getIdModule() == idMod) notesM.add(n);});
		return Response.ok(notesM).build();
	}
	
	// DELETE /{idEtu}/{idNote}
	// Methode Pour Supprimer une note avec l'idNote dans le @Path , de la liste de l'Etudiant ayant l'idEtu qui est dans le @Path
	@DELETE
	@Path("{idEtu}/{idNote}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePersonne(@PathParam("idEtu") int idEtu, @PathParam("idNote") int idNote) {
		Optional<Etudiant> optE = etudiantRepository.findById(idEtu);
		Optional<Note> optN = noteRepository.findById(idNote);
		if((!optE.isPresent()) || (!optN.isPresent())) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		Etudiant e = optE.get();
		e.getNotes().remove(optN.get());
		etudiantRepository.save(e);
		noteRepository.deleteById(idNote);
		
		
		return Response.noContent().build();
	}
}
