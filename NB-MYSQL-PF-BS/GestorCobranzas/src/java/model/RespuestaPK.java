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
public class RespuestaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Respuesta")
    private int idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gestion_id_Gestion")
    private int gestionidGestion;

    public RespuestaPK() {
    }

    public RespuestaPK(int idRespuesta, int gestionidGestion) {
        this.idRespuesta = idRespuesta;
        this.gestionidGestion = gestionidGestion;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getGestionidGestion() {
        return gestionidGestion;
    }

    public void setGestionidGestion(int gestionidGestion) {
        this.gestionidGestion = gestionidGestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRespuesta;
        hash += (int) gestionidGestion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespuestaPK)) {
            return false;
        }
        RespuestaPK other = (RespuestaPK) object;
        if (this.idRespuesta != other.idRespuesta) {
            return false;
        }
        if (this.gestionidGestion != other.gestionidGestion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RespuestaPK[ idRespuesta=" + idRespuesta + ", gestionidGestion=" + gestionidGestion + " ]";
    }
    
}
