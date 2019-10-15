/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nikola
 */
@Entity
@Table(name = "CARTA")
@NamedQueries({
    @NamedQuery(name = "Carta.findAll", query = "SELECT c FROM Carta c")})
public class Carta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARTA")
    private Long idCarta;
    @Size(max = 50)
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @OneToMany(mappedBy = "fkCarta")
    private List<DetalleCarta> detalleCartaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCarta")
    private List<Incorporacion> incorporacionList;

    public Carta() {
    }

    public Carta(Long idCarta) {
        this.idCarta = idCarta;
    }

    public Long getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(Long idCarta) {
        this.idCarta = idCarta;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public List<DetalleCarta> getDetalleCartaList() {
        return detalleCartaList;
    }

    public void setDetalleCartaList(List<DetalleCarta> detalleCartaList) {
        this.detalleCartaList = detalleCartaList;
    }

    public List<Incorporacion> getIncorporacionList() {
        return incorporacionList;
    }

    public void setIncorporacionList(List<Incorporacion> incorporacionList) {
        this.incorporacionList = incorporacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarta != null ? idCarta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carta)) {
            return false;
        }
        Carta other = (Carta) object;
        if ((this.idCarta == null && other.idCarta != null) || (this.idCarta != null && !this.idCarta.equals(other.idCarta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.Carta[ idCarta=" + idCarta + " ]";
    }
    
}
