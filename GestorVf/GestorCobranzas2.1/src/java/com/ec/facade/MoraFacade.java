/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.facade;

import com.ec.modelo.Mora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class MoraFacade extends AbstractFacade<Mora> {

    @PersistenceContext(unitName = "GestorCobranzas2.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MoraFacade() {
        super(Mora.class);
    }
    
}
