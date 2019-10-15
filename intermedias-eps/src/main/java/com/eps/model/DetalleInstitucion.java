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
import javax.validation.constraints.Size;

/**
 *
 * @author nikola
 */
@Entity
@Table(name = "DETALLE_INSTITUCION")
@NamedQueries({
    @NamedQuery(name = "DetalleInstitucion.findAll", query = "SELECT d FROM DetalleInstitucion d")})
public class DetalleInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_INSTITUCION")
    private Long idDetalleInstitucion;
    @Size(max = 10)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 50)
    @Column(name = "UBICACION")
    private String ubicacion;
    @JoinColumn(name = "FK_INSTITUCION", referencedColumnName = "ID_INSTITUCION")
    @ManyToOne(optional = false)
    private Institucion fkInstitucion;

    public DetalleInstitucion() {
    }

    public DetalleInstitucion(Long idDetalleInstitucion) {
        this.idDetalleInstitucion = idDetalleInstitucion;
    }

    public Long getIdDetalleInstitucion() {
        return idDetalleInstitucion;
    }

    public void setIdDetalleInstitucion(Long idDetalleInstitucion) {
        this.idDetalleInstitucion = idDetalleInstitucion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Institucion getFkInstitucion() {
        return fkInstitucion;
    }

    public void setFkInstitucion(Institucion fkInstitucion) {
        this.fkInstitucion = fkInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleInstitucion != null ? idDetalleInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleInstitucion)) {
            return false;
        }
        DetalleInstitucion other = (DetalleInstitucion) object;
        if ((this.idDetalleInstitucion == null && other.idDetalleInstitucion != null) || (this.idDetalleInstitucion != null && !this.idDetalleInstitucion.equals(other.idDetalleInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.DetalleInstitucion[ idDetalleInstitucion=" + idDetalleInstitucion + " ]";
    }
    
}
