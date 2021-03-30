package com.tp.TP;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.tp.TP.process.EtudiantREST;
import com.tp.TP.process.LoginsREST;
import com.tp.TP.process.ModuleREST;
import com.tp.TP.process.NoteREST;
import com.tp.TP.process.ProfesseurREST;
import com.tp.TP.process.SpecialiteREST;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("TP")
public class JerseyConfiguration extends ResourceConfig {
   
   public JerseyConfiguration() {
      register(EtudiantREST.class); 
      register(LoginsREST.class);
      register(ModuleREST.class);
      register(SpecialiteREST.class);
      register(ProfesseurREST.class);
      register(NoteREST.class);
   }
}
