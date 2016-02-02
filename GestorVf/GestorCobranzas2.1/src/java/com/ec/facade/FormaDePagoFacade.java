/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.facade;

import com.ec.modelo.FormaDePago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class FormaDePagoFacade extends AbstractFacade<FormaDePago> {

    @PersistenceContext(unitName = "GestorCobranzas2.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaDePagoFacade() {
        super(FormaDePago.class);
    }
    
}
