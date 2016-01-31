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
@Table(name = "forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
    @NamedQuery(name = "FormaPago.findByIdFormaPago", query = "SELECT f FROM FormaPago f WHERE f.idFormaPago = :idFormaPago"),
    @NamedQuery(name = "FormaPago.findByNombre", query = "SELECT f FROM FormaPago f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FormaPago.findByRegistroActivo", query = "SELECT f FROM FormaPago f WHERE f.registroActivo = :registroActivo"),
    @NamedQuery(name = "FormaPago.findByFormaPagocol1", query = "SELECT f FROM FormaPago f WHERE f.formaPagocol1 = :formaPagocol1")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Forma_Pago")
    private Integer idFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registro_activo")
    private boolean registroActivo;
    @Size(max = 45)
    @Column(name = "Forma_Pagocol1")
    private String formaPagocol1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPago")
    private Collection<AbonoDeuda> abonoDeudaCollection;

    public FormaPago() {
    }

    public FormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPago(Integer idFormaPago, String nombre, boolean registroActivo) {
        this.idFormaPago = idFormaPago;
        this.nombre = nombre;
        this.registroActivo = registroActivo;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
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

    public String getFormaPagocol1() {
        return formaPagocol1;
    }

    public void setFormaPagocol1(String formaPagocol1) {
        this.formaPagocol1 = formaPagocol1;
    }

    @XmlTransient
    public Collection<AbonoDeuda> getAbonoDeudaCollection() {
        return abonoDeudaCollection;
    }

    public void setAbonoDeudaCollection(Collection<AbonoDeuda> abonoDeudaCollection) {
        this.abonoDeudaCollection = abonoDeudaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FormaPago[ idFormaPago=" + idFormaPago + " ]";
    }
    
}
