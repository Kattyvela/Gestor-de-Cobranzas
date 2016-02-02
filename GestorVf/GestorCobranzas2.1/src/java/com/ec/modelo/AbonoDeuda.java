/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "abono_deuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AbonoDeuda.findAll", query = "SELECT a FROM AbonoDeuda a"),
    @NamedQuery(name = "AbonoDeuda.findByIdAbonodeuda", query = "SELECT a FROM AbonoDeuda a WHERE a.idAbonodeuda = :idAbonodeuda"),
    @NamedQuery(name = "AbonoDeuda.findByFechaabono", query = "SELECT a FROM AbonoDeuda a WHERE a.fechaabono = :fechaabono"),
    @NamedQuery(name = "AbonoDeuda.findByAbono", query = "SELECT a FROM AbonoDeuda a WHERE a.abono = :abono")})
public class AbonoDeuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ABONODEUDA")
    private Integer idAbonodeuda;
    @Column(name = "FECHAABONO")
    @Temporal(TemporalType.DATE)
    private Date fechaabono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ABONO")
    private BigDecimal abono;
    @JoinColumn(name = "ID_FORMAPAGO", referencedColumnName = "ID_FORMAPAGO")
    @ManyToOne
    private FormaDePago idFormapago;
    @JoinColumn(name = "ID_MORA", referencedColumnName = "ID_MORA")
    @ManyToOne
    private Mora idMora;

    public AbonoDeuda() {
    }

    public AbonoDeuda(Integer idAbonodeuda) {
        this.idAbonodeuda = idAbonodeuda;
    }

    public Integer getIdAbonodeuda() {
        return idAbonodeuda;
    }

    public void setIdAbonodeuda(Integer idAbonodeuda) {
        this.idAbonodeuda = idAbonodeuda;
    }

    public Date getFechaabono() {
        return fechaabono;
    }

    public void setFechaabono(Date fechaabono) {
        this.fechaabono = fechaabono;
    }

    public BigDecimal getAbono() {
        return abono;
    }

    public void setAbono(BigDecimal abono) {
        this.abono = abono;
    }

    public FormaDePago getIdFormapago() {
        return idFormapago;
    }

    public void setIdFormapago(FormaDePago idFormapago) {
        this.idFormapago = idFormapago;
    }

    public Mora getIdMora() {
        return idMora;
    }

    public void setIdMora(Mora idMora) {
        this.idMora = idMora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAbonodeuda != null ? idAbonodeuda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonoDeuda)) {
            return false;
        }
        AbonoDeuda other = (AbonoDeuda) object;
        if ((this.idAbonodeuda == null && other.idAbonodeuda != null) || (this.idAbonodeuda != null && !this.idAbonodeuda.equals(other.idAbonodeuda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.AbonoDeuda[ idAbonodeuda=" + idAbonodeuda + " ]";
    }
    
}
