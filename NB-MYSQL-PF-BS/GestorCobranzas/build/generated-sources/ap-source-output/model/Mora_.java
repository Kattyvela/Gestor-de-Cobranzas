package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.AbonoDeuda;
import model.Cliente;
import model.Gestion;
import model.MoraPK;
import model.UsuarioUnidadNegocio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:48")
@StaticMetamodel(Mora.class)
public class Mora_ { 

    public static volatile SingularAttribute<Mora, String> descripcion;
    public static volatile SingularAttribute<Mora, Integer> diasEnMora;
    public static volatile SingularAttribute<Mora, Date> fechaFacturacion;
    public static volatile SingularAttribute<Mora, Cliente> cliente;
    public static volatile CollectionAttribute<Mora, Gestion> gestionCollection;
    public static volatile SingularAttribute<Mora, Integer> nroFactura;
    public static volatile SingularAttribute<Mora, Double> saldoTotalDeFactura;
    public static volatile SingularAttribute<Mora, String> plazo;
    public static volatile CollectionAttribute<Mora, AbonoDeuda> abonoDeudaCollection;
    public static volatile SingularAttribute<Mora, UsuarioUnidadNegocio> usuarioUnidadNegocio;
    public static volatile SingularAttribute<Mora, MoraPK> moraPK;

}