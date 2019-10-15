package com.eps.model;

import com.eps.model.Carta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-15T16:17:47")
@StaticMetamodel(DetalleCarta.class)
public class DetalleCarta_ { 

    public static volatile SingularAttribute<DetalleCarta, Long> idDetalleCarta;
    public static volatile SingularAttribute<DetalleCarta, String> cargo;
    public static volatile SingularAttribute<DetalleCarta, Carta> fkCarta;
    public static volatile SingularAttribute<DetalleCarta, String> dirigigoA;

}