/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author harold
 */
@Stateless
public class ComputadoraFacade extends AbstractFacade<Computadora> {

    @PersistenceContext(unitName = "reportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputadoraFacade() {
        super(Computadora.class);
    }
    
     public List<Computadora> ListaComputadorasDir(String dir){
    
       return getEntityManager().createQuery("Select a FROM Computadora as a where a.nombreDireccion.nombre='"+dir+"'",Computadora.class).getResultList();
        
    }
    
}
