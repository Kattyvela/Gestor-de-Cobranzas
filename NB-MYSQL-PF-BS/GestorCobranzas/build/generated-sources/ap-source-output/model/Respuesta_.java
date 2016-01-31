package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Gestion;
import model.RespuestaPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:49")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, String> respuestaCliente;
    public static volatile SingularAttribute<Respuesta, Date> fechaCompromisoPago;
    public static volatile SingularAttribute<Respuesta, RespuestaPK> respuestaPK;
    public static volatile SingularAttribute<Respuesta, Date> fechaRespuesta;
    public static volatile SingularAttribute<Respuesta, Gestion> gestion;

}