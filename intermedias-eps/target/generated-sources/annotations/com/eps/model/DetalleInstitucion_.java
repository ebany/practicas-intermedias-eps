package com.eps.model;

import com.eps.model.Institucion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-15T16:17:47")
@StaticMetamodel(DetalleInstitucion.class)
public class DetalleInstitucion_ { 

    public static volatile SingularAttribute<DetalleInstitucion, String> ubicacion;
    public static volatile SingularAttribute<DetalleInstitucion, Long> idDetalleInstitucion;
    public static volatile SingularAttribute<DetalleInstitucion, Institucion> fkInstitucion;
    public static volatile SingularAttribute<DetalleInstitucion, String> telefono;

}