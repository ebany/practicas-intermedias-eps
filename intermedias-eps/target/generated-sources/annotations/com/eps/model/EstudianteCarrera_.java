package com.eps.model;

import com.eps.model.Carrera;
import com.eps.model.Estudiante;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-15T16:17:47")
@StaticMetamodel(EstudianteCarrera.class)
public class EstudianteCarrera_ { 

    public static volatile SingularAttribute<EstudianteCarrera, Carrera> fkCarrera;
    public static volatile SingularAttribute<EstudianteCarrera, Long> idEstudianteCarrera;
    public static volatile SingularAttribute<EstudianteCarrera, Estudiante> fkEstudianteCarnet;

}