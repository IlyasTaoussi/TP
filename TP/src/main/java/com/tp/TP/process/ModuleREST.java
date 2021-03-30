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

import com.tp.TP.repository.ModuleRepository;
import com.tp.TP.repository.ProfesseurRepository;
import com.tp.TP.repository.SpecialiteRepository;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.ModuleInput;
import com.tp.TP.ressource.Professeur;
import com.tp.TP.ressource.Specialite;

@Path("modules")
public class ModuleREST {
	
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private SpecialiteRepository speRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addModule(ModuleInput module){
		Optional<Specialite> oSpe = speRepository.findById(module.getIdSpec());
		if(!oSpe.isPresent())
			return Response.status(Response.Status.NOT_FOUND).build();
		
		Module m = new Module(module.getNomModule(), oSpe.get());
        moduleRepository.save(m);
        return Response.ok(m).build();
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Module> getAllModules() {
		List<Module> modules = new ArrayList<>();
		moduleRepository.findAll().forEach(modules::add);
		return modules;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idMod}/professeurs")
	public Response getProf(@PathParam("idMod") int idMod) {
		Optional<Module> optM = moduleRepository.findById(idMod);
		if(!optM.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();
		
		Optional<Professeur> optP = professeurRepository.findByModule(optM.get());
		if(!optP.isPresent()) return Response.status(Response.Status.NOT_FOUND).build();

		return Response.ok(optP.get()).build();
	}
}
