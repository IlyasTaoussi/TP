package com.tp.TP.process;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfiguration extends ResourceConfig {
   
   public JerseyConfiguration() {
      register(EtudiantREST.class); 
      register(LoginsREST.class);
      register(ModuleREST.class);
      register(SpecialiteREST.class);
      register(ProfesseurREST.class);
   }
}
