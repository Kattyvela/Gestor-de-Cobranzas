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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findByIdResultado", query = "SELECT r FROM Resultado r WHERE r.idResultado = :idResultado"),
    @NamedQuery(name = "Resultado.findByNombre", query = "SELECT r FROM Resultado r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Resultado.findByRegistroactivo", query = "SELECT r FROM Resultado r WHERE r.registroactivo = :registroactivo")})
public class Resultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESULTADO")
    private Integer idResultado;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "REGISTROACTIVO")
    private String registroactivo;
    @JoinColumn(name = "ID_TIPOGESTION", referencedColumnName = "ID_TIPOGESTION")
    @ManyToOne
    private TipoGestion idTipogestion;
    @OneToMany(mappedBy = "idResultado")
    private Collection<Gestion> gestionCollection;

    public Resultado() {
    }

    public Resultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
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

    public TipoGestion getIdTipogestion() {
        return idTipogestion;
    }

    public void setIdTipogestion(TipoGestion idTipogestion) {
        this.idTipogestion = idTipogestion;
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
        hash += (idResultado != null ? idResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.idResultado == null && other.idResultado != null) || (this.idResultado != null && !this.idResultado.equals(other.idResultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.Resultado[ idResultado=" + idResultado + " ]";
    }
    
}
