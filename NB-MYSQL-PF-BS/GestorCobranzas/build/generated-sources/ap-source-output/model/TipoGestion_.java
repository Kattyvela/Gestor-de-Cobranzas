package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Gestion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:49")
@StaticMetamodel(TipoGestion.class)
public class TipoGestion_ { 

    public static volatile CollectionAttribute<TipoGestion, Gestion> gestionCollection;
    public static volatile SingularAttribute<TipoGestion, Integer> idTipoGestion;
    public static volatile SingularAttribute<TipoGestion, Boolean> registroActivo;
    public static volatile SingularAttribute<TipoGestion, String> nombre;

}