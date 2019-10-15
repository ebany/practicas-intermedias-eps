/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.rest;

import com.eps.controller.EstudianteBean;
import com.eps.model.Estudiante;
import com.eps.model.Institucion;
import com.eps.model.ResponseJSON;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author nikola
 */

@Path("estudiantes")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class EstudianteEndPoint {
    
    @Inject
    EstudianteBean estudianteBean;
    
    @GET
    public ResponseJSON listAll(
            @QueryParam("nombre") @DefaultValue("%") String nombre,
            @QueryParam("skip") @DefaultValue("0") Integer skip,
            @QueryParam("limit") @DefaultValue("0") Integer limit,
            @QueryParam("cui") @DefaultValue("0") Long cui,
            @QueryParam("carnet") @DefaultValue("0") Long carnet){
        ResponseJSON response = estudianteBean.findAll(skip,limit,nombre,carnet,cui);
        return response;
    }
    
    @POST
    public ResponseJSON create(@Valid Estudiante estudiante){
        return estudianteBean.create(estudiante);
    }
    
    @GET
    @Path("/{id_estudiante:[0-9][0-9]*}")
    public ResponseJSON findBy(@PathParam("id_estudiante") Long id){
        ResponseJSON response = estudianteBean.findEstudiante(id);
        return response;
    }
    
    @PUT
    @Path("/{id_estudiante:[0-9][0-9]*}")
    public ResponseJSON update(@PathParam("id_estudiante") Long id, @Valid Estudiante estudiante){
        ResponseJSON response = estudianteBean.update(id, estudiante);
        return response;
    }
    
    @DELETE
    @Path("/{id_estudiante:[0-9][0-9]*}")
    public ResponseJSON delete(@PathParam("id_estudiante") Long id){
        ResponseJSON response = estudianteBean.delete(id);
        return response;
    }
    
}
