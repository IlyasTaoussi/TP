package com.tp.TP.process;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.SpecialiteRepository;
import com.tp.TP.ressource.Specialite;

@Path("specialites")
public class SpecialiteREST {
	
	@Autowired
	private SpecialiteRepository specialiteRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Specialite addSpecialite(Specialite sp){
        specialiteRepository.save(sp);
        return sp;
    }
	
}
