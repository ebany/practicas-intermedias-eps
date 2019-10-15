/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eps.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nikola
 */
@Entity
@Table(name = "INCORPORACION")
@NamedQueries({
    @NamedQuery(name = "Incorporacion.findAll", query = "SELECT i FROM Incorporacion i")})
public class Incorporacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INCORPORACION")
    private Long idIncorporacion;
    @Column(name = "CORRELATIVO_DOC")
    private Long correlativoDoc;
    @Column(name = "FECHA_INCORPORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIncorporacion;
    @Size(max = 10)
    @Column(name = "SEMESTRE")
    private String semestre;
    @Size(max = 50)
    @Column(name = "ASESOR")
    private String asesor;
    @Size(max = 50)
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Size(max = 50)
    @Column(name = "ASESOR_SUPERVISOR")
    private String asesorSupervisor;
    @Size(max = 50)
    @Column(name = "TIEMPO_EPS")
    private String tiempoEps;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinal;
    @Column(name = "FECHA_INICIO_SEGURO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioSeguro;
    @Column(name = "FECHA_FINAL_SEGURO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalSeguro;
    @JoinColumn(name = "FK_CARTA", referencedColumnName = "ID_CARTA")
    @ManyToOne(optional = false)
    private Carta fkCarta;
    @JoinColumn(name = "FK_ESTUDIANTE_CARNET", referencedColumnName = "CARNET")
    @ManyToOne(optional = false)
    private Estudiante fkEstudianteCarnet;
    @JoinColumn(name = "FK_INSTITUCION", referencedColumnName = "ID_INSTITUCION")
    @ManyToOne(optional = false)
    private Institucion fkInstitucion;

    public Incorporacion() {
    }

    public Incorporacion(Long idIncorporacion) {
        this.idIncorporacion = idIncorporacion;
    }

    public Long getIdIncorporacion() {
        return idIncorporacion;
    }

    public void setIdIncorporacion(Long idIncorporacion) {
        this.idIncorporacion = idIncorporacion;
    }

    public Long getCorrelativoDoc() {
        return correlativoDoc;
    }

    public void setCorrelativoDoc(Long correlativoDoc) {
        this.correlativoDoc = correlativoDoc;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAsesorSupervisor() {
        return asesorSupervisor;
    }

    public void setAsesorSupervisor(String asesorSupervisor) {
        this.asesorSupervisor = asesorSupervisor;
    }

    public String getTiempoEps() {
        return tiempoEps;
    }

    public void setTiempoEps(String tiempoEps) {
        this.tiempoEps = tiempoEps;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicioSeguro() {
        return fechaInicioSeguro;
    }

    public void setFechaInicioSeguro(Date fechaInicioSeguro) {
        this.fechaInicioSeguro = fechaInicioSeguro;
    }

    public Date getFechaFinalSeguro() {
        return fechaFinalSeguro;
    }

    public void setFechaFinalSeguro(Date fechaFinalSeguro) {
        this.fechaFinalSeguro = fechaFinalSeguro;
    }

    public Carta getFkCarta() {
        return fkCarta;
    }

    public void setFkCarta(Carta fkCarta) {
        this.fkCarta = fkCarta;
    }

    public Estudiante getFkEstudianteCarnet() {
        return fkEstudianteCarnet;
    }

    public void setFkEstudianteCarnet(Estudiante fkEstudianteCarnet) {
        this.fkEstudianteCarnet = fkEstudianteCarnet;
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
        hash += (idIncorporacion != null ? idIncorporacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incorporacion)) {
            return false;
        }
        Incorporacion other = (Incorporacion) object;
        if ((this.idIncorporacion == null && other.idIncorporacion != null) || (this.idIncorporacion != null && !this.idIncorporacion.equals(other.idIncorporacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eps.model.Incorporacion[ idIncorporacion=" + idIncorporacion + " ]";
    }
    
}
