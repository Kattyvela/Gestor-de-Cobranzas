/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class MoraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Mora")
    private int idMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Usuario_unidad_negocio_id_Usuario_unidad_negocio")
    private int usuariounidadnegocioidUsuariounidadnegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cliente_id_Cliente")
    private int clienteidCliente;

    public MoraPK() {
    }

    public MoraPK(int idMora, int usuariounidadnegocioidUsuariounidadnegocio, int clienteidCliente) {
        this.idMora = idMora;
        this.usuariounidadnegocioidUsuariounidadnegocio = usuariounidadnegocioidUsuariounidadnegocio;
        this.clienteidCliente = clienteidCliente;
    }

    public int getIdMora() {
        return idMora;
    }

    public void setIdMora(int idMora) {
        this.idMora = idMora;
    }

    public int getUsuariounidadnegocioidUsuariounidadnegocio() {
        return usuariounidadnegocioidUsuariounidadnegocio;
    }

    public void setUsuariounidadnegocioidUsuariounidadnegocio(int usuariounidadnegocioidUsuariounidadnegocio) {
        this.usuariounidadnegocioidUsuariounidadnegocio = usuariounidadnegocioidUsuariounidadnegocio;
    }

    public int getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(int clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMora;
        hash += (int) usuariounidadnegocioidUsuariounidadnegocio;
        hash += (int) clienteidCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoraPK)) {
            return false;
        }
        MoraPK other = (MoraPK) object;
        if (this.idMora != other.idMora) {
            return false;
        }
        if (this.usuariounidadnegocioidUsuariounidadnegocio != other.usuariounidadnegocioidUsuariounidadnegocio) {
            return false;
        }
        if (this.clienteidCliente != other.clienteidCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MoraPK[ idMora=" + idMora + ", usuariounidadnegocioidUsuariounidadnegocio=" + usuariounidadnegocioidUsuariounidadnegocio + ", clienteidCliente=" + clienteidCliente + " ]";
    }
    
}
