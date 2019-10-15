/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nikola
 */
@Entity
@Table(name = "CARRERA")
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CARRERA")
    private Short codigoCarrera;
    
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;

    public Carrera() {
    }

    public Carrera(Short codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public Short getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(Short codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCarrera != null ? codigoCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codigoCarrera == null && other.codigoCarrera != null) || (this.codigoCarrera != null && !this.codigoCarrera.equals(other.codigoCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.Carrera[ codigoCarrera=" + codigoCarrera + " ]";
    }
    
}
