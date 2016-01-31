/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuestaCliente", query = "SELECT r FROM Respuesta r WHERE r.respuestaCliente = :respuestaCliente"),
    @NamedQuery(name = "Respuesta.findByFechaCompromisoPago", query = "SELECT r FROM Respuesta r WHERE r.fechaCompromisoPago = :fechaCompromisoPago"),
    @NamedQuery(name = "Respuesta.findByFechaRespuesta", query = "SELECT r FROM Respuesta r WHERE r.fechaRespuesta = :fechaRespuesta"),
    @NamedQuery(name = "Respuesta.findByGestionidGestion", query = "SELECT r FROM Respuesta r WHERE r.respuestaPK.gestionidGestion = :gestionidGestion")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RespuestaPK respuestaPK;
    @Size(max = 45)
    @Column(name = "respuesta_cliente")
    private String respuestaCliente;
    @Column(name = "fecha_compromiso_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaCompromisoPago;
    @Column(name = "fecha_respuesta")
    @Temporal(TemporalType.DATE)
    private Date fechaRespuesta;
    @JoinColumn(name = "Gestion_id_Gestion", referencedColumnName = "id_Gestion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Gestion gestion;

    public Respuesta() {
    }

    public Respuesta(RespuestaPK respuestaPK) {
        this.respuestaPK = respuestaPK;
    }

    public Respuesta(int idRespuesta, int gestionidGestion) {
        this.respuestaPK = new RespuestaPK(idRespuesta, gestionidGestion);
    }

    public RespuestaPK getRespuestaPK() {
        return respuestaPK;
    }

    public void setRespuestaPK(RespuestaPK respuestaPK) {
        this.respuestaPK = respuestaPK;
    }

    public String getRespuestaCliente() {
        return respuestaCliente;
    }

    public void setRespuestaCliente(String respuestaCliente) {
        this.respuestaCliente = respuestaCliente;
    }

    public Date getFechaCompromisoPago() {
        return fechaCompromisoPago;
    }

    public void setFechaCompromisoPago(Date fechaCompromisoPago) {
        this.fechaCompromisoPago = fechaCompromisoPago;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (respuestaPK != null ? respuestaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.respuestaPK == null && other.respuestaPK != null) || (this.respuestaPK != null && !this.respuestaPK.equals(other.respuestaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Respuesta[ respuestaPK=" + respuestaPK + " ]";
    }
    
}
