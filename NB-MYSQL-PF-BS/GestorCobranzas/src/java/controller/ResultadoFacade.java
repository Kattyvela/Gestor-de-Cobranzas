/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Resultado;

/**
 *
 * @author david
 */
@Stateless
public class ResultadoFacade extends AbstractFacade<Resultado> {

    @PersistenceContext(unitName = "GestorCobranzasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultadoFacade() {
        super(Resultado.class);
    }
    
}
