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
@Table(name = "DETALLE_CARTA")
@NamedQueries({
    @NamedQuery(name = "DetalleCarta.findAll", query = "SELECT d FROM DetalleCarta d")})
public class DetalleCarta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETALLE_CARTA")
    private Long idDetalleCarta;
    @Size(max = 20)
    @Column(name = "DIRIGIGO_A")
    private String dirigigoA;
    @Size(max = 20)
    @Column(name = "CARGO")
    private String cargo;
    @JoinColumn(name = "FK_CARTA", referencedColumnName = "ID_CARTA")
    @ManyToOne
    private Carta fkCarta;

    public DetalleCarta() {
    }

    public DetalleCarta(Long idDetalleCarta) {
        this.idDetalleCarta = idDetalleCarta;
    }

    public Long getIdDetalleCarta() {
        return idDetalleCarta;
    }

    public void setIdDetalleCarta(Long idDetalleCarta) {
        this.idDetalleCarta = idDetalleCarta;
    }

    public String getDirigigoA() {
        return dirigigoA;
    }

    public void setDirigigoA(String dirigigoA) {
        this.dirigigoA = dirigigoA;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Carta getFkCarta() {
        return fkCarta;
    }

    public void setFkCarta(Carta fkCarta) {
        this.fkCarta = fkCarta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCarta != null ? idDetalleCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCarta)) {
            return false;
        }
        DetalleCarta other = (DetalleCarta) object;
        if ((this.idDetalleCarta == null && other.idDetalleCarta != null) || (this.idDetalleCarta != null && !this.idDetalleCarta.equals(other.idDetalleCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.DetalleCarta[ idDetalleCarta=" + idDetalleCarta + " ]";
    }
    
}
