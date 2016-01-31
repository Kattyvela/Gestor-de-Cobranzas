/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "usuario_unidad_negocio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioUnidadNegocio.findAll", query = "SELECT u FROM UsuarioUnidadNegocio u"),
    @NamedQuery(name = "UsuarioUnidadNegocio.findByIdUsuariounidadnegocio", query = "SELECT u FROM UsuarioUnidadNegocio u WHERE u.idUsuariounidadnegocio = :idUsuariounidadnegocio"),
    @NamedQuery(name = "UsuarioUnidadNegocio.findByIdUsuario", query = "SELECT u FROM UsuarioUnidadNegocio u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "UsuarioUnidadNegocio.findByIdUnidadNegocio", query = "SELECT u FROM UsuarioUnidadNegocio u WHERE u.idUnidadNegocio = :idUnidadNegocio"),
    @NamedQuery(name = "UsuarioUnidadNegocio.findByActivo", query = "SELECT u FROM UsuarioUnidadNegocio u WHERE u.activo = :activo")})
public class UsuarioUnidadNegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Usuario_unidad_negocio")
    private Integer idUsuariounidadnegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "id_unidad_negocio")
    private Integer idUnidadNegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioUnidadNegocio")
    private Collection<Mora> moraCollection;

    public UsuarioUnidadNegocio() {
    }

    public UsuarioUnidadNegocio(Integer idUsuariounidadnegocio) {
        this.idUsuariounidadnegocio = idUsuariounidadnegocio;
    }

    public UsuarioUnidadNegocio(Integer idUsuariounidadnegocio, int idUsuario, boolean activo) {
        this.idUsuariounidadnegocio = idUsuariounidadnegocio;
        this.idUsuario = idUsuario;
        this.activo = activo;
    }

    public Integer getIdUsuariounidadnegocio() {
        return idUsuariounidadnegocio;
    }

    public void setIdUsuariounidadnegocio(Integer idUsuariounidadnegocio) {
        this.idUsuariounidadnegocio = idUsuariounidadnegocio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUnidadNegocio() {
        return idUnidadNegocio;
    }

    public void setIdUnidadNegocio(Integer idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Mora> getMoraCollection() {
        return moraCollection;
    }

    public void setMoraCollection(Collection<Mora> moraCollection) {
        this.moraCollection = moraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuariounidadnegocio != null ? idUsuariounidadnegocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioUnidadNegocio)) {
            return false;
        }
        UsuarioUnidadNegocio other = (UsuarioUnidadNegocio) object;
        if ((this.idUsuariounidadnegocio == null && other.idUsuariounidadnegocio != null) || (this.idUsuariounidadnegocio != null && !this.idUsuariounidadnegocio.equals(other.idUsuariounidadnegocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UsuarioUnidadNegocio[ idUsuariounidadnegocio=" + idUsuariounidadnegocio + " ]";
    }

}
