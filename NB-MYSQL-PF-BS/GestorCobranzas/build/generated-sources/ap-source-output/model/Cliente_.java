package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Mora;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:49")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile CollectionAttribute<Cliente, Mora> moraCollection;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, String> telefono1;
    public static volatile SingularAttribute<Cliente, Boolean> registroActivo;
    public static volatile SingularAttribute<Cliente, String> telefono2;
    public static volatile SingularAttribute<Cliente, String> cedulaRuc;
    public static volatile SingularAttribute<Cliente, String> codCliente;

}