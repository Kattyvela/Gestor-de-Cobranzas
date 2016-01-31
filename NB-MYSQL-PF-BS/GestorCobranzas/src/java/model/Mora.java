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
@Table(name = "mora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mora.findAll", query = "SELECT m FROM Mora m"),
    @NamedQuery(name = "Mora.findByIdMora", query = "SELECT m FROM Mora m WHERE m.moraPK.idMora = :idMora"),
    @NamedQuery(name = "Mora.findByDescripcion", query = "SELECT m FROM Mora m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Mora.findByNroFactura", query = "SELECT m FROM Mora m WHERE m.nroFactura = :nroFactura"),
    @NamedQuery(name = "Mora.findByFechaFacturacion", query = "SELECT m FROM Mora m WHERE m.fechaFacturacion = :fechaFacturacion"),
    @NamedQuery(name = "Mora.findByPlazo", query = "SELECT m FROM Mora m WHERE m.plazo = :plazo"),
    @NamedQuery(name = "Mora.findByDiasEnMora", query = "SELECT m FROM Mora m WHERE m.diasEnMora = :diasEnMora"),
    @NamedQuery(name = "Mora.findBySaldoTotalDeFactura", query = "SELECT m FROM Mora m WHERE m.saldoTotalDeFactura = :saldoTotalDeFactura"),
    @NamedQuery(name = "Mora.findByUsuariounidadnegocioidUsuariounidadnegocio", query = "SELECT m FROM Mora m WHERE m.moraPK.usuariounidadnegocioidUsuariounidadnegocio = :usuariounidadnegocioidUsuariounidadnegocio"),
    @NamedQuery(name = "Mora.findByClienteidCliente", query = "SELECT m FROM Mora m WHERE m.moraPK.clienteidCliente = :clienteidCliente")})
public class Mora implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoraPK moraPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_factura")
    private int nroFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.DATE)
    private Date fechaFacturacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "plazo")
    private String plazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dias_en_mora")
    private int diasEnMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_total_de_factura")
    private double saldoTotalDeFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mora")
    private Collection<AbonoDeuda> abonoDeudaCollection;
    @JoinColumn(name = "Usuario_unidad_negocio_id_Usuario_unidad_negocio", referencedColumnName = "id_Usuario_unidad_negocio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UsuarioUnidadNegocio usuarioUnidadNegocio;
    @JoinColumn(name = "Cliente_id_Cliente", referencedColumnName = "id_Cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mora")
    private Collection<Gestion> gestionCollection;

    public Mora() {
    }

    public Mora(MoraPK moraPK) {
        this.moraPK = moraPK;
    }

    public Mora(MoraPK moraPK, String descripcion, int nroFactura, Date fechaFacturacion, String plazo, int diasEnMora, double saldoTotalDeFactura) {
        this.moraPK = moraPK;
        this.descripcion = descripcion;
        this.nroFactura = nroFactura;
        this.fechaFacturacion = fechaFacturacion;
        this.plazo = plazo;
        this.diasEnMora = diasEnMora;
        this.saldoTotalDeFactura = saldoTotalDeFactura;
    }

    public Mora(int idMora, int usuariounidadnegocioidUsuariounidadnegocio, int clienteidCliente) {
        this.moraPK = new MoraPK(idMora, usuariounidadnegocioidUsuariounidadnegocio, clienteidCliente);
    }

    public MoraPK getMoraPK() {
        return moraPK;
    }

    public void setMoraPK(MoraPK moraPK) {
        this.moraPK = moraPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public int getDiasEnMora() {
        return diasEnMora;
    }

    public void setDiasEnMora(int diasEnMora) {
        this.diasEnMora = diasEnMora;
    }

    public double getSaldoTotalDeFactura() {
        return saldoTotalDeFactura;
    }

    public void setSaldoTotalDeFactura(double saldoTotalDeFactura) {
        this.saldoTotalDeFactura = saldoTotalDeFactura;
    }

    @XmlTransient
    public Collection<AbonoDeuda> getAbonoDeudaCollection() {
        return abonoDeudaCollection;
    }

    public void setAbonoDeudaCollection(Collection<AbonoDeuda> abonoDeudaCollection) {
        this.abonoDeudaCollection = abonoDeudaCollection;
    }

    public UsuarioUnidadNegocio getUsuarioUnidadNegocio() {
        return usuarioUnidadNegocio;
    }

    public void setUsuarioUnidadNegocio(UsuarioUnidadNegocio usuarioUnidadNegocio) {
        this.usuarioUnidadNegocio = usuarioUnidadNegocio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash += (moraPK != null ? moraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mora)) {
            return false;
        }
        Mora other = (Mora) object;
        if ((this.moraPK == null && other.moraPK != null) || (this.moraPK != null && !this.moraPK.equals(other.moraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mora[ moraPK=" + moraPK + " ]";
    }
    
}
