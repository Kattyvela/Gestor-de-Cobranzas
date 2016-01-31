/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "AbonoDeuda.findByIdAbonoDeuda", query = "SELECT a FROM AbonoDeuda a WHERE a.abonoDeudaPK.idAbonoDeuda = :idAbonoDeuda"),
    @NamedQuery(name = "AbonoDeuda.findByFechaAbono", query = "SELECT a FROM AbonoDeuda a WHERE a.fechaAbono = :fechaAbono"),
    @NamedQuery(name = "AbonoDeuda.findByAbono", query = "SELECT a FROM AbonoDeuda a WHERE a.abono = :abono"),
    @NamedQuery(name = "AbonoDeuda.findByMoraidMora", query = "SELECT a FROM AbonoDeuda a WHERE a.abonoDeudaPK.moraidMora = :moraidMora"),
    @NamedQuery(name = "AbonoDeuda.findByMoraUsuariounidadnegocioidUsuariounidadnegocio", query = "SELECT a FROM AbonoDeuda a WHERE a.abonoDeudaPK.moraUsuariounidadnegocioidUsuariounidadnegocio = :moraUsuariounidadnegocioidUsuariounidadnegocio"),
    @NamedQuery(name = "AbonoDeuda.findByMoraClienteidCliente", query = "SELECT a FROM AbonoDeuda a WHERE a.abonoDeudaPK.moraClienteidCliente = :moraClienteidCliente"),
    @NamedQuery(name = "AbonoDeuda.findByFormaPagoidFormaPago", query = "SELECT a FROM AbonoDeuda a WHERE a.abonoDeudaPK.formaPagoidFormaPago = :formaPagoidFormaPago")})
public class AbonoDeuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AbonoDeudaPK abonoDeudaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_abono")
    @Temporal(TemporalType.DATE)
    private Date fechaAbono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono")
    private double abono;
    @JoinColumns({
        @JoinColumn(name = "Mora_id_Mora", referencedColumnName = "id_Mora", insertable = false, updatable = false),
        @JoinColumn(name = "Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio", referencedColumnName = "Usuario_unidad_negocio_id_Usuario_unidad_negocio", insertable = false, updatable = false),
        @JoinColumn(name = "Mora_Cliente_id_Cliente", referencedColumnName = "Cliente_id_Cliente", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Mora mora;
    @JoinColumn(name = "Forma_Pago_id_Forma_Pago", referencedColumnName = "id_Forma_Pago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormaPago formaPago;

    public AbonoDeuda() {
    }

    public AbonoDeuda(AbonoDeudaPK abonoDeudaPK) {
        this.abonoDeudaPK = abonoDeudaPK;
    }

    public AbonoDeuda(AbonoDeudaPK abonoDeudaPK, Date fechaAbono, double abono) {
        this.abonoDeudaPK = abonoDeudaPK;
        this.fechaAbono = fechaAbono;
        this.abono = abono;
    }

    public AbonoDeuda(int idAbonoDeuda, int moraidMora, int moraUsuariounidadnegocioidUsuariounidadnegocio, int moraClienteidCliente, int formaPagoidFormaPago) {
        this.abonoDeudaPK = new AbonoDeudaPK(idAbonoDeuda, moraidMora, moraUsuariounidadnegocioidUsuariounidadnegocio, moraClienteidCliente, formaPagoidFormaPago);
    }

    public AbonoDeudaPK getAbonoDeudaPK() {
        return abonoDeudaPK;
    }

    public void setAbonoDeudaPK(AbonoDeudaPK abonoDeudaPK) {
        this.abonoDeudaPK = abonoDeudaPK;
    }

    public Date getFechaAbono() {
        return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
        this.fechaAbono = fechaAbono;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (abonoDeudaPK != null ? abonoDeudaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonoDeuda)) {
            return false;
        }
        AbonoDeuda other = (AbonoDeuda) object;
        if ((this.abonoDeudaPK == null && other.abonoDeudaPK != null) || (this.abonoDeudaPK != null && !this.abonoDeudaPK.equals(other.abonoDeudaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AbonoDeuda[ abonoDeudaPK=" + abonoDeudaPK + " ]";
    }
    
}
