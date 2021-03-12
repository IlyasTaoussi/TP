package com.tp.TP.process;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp.TP.repository.LoginsRepository;
import com.tp.TP.ressource.Logins;

@Path("logins")
public class LoginsREST {
	
	@Autowired
	private LoginsRepository loginsRepository;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Logins addLogin(Logins m) {
        loginsRepository.save(m);
        return m;
    }
	
	
}
