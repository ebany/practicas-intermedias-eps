/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.rest;

import com.eps.controller.InstitucionBean;
import com.eps.model.Institucion;
import com.eps.model.ResponseJSON;
import java.util.List;
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
@Path("instituciones")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class InstitucionEndPoint {
    
    @Inject
    InstitucionBean institucionBean;
    
    /**
     *
     * @param nombre
     * @param skip
     * @param limit
     * @return
     */
    @GET
    public ResponseJSON listAll(
            @QueryParam("nombre") @DefaultValue("%") String nombre,
            @QueryParam("skip") @DefaultValue("0") Integer skip,
            @QueryParam("limit") @DefaultValue("0") Integer limit){
        ResponseJSON response = institucionBean.findAll(skip,limit,nombre);
        return response;
    }
    
    @POST
    public ResponseJSON create(@Valid Institucion institucion){
        return institucionBean.create(institucion);
    }
    
    @GET
    @Path("/{id_institucion:[0-9][0-9]*}")
    public ResponseJSON findBy(@PathParam("id_institucion") Long id){
        ResponseJSON response = institucionBean.findInstitucion(id);
        return response;
    }
    
    @PUT
    @Path("/{id_institucion:[0-9][0-9]*}")
    public ResponseJSON update(@PathParam("id_institucion") Long id, @Valid Institucion institucion){
        ResponseJSON response = institucionBean.update(id, institucion);
        return response;
    }
    
    @DELETE
    @Path("/{id_institucion:[0-9][0-9]*}")
    public ResponseJSON delete(@PathParam("id_institucion") Long id){
        ResponseJSON response = institucionBean.delete(id);
        return response;
    }
}
