package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Gestion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:49")
@StaticMetamodel(Resultado.class)
public class Resultado_ { 

    public static volatile CollectionAttribute<Resultado, Gestion> gestionCollection;
    public static volatile SingularAttribute<Resultado, Boolean> registroActivo;
    public static volatile SingularAttribute<Resultado, String> nombre;
    public static volatile SingularAttribute<Resultado, Integer> idResultado;

}