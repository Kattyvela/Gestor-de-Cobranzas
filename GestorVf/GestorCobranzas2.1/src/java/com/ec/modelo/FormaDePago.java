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
@Table(name = "forma_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaDePago.findAll", query = "SELECT f FROM FormaDePago f"),
    @NamedQuery(name = "FormaDePago.findByIdFormapago", query = "SELECT f FROM FormaDePago f WHERE f.idFormapago = :idFormapago"),
    @NamedQuery(name = "FormaDePago.findByNombre", query = "SELECT f FROM FormaDePago f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "FormaDePago.findByRegistroactivo", query = "SELECT f FROM FormaDePago f WHERE f.registroactivo = :registroactivo")})
public class FormaDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORMAPAGO")
    private Integer idFormapago;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "REGISTROACTIVO")
    private String registroactivo;
    @OneToMany(mappedBy = "idFormapago")
    private Collection<AbonoDeuda> abonoDeudaCollection;

    public FormaDePago() {
    }

    public FormaDePago(Integer idFormapago) {
        this.idFormapago = idFormapago;
    }

    public Integer getIdFormapago() {
        return idFormapago;
    }

    public void setIdFormapago(Integer idFormapago) {
        this.idFormapago = idFormapago;
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
    public Collection<AbonoDeuda> getAbonoDeudaCollection() {
        return abonoDeudaCollection;
    }

    public void setAbonoDeudaCollection(Collection<AbonoDeuda> abonoDeudaCollection) {
        this.abonoDeudaCollection = abonoDeudaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormapago != null ? idFormapago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaDePago)) {
            return false;
        }
        FormaDePago other = (FormaDePago) object;
        if ((this.idFormapago == null && other.idFormapago != null) || (this.idFormapago != null && !this.idFormapago.equals(other.idFormapago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.FormaDePago[ idFormapago=" + idFormapago + " ]";
    }
    
}
