/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harold
 */
@Stateless
public class CategoriaEquipoFacade extends AbstractFacade<CategoriaEquipo> {

    @PersistenceContext(unitName = "reportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaEquipoFacade() {
        super(CategoriaEquipo.class);
    }
    
}
