/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.controller;

import com.eps.model.Carrera;
import com.eps.model.Estudiante;
import com.eps.model.ResponseJSON;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author nikola
 */
@Stateless
public class CarreraBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public ResponseJSON create(Carrera carrera){
        ResponseJSON response = new ResponseJSON();
        Carrera data = em.find(Carrera.class,carrera.getCodigoCarrera());
        if(data != null){
            response.setError("Ya existe el codigo de carrera");
            response.setTotal(0);
        } else {
            em.persist(carrera);
            response.setData(carrera);
            response.setTotal(1);
        }
        return response;
    }
    
    public ResponseJSON findAll(Integer skip, Integer limit, String nombre){
        //consulta
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Carrera> query = builder.createQuery(Carrera.class);
        Root<Carrera> root = query.from(Carrera.class);
        query.select(root);
        
        Predicate general = builder.like(root.get("nombre"),"%" + nombre + "%");
        query.where(
                general
        );
        
        TypedQuery<Carrera> finalQuery = em.createQuery(query);
        Integer count = finalQuery.getResultList().size();
        if (skip >= 0 && limit > 0) {
            finalQuery.setFirstResult(skip);
            finalQuery.setMaxResults(limit);
        }
        List<Carrera> data = finalQuery.getResultList();
        
        //respuesta
        ResponseJSON response = new ResponseJSON(data,count,skip,limit);
        return response;
    }
    
    public ResponseJSON findCarrera(Short codigo){
        ResponseJSON response = new ResponseJSON();
        Carrera data = em.find(Carrera.class,codigo);
        if(data != null){
            response.setData(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la carrera");
        }
        return response;
    }
    
    public ResponseJSON update(Short id, Carrera carrera){
        ResponseJSON response = new ResponseJSON();
        Carrera data = em.find(Carrera.class, id);
        if(data != null && carrera.getCodigoCarrera() != null && Objects.equals(data.getCodigoCarrera(), carrera.getCodigoCarrera())){
            em.merge(carrera);
            response.setData(carrera);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la carrera o no corresponde el código");
        }
        return response;
    }
    
    public ResponseJSON delete(Short id){
        ResponseJSON response = new ResponseJSON();
        Carrera data = em.find(Carrera.class, id);
        if(data != null){
            em.remove(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la carrera");
        }
        return response;
    }
    
}
