/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.rest;

import com.eps.controller.CarreraBean;
import com.eps.model.Carrera;
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
@Path("carreras")
@RequestScoped
@Produces("application/json")
@Consumes("application/json")
public class CarreraEndPoint {
    
    @Inject
    CarreraBean carreraBean;
    
    @GET
    public ResponseJSON listAll(
            @QueryParam("nombre") @DefaultValue("%") String nombre,
            @QueryParam("skip") @DefaultValue("0") Integer skip,
            @QueryParam("limit") @DefaultValue("0") Integer limit){
        ResponseJSON response = carreraBean.findAll(skip,limit,nombre);
        return response;
    }
    
    @POST
    public ResponseJSON create(@Valid Carrera carrera){
        return carreraBean.create(carrera);
    }
    
    @GET
    @Path("/{id_carrera:[0-9][0-9]*}")
    public ResponseJSON findBy(@PathParam("id_carrera") Short id){
        ResponseJSON response = carreraBean.findCarrera(id);
        return response;
    }
    
    @PUT
    @Path("/{id_carrera:[0-9][0-9]*}")
    public ResponseJSON update(@PathParam("id_carrera") Short id, @Valid Carrera carrera){
        ResponseJSON response = carreraBean.update(id, carrera);
        return response;
    }
    
    @DELETE
    @Path("/{id_carrera:[0-9][0-9]*}")
    public ResponseJSON delete(@PathParam("id_carrera") Short id){
        ResponseJSON response = carreraBean.delete(id);
        return response;
    }
}
