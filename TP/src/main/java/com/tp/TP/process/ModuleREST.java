package com.tp.TP.process;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.ModuleRepository;
import com.tp.TP.repository.SpecialiteRepository;
import com.tp.TP.ressource.Module;
import com.tp.TP.ressource.ModuleInput;
import com.tp.TP.ressource.Specialite;

@Path("modules")
public class ModuleREST {
	
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private SpecialiteRepository speRepository;
	
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
	
}
