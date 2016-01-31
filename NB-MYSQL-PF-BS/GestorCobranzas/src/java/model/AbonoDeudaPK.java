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
public class AbonoDeudaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_Abono_Deuda")
    private int idAbonoDeuda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mora_id_Mora")
    private int moraidMora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mora_Usuario_unidad_negocio_id_Usuario_unidad_negocio")
    private int moraUsuariounidadnegocioidUsuariounidadnegocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mora_Cliente_id_Cliente")
    private int moraClienteidCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Forma_Pago_id_Forma_Pago")
    private int formaPagoidFormaPago;

    public AbonoDeudaPK() {
    }

    public AbonoDeudaPK(int idAbonoDeuda, int moraidMora, int moraUsuariounidadnegocioidUsuariounidadnegocio, int moraClienteidCliente, int formaPagoidFormaPago) {
        this.idAbonoDeuda = idAbonoDeuda;
        this.moraidMora = moraidMora;
        this.moraUsuariounidadnegocioidUsuariounidadnegocio = moraUsuariounidadnegocioidUsuariounidadnegocio;
        this.moraClienteidCliente = moraClienteidCliente;
        this.formaPagoidFormaPago = formaPagoidFormaPago;
    }

    public int getIdAbonoDeuda() {
        return idAbonoDeuda;
    }

    public void setIdAbonoDeuda(int idAbonoDeuda) {
        this.idAbonoDeuda = idAbonoDeuda;
    }

    public int getMoraidMora() {
        return moraidMora;
    }

    public void setMoraidMora(int moraidMora) {
        this.moraidMora = moraidMora;
    }

    public int getMoraUsuariounidadnegocioidUsuariounidadnegocio() {
        return moraUsuariounidadnegocioidUsuariounidadnegocio;
    }

    public void setMoraUsuariounidadnegocioidUsuariounidadnegocio(int moraUsuariounidadnegocioidUsuariounidadnegocio) {
        this.moraUsuariounidadnegocioidUsuariounidadnegocio = moraUsuariounidadnegocioidUsuariounidadnegocio;
    }

    public int getMoraClienteidCliente() {
        return moraClienteidCliente;
    }

    public void setMoraClienteidCliente(int moraClienteidCliente) {
        this.moraClienteidCliente = moraClienteidCliente;
    }

    public int getFormaPagoidFormaPago() {
        return formaPagoidFormaPago;
    }

    public void setFormaPagoidFormaPago(int formaPagoidFormaPago) {
        this.formaPagoidFormaPago = formaPagoidFormaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAbonoDeuda;
        hash += (int) moraidMora;
        hash += (int) moraUsuariounidadnegocioidUsuariounidadnegocio;
        hash += (int) moraClienteidCliente;
        hash += (int) formaPagoidFormaPago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbonoDeudaPK)) {
            return false;
        }
        AbonoDeudaPK other = (AbonoDeudaPK) object;
        if (this.idAbonoDeuda != other.idAbonoDeuda) {
            return false;
        }
        if (this.moraidMora != other.moraidMora) {
            return false;
        }
        if (this.moraUsuariounidadnegocioidUsuariounidadnegocio != other.moraUsuariounidadnegocioidUsuariounidadnegocio) {
            return false;
        }
        if (this.moraClienteidCliente != other.moraClienteidCliente) {
            return false;
        }
        if (this.formaPagoidFormaPago != other.formaPagoidFormaPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AbonoDeudaPK[ idAbonoDeuda=" + idAbonoDeuda + ", moraidMora=" + moraidMora + ", moraUsuariounidadnegocioidUsuariounidadnegocio=" + moraUsuariounidadnegocioidUsuariounidadnegocio + ", moraClienteidCliente=" + moraClienteidCliente + ", formaPagoidFormaPago=" + formaPagoidFormaPago + " ]";
    }
    
}
