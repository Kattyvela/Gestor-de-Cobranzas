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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCedulaRuc", query = "SELECT c FROM Cliente c WHERE c.cedulaRuc = :cedulaRuc"),
    @NamedQuery(name = "Cliente.findByRucCliente", query = "SELECT c FROM Cliente c WHERE c.rucCliente = :rucCliente"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByTelfRef1", query = "SELECT c FROM Cliente c WHERE c.telfRef1 = :telfRef1"),
    @NamedQuery(name = "Cliente.findByTelfRef2", query = "SELECT c FROM Cliente c WHERE c.telfRef2 = :telfRef2"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByRegistroactivo", query = "SELECT c FROM Cliente c WHERE c.registroactivo = :registroactivo")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Size(max = 10)
    @Column(name = "CEDULA_RUC")
    private String cedulaRuc;
    @Size(max = 13)
    @Column(name = "RUC_CLIENTE")
    private String rucCliente;
    @Size(max = 12)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 12)
    @Column(name = "TELF_REF1")
    private String telfRef1;
    @Size(max = 12)
    @Column(name = "TELF_REF2")
    private String telfRef2;
    @Size(max = 250)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "REGISTROACTIVO")
    private String registroactivo;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Mora> moraCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCedulaRuc() {
        return cedulaRuc;
    }

    public void setCedulaRuc(String cedulaRuc) {
        this.cedulaRuc = cedulaRuc;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelfRef1() {
        return telfRef1;
    }

    public void setTelfRef1(String telfRef1) {
        this.telfRef1 = telfRef1;
    }

    public String getTelfRef2() {
        return telfRef2;
    }

    public void setTelfRef2(String telfRef2) {
        this.telfRef2 = telfRef2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRegistroactivo() {
        return registroactivo;
    }

    public void setRegistroactivo(String registroactivo) {
        this.registroactivo = registroactivo;
    }

    @XmlTransient
    public Collection<Mora> getMoraCollection() {
        return moraCollection;
    }

    public void setMoraCollection(Collection<Mora> moraCollection) {
        this.moraCollection = moraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
