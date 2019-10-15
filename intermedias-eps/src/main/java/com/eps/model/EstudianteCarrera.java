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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nikola
 */
@Entity
@Table(name = "ESTUDIANTE_CARRERA")
@NamedQueries({
    @NamedQuery(name = "EstudianteCarrera.findAll", query = "SELECT e FROM EstudianteCarrera e")})
public class EstudianteCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTUDIANTE_CARRERA")
    private Long idEstudianteCarrera;
    @JoinColumn(name = "FK_CARRERA", referencedColumnName = "CODIGO_CARRERA")
    @ManyToOne
    private Carrera fkCarrera;
    @JoinColumn(name = "FK_ESTUDIANTE_CARNET", referencedColumnName = "CARNET")
    @ManyToOne
    private Estudiante fkEstudianteCarnet;

    public EstudianteCarrera() {
    }

    public EstudianteCarrera(Long idEstudianteCarrera) {
        this.idEstudianteCarrera = idEstudianteCarrera;
    }

    public Long getIdEstudianteCarrera() {
        return idEstudianteCarrera;
    }

    public void setIdEstudianteCarrera(Long idEstudianteCarrera) {
        this.idEstudianteCarrera = idEstudianteCarrera;
    }

    public Carrera getFkCarrera() {
        return fkCarrera;
    }

    public void setFkCarrera(Carrera fkCarrera) {
        this.fkCarrera = fkCarrera;
    }

    public Estudiante getFkEstudianteCarnet() {
        return fkEstudianteCarnet;
    }

    public void setFkEstudianteCarnet(Estudiante fkEstudianteCarnet) {
        this.fkEstudianteCarnet = fkEstudianteCarnet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstudianteCarrera != null ? idEstudianteCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteCarrera)) {
            return false;
        }
        EstudianteCarrera other = (EstudianteCarrera) object;
        if ((this.idEstudianteCarrera == null && other.idEstudianteCarrera != null) || (this.idEstudianteCarrera != null && !this.idEstudianteCarrera.equals(other.idEstudianteCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.EstudianteCarrera[ idEstudianteCarrera=" + idEstudianteCarrera + " ]";
    }
    
}
