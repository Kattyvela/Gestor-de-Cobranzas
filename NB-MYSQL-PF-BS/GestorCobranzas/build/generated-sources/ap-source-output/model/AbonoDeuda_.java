package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AbonoDeudaPK;
import model.FormaPago;
import model.Mora;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:48")
@StaticMetamodel(AbonoDeuda.class)
public class AbonoDeuda_ { 

    public static volatile SingularAttribute<AbonoDeuda, AbonoDeudaPK> abonoDeudaPK;
    public static volatile SingularAttribute<AbonoDeuda, Mora> mora;
    public static volatile SingularAttribute<AbonoDeuda, Date> fechaAbono;
    public static volatile SingularAttribute<AbonoDeuda, Double> abono;
    public static volatile SingularAttribute<AbonoDeuda, FormaPago> formaPago;

}