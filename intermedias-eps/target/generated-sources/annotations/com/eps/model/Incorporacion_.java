package com.eps.model;

import com.eps.model.Carta;
import com.eps.model.Estudiante;
import com.eps.model.Institucion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-15T16:17:47")
@StaticMetamodel(Incorporacion.class)
public class Incorporacion_ { 

    public static volatile SingularAttribute<Incorporacion, Long> idIncorporacion;
    public static volatile SingularAttribute<Incorporacion, Date> fechaIncorporacion;
    public static volatile SingularAttribute<Incorporacion, Institucion> fkInstitucion;
    public static volatile SingularAttribute<Incorporacion, Date> fechaFinal;
    public static volatile SingularAttribute<Incorporacion, String> asesor;
    public static volatile SingularAttribute<Incorporacion, Carta> fkCarta;
    public static volatile SingularAttribute<Incorporacion, Estudiante> fkEstudianteCarnet;
    public static volatile SingularAttribute<Incorporacion, String> asesorSupervisor;
    public static volatile SingularAttribute<Incorporacion, Date> fechaInicio;
    public static volatile SingularAttribute<Incorporacion, Date> fechaFinalSeguro;
    public static volatile SingularAttribute<Incorporacion, Date> fechaInicioSeguro;
    public static volatile SingularAttribute<Incorporacion, Long> correlativoDoc;
    public static volatile SingularAttribute<Incorporacion, String> semestre;
    public static volatile SingularAttribute<Incorporacion, String> tiempoEps;
    public static volatile SingularAttribute<Incorporacion, String> supervisor;

}