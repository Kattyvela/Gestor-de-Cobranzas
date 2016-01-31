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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "tipo_gestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGestion.findAll", query = "SELECT t FROM TipoGestion t"),
    @NamedQuery(name = "TipoGestion.findByIdTipoGestion", query = "SELECT t FROM TipoGestion t WHERE t.idTipoGestion = :idTipoGestion"),
    @NamedQuery(name = "TipoGestion.findByNombre", query = "SELECT t FROM TipoGestion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoGestion.findByRegistroActivo", query = "SELECT t FROM TipoGestion t WHERE t.registroActivo = :registroActivo")})
public class TipoGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Tipo_Gestion")
    private Integer idTipoGestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registro_activo")
    private boolean registroActivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoGestionidTipoGestion")
    private Collection<Gestion> gestionCollection;

    public TipoGestion() {
    }

    public TipoGestion(Integer idTipoGestion) {
        this.idTipoGestion = idTipoGestion;
    }

    public TipoGestion(Integer idTipoGestion, String nombre, boolean registroActivo) {
        this.idTipoGestion = idTipoGestion;
        this.nombre = nombre;
        this.registroActivo = registroActivo;
    }

    public Integer getIdTipoGestion() {
        return idTipoGestion;
    }

    public void setIdTipoGestion(Integer idTipoGestion) {
        this.idTipoGestion = idTipoGestion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getRegistroActivo() {
        return registroActivo;
    }

    public void setRegistroActivo(boolean registroActivo) {
        this.registroActivo = registroActivo;
    }

    @XmlTransient
    public Collection<Gestion> getGestionCollection() {
        return gestionCollection;
    }

    public void setGestionCollection(Collection<Gestion> gestionCollection) {
        this.gestionCollection = gestionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoGestion != null ? idTipoGestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGestion)) {
            return false;
        }
        TipoGestion other = (TipoGestion) object;
        if ((this.idTipoGestion == null && other.idTipoGestion != null) || (this.idTipoGestion != null && !this.idTipoGestion.equals(other.idTipoGestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoGestion[ idTipoGestion=" + idTipoGestion + " ]";
    }
    
}
