/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "TipoGestion.findByIdTipogestion", query = "SELECT t FROM TipoGestion t WHERE t.idTipogestion = :idTipogestion"),
    @NamedQuery(name = "TipoGestion.findByNombre", query = "SELECT t FROM TipoGestion t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoGestion.findByRegistroactivo", query = "SELECT t FROM TipoGestion t WHERE t.registroactivo = :registroactivo")})
public class TipoGestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOGESTION")
    private Integer idTipogestion;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "REGISTROACTIVO")
    private String registroactivo;
    @OneToMany(mappedBy = "idTipogestion")
    private Collection<Resultado> resultadoCollection;
    @OneToMany(mappedBy = "idTipogestion")
    private Collection<Gestion> gestionCollection;

    public TipoGestion() {
    }

    public TipoGestion(Integer idTipogestion) {
        this.idTipogestion = idTipogestion;
    }

    public Integer getIdTipogestion() {
        return idTipogestion;
    }

    public void setIdTipogestion(Integer idTipogestion) {
        this.idTipogestion = idTipogestion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegistroactivo() {
        return registroactivo;
    }

    public void setRegistroactivo(String registroactivo) {
        this.registroactivo = registroactivo;
    }

    @XmlTransient
    public Collection<Resultado> getResultadoCollection() {
        return resultadoCollection;
    }

    public void setResultadoCollection(Collection<Resultado> resultadoCollection) {
        this.resultadoCollection = resultadoCollection;
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
        hash += (idTipogestion != null ? idTipogestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGestion)) {
            return false;
        }
        TipoGestion other = (TipoGestion) object;
        if ((this.idTipogestion == null && other.idTipogestion != null) || (this.idTipogestion != null && !this.idTipogestion.equals(other.idTipogestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.TipoGestion[ idTipogestion=" + idTipogestion + " ]";
    }
    
}
