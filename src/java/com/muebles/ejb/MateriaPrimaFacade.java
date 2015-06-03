/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.muebles.ejb;

import com.muebles.modelo.MateriaPrima;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class MateriaPrimaFacade extends AbstractFacade<MateriaPrima> {
    @PersistenceContext(unitName = "MueblesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaPrimaFacade() {
        super(MateriaPrima.class);
    }
    
}
