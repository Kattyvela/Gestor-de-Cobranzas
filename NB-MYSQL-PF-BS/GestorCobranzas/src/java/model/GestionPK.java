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
public class GestionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Gestion")
    private int idGestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mora_id_Mora")
    private int moraidMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resultado_id_Resultado")
    private int resultadoidResultado;

    public GestionPK() {
    }

    public GestionPK(int idGestion, int moraidMora, int resultadoidResultado) {
        this.idGestion = idGestion;
        this.moraidMora = moraidMora;
        this.resultadoidResultado = resultadoidResultado;
    }

    public int getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(int idGestion) {
        this.idGestion = idGestion;
    }

    public int getMoraidMora() {
        return moraidMora;
    }

    public void setMoraidMora(int moraidMora) {
        this.moraidMora = moraidMora;
    }

    public int getResultadoidResultado() {
        return resultadoidResultado;
    }

    public void setResultadoidResultado(int resultadoidResultado) {
        this.resultadoidResultado = resultadoidResultado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idGestion;
        hash += (int) moraidMora;
        hash += (int) resultadoidResultado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionPK)) {
            return false;
        }
        GestionPK other = (GestionPK) object;
        if (this.idGestion != other.idGestion) {
            return false;
        }
        if (this.moraidMora != other.moraidMora) {
            return false;
        }
        if (this.resultadoidResultado != other.resultadoidResultado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GestionPK[ idGestion=" + idGestion + ", moraidMora=" + moraidMora + ", resultadoidResultado=" + resultadoidResultado + " ]";
    }
    
}
