package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Mora;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-30T23:53:48")
@StaticMetamodel(UsuarioUnidadNegocio.class)
public class UsuarioUnidadNegocio_ { 

    public static volatile SingularAttribute<UsuarioUnidadNegocio, Integer> idUsuariounidadnegocio;
    public static volatile CollectionAttribute<UsuarioUnidadNegocio, Mora> moraCollection;
    public static volatile SingularAttribute<UsuarioUnidadNegocio, Integer> idUsuario;
    public static volatile SingularAttribute<UsuarioUnidadNegocio, Integer> idUnidadNegocio;
    public static volatile SingularAttribute<UsuarioUnidadNegocio, Boolean> activo;

}