/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.controller;

import com.eps.model.Institucion;
import com.eps.model.ResponseJSON;
import java.util.List;
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
public class InstitucionBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public ResponseJSON create(Institucion institucion){
        ResponseJSON response = new ResponseJSON();
        if(validationName(institucion.getNombre()) == 0){
            em.persist(institucion);
            response.setData(institucion);
            response.setTotal(1);
        } else {
            response.setError("Ya existe una institución con el mismo nombre");
            response.setTotal(0);
        }
        return response;
    }
    
    public ResponseJSON findInstitucion(Long id){
        ResponseJSON response = new ResponseJSON();
        Institucion data = em.find(Institucion.class,id);
        if(data != null){
            response.setData(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la institución");
        }
        return response;
    }
    
    public Integer validationName(String nombre){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Institucion> query = builder.createQuery(Institucion.class);
        Root<Institucion> root = query.from(Institucion.class);
        query.select(root);
        
        Predicate nameLike = builder.equal(root.get("nombre"), nombre);
        
        query.where(nameLike);
        
        TypedQuery<Institucion> finalQuery = em.createQuery(query);
        Integer count = finalQuery.getResultList().size();
        return count;
    }
    
    public ResponseJSON findAll(Integer skip, Integer limit, String nombre){
        //consulta
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Institucion> query = builder.createQuery(Institucion.class);
        Root<Institucion> root = query.from(Institucion.class);
        query.select(root);
        
        Predicate nameLike = builder.like(root.get("nombre"),"%" + nombre + "%");
        
        query.where(
                nameLike
        );
        
        TypedQuery<Institucion> finalQuery = em.createQuery(query);
        Integer count = finalQuery.getResultList().size();
        if (skip >= 0 && limit > 0) {
            finalQuery.setFirstResult(skip);
            finalQuery.setMaxResults(limit);
        }
        
        List<Institucion> data = finalQuery.getResultList();
        
        //respuesta
        ResponseJSON response = new ResponseJSON(data,count,skip,limit);
        return response;
    }
    
    public ResponseJSON update(Long id, Institucion institucion){
        ResponseJSON response = new ResponseJSON();
        Institucion data = em.find(Institucion.class, id);
        if(data != null && institucion.getIdInstitucion() != null && data.getIdInstitucion().equals(institucion.getIdInstitucion())){
            em.merge(institucion);
            response.setData(institucion);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la institución o no corresponde el identificador");
        }
        return response;
    }
    
    public ResponseJSON delete(Long id){
        ResponseJSON response = new ResponseJSON();
        Institucion data = em.find(Institucion.class, id);
        if(data != null){
            em.remove(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe la institución");
        }
        return response;
    }
}
