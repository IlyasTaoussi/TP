package com.tp.TP.process;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.ModuleRepository;
import com.tp.TP.ressource.Module;

@Path("modules")
public class ModuleREST {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Module addModule(Module m){
        moduleRepository.save(m);
        return m;
    }
}
