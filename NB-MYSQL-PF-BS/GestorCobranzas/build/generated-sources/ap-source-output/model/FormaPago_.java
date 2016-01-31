package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AbonoDeuda;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:48")
@StaticMetamodel(FormaPago.class)
public class FormaPago_ { 

    public static volatile SingularAttribute<FormaPago, Integer> idFormaPago;
    public static volatile CollectionAttribute<FormaPago, AbonoDeuda> abonoDeudaCollection;
    public static volatile SingularAttribute<FormaPago, Boolean> registroActivo;
    public static volatile SingularAttribute<FormaPago, String> formaPagocol1;
    public static volatile SingularAttribute<FormaPago, String> nombre;

}