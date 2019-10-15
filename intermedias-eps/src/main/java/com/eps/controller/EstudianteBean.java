/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.controller;

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
public class EstudianteBean {

    @PersistenceContext
    EntityManager em;
    
    public ResponseJSON create(Estudiante estudiante){
        ResponseJSON response = new ResponseJSON();
        Estudiante data = em.find(Estudiante.class,estudiante.getCarnet());
        if(data != null){
            response.setError("Ya existe el numero de carnet");
            response.setTotal(0);
        } else {
            em.persist(estudiante);
            response.setData(estudiante);
            response.setTotal(1);
        }
        return response;
    }
    
    public ResponseJSON findAll(Integer skip, Integer limit, String nombre, Long carnet, Long cui){
        //consulta
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);
        Root<Estudiante> root = query.from(Estudiante.class);
        query.select(root);
        
        Predicate general = builder.like(root.get("nombre"),"%" + nombre + "%");
        if(carnet > 0){
            general = builder.and(builder.equal(root.get("carnet"), carnet),general);
        }
        if(cui > 0){
            general = builder.and(builder.equal(root.get("cui"), cui));
        }
        
        query.where(
                general
        );
        
        TypedQuery<Estudiante> finalQuery = em.createQuery(query);
        Integer count = finalQuery.getResultList().size();
        if (skip >= 0 && limit > 0) {
            finalQuery.setFirstResult(skip);
            finalQuery.setMaxResults(limit);
        }
        List<Estudiante> data = finalQuery.getResultList();
        
        //respuesta
        ResponseJSON response = new ResponseJSON(data,count,skip,limit);
        return response;
    }
    
    public ResponseJSON findEstudiante(Long carnet){
        ResponseJSON response = new ResponseJSON();
        Estudiante data = em.find(Estudiante.class,carnet);
        if(data != null){
            response.setData(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe el estudiante");
        }
        return response;
    }
    
    public ResponseJSON update(Long id, Estudiante estudiante){
        ResponseJSON response = new ResponseJSON();
        Estudiante data = em.find(Estudiante.class, id);
        if(data != null && estudiante.getCarnet() != null && Objects.equals(data.getCarnet(), estudiante.getCarnet())){
            em.merge(estudiante);
            response.setData(estudiante);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe el estudiante o no corresponde el carnet");
        }
        return response;
    }
    
    public ResponseJSON delete(Long id){
        ResponseJSON response = new ResponseJSON();
        Estudiante data = em.find(Estudiante.class, id);
        if(data != null){
            em.remove(data);
            response.setTotal(1);
        } else {
            response.setTotal(0);
            response.setError("No existe el estudiante");
        }
        return response;
    }
    
}
