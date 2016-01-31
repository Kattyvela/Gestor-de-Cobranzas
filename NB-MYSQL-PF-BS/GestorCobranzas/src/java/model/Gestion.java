/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "gestion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestion.findAll", query = "SELECT g FROM Gestion g"),
    @NamedQuery(name = "Gestion.findByIdGestion", query = "SELECT g FROM Gestion g WHERE g.gestionPK.idGestion = :idGestion"),
    @NamedQuery(name = "Gestion.findByFechaGestion", query = "SELECT g FROM Gestion g WHERE g.fechaGestion = :fechaGestion"),
    @NamedQuery(name = "Gestion.findByObservaciones", query = "SELECT g FROM Gestion g WHERE g.observaciones = :observaciones"),
    @NamedQuery(name = "Gestion.findByMoraidMora", query = "SELECT g FROM Gestion g WHERE g.gestionPK.moraidMora = :moraidMora"),
    @NamedQuery(name = "Gestion.findByResultadoidResultado", query = "SELECT g FROM Gestion g WHERE g.gestionPK.resultadoidResultado = :resultadoidResultado")})
public class Gestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GestionPK gestionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_gestion")
    @Temporal(TemporalType.DATE)
    private Date fechaGestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gestion")
    private Collection<Respuesta> respuestaCollection;
    @JoinColumn(name = "Tipo_Gestion_id_Tipo_Gestion", referencedColumnName = "id_Tipo_Gestion")
    @ManyToOne(optional = false)
    private TipoGestion tipoGestionidTipoGestion;
    @JoinColumn(name = "Mora_id_Mora", referencedColumnName = "id_Mora", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Mora mora;
    @JoinColumn(name = "Resultado_id_Resultado", referencedColumnName = "id_Resultado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resultado resultado;

    public Gestion() {
    }

    public Gestion(GestionPK gestionPK) {
        this.gestionPK = gestionPK;
    }

    public Gestion(GestionPK gestionPK, Date fechaGestion, String observaciones) {
        this.gestionPK = gestionPK;
        this.fechaGestion = fechaGestion;
        this.observaciones = observaciones;
    }

    public Gestion(int idGestion, int moraidMora, int resultadoidResultado) {
        this.gestionPK = new GestionPK(idGestion, moraidMora, resultadoidResultado);
    }

    public GestionPK getGestionPK() {
        return gestionPK;
    }

    public void setGestionPK(GestionPK gestionPK) {
        this.gestionPK = gestionPK;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }

    public TipoGestion getTipoGestionidTipoGestion() {
        return tipoGestionidTipoGestion;
    }

    public void setTipoGestionidTipoGestion(TipoGestion tipoGestionidTipoGestion) {
        this.tipoGestionidTipoGestion = tipoGestionidTipoGestion;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gestionPK != null ? gestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gestion)) {
            return false;
        }
        Gestion other = (Gestion) object;
        if ((this.gestionPK == null && other.gestionPK != null) || (this.gestionPK != null && !this.gestionPK.equals(other.gestionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gestion[ gestionPK=" + gestionPK + " ]";
    }
    
}
