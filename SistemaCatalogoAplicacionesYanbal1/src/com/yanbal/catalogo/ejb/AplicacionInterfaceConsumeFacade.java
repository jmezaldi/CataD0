/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yanbal.catalogo.ejb;

import com.yanbal.catalogo.bean.AplicacionInterfaceConsume;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class AplicacionInterfaceConsumeFacade extends AbstractFacade<AplicacionInterfaceConsume> {
    @PersistenceContext(unitName = "SistemaCatalogoAplicacionesYanbalPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public AplicacionInterfaceConsumeFacade() {
        super(AplicacionInterfaceConsume.class);
    }
    
}
