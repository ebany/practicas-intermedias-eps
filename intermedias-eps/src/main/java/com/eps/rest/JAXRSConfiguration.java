package com.eps.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
@ApplicationPath("rest")
public class JAXRSConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        
        //resources.add(JacksonFeature.class);
        resources.add(InstitucionEndPoint.class);
        resources.add(EstudianteEndPoint.class);
        resources.add(CarreraEndPoint.class);
        
        return resources; 
    }
}
