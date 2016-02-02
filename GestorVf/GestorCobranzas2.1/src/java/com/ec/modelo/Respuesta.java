/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuestacliente", query = "SELECT r FROM Respuesta r WHERE r.respuestacliente = :respuestacliente"),
    @NamedQuery(name = "Respuesta.findByFechacompromisopago", query = "SELECT r FROM Respuesta r WHERE r.fechacompromisopago = :fechacompromisopago"),
    @NamedQuery(name = "Respuesta.findByFecharespuesta", query = "SELECT r FROM Respuesta r WHERE r.fecharespuesta = :fecharespuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RESPUESTA")
    private Integer idRespuesta;
    @Size(max = 200)
    @Column(name = "RESPUESTACLIENTE")
    private String respuestacliente;
    @Column(name = "FECHACOMPROMISOPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechacompromisopago;
    @Column(name = "FECHARESPUESTA")
    @Temporal(TemporalType.DATE)
    private Date fecharespuesta;
    @JoinColumn(name = "ID_GESTION", referencedColumnName = "ID_GESTION")
    @ManyToOne
    private Gestion idGestion;
    @OneToMany(mappedBy = "idRespuesta")
    private Collection<Gestion> gestionCollection;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuestacliente() {
        return respuestacliente;
    }

    public void setRespuestacliente(String respuestacliente) {
        this.respuestacliente = respuestacliente;
    }

    public Date getFechacompromisopago() {
        return fechacompromisopago;
    }

    public void setFechacompromisopago(Date fechacompromisopago) {
        this.fechacompromisopago = fechacompromisopago;
    }

    public Date getFecharespuesta() {
        return fecharespuesta;
    }

    public void setFecharespuesta(Date fecharespuesta) {
        this.fecharespuesta = fecharespuesta;
    }

    public Gestion getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(Gestion idGestion) {
        this.idGestion = idGestion;
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
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
