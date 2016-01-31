package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.GestionPK;
import model.Mora;
import model.Respuesta;
import model.Resultado;
import model.TipoGestion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:48")
@StaticMetamodel(Gestion.class)
public class Gestion_ { 

    public static volatile CollectionAttribute<Gestion, Respuesta> respuestaCollection;
    public static volatile SingularAttribute<Gestion, Mora> mora;
    public static volatile SingularAttribute<Gestion, Resultado> resultado;
    public static volatile SingularAttribute<Gestion, String> observaciones;
    public static volatile SingularAttribute<Gestion, Date> fechaGestion;
    public static volatile SingularAttribute<Gestion, TipoGestion> tipoGestionidTipoGestion;
    public static volatile SingularAttribute<Gestion, GestionPK> gestionPK;

}