/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.AbonoDeuda;

/**
 *
 * @author david
 */
@Stateless
public class AbonoDeudaFacade extends AbstractFacade<AbonoDeuda> {

    @PersistenceContext(unitName = "GestorCobranzasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonoDeudaFacade() {
        super(AbonoDeuda.class);
    }
    
}
