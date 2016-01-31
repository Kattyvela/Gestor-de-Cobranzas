/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.UsuarioUnidadNegocio;

/**
 *
 * @author david
 */
@Stateless
public class UsuarioUnidadNegocioFacade extends AbstractFacade<UsuarioUnidadNegocio> {

    @PersistenceContext(unitName = "GestorCobranzasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioUnidadNegocioFacade() {
        super(UsuarioUnidadNegocio.class);
    }
    
}
