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
import javax.persistence.Query;

/**
 *
 * @author harold
 */
@Stateless
public class ReporteFacade extends AbstractFacade<Reporte> {

    @PersistenceContext(unitName = "reportPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteFacade() {
        super(Reporte.class);
    }
    
    public List<Reporte> ListaReporte(String estado){
    
       return getEntityManager().createQuery("Select a FROM Reporte as a WHERE a.estadoReporte='"+estado+"'",Reporte.class).getResultList();
        
    }
    
     public List<Reporte> conforme(String estado){
    
       return getEntityManager().createQuery("Select a FROM Reporte as a WHERE a.conformidad ='"+estado+"'",Reporte.class).getResultList();
        
    }
     
     public List<Reporte> listadoReporte(String estado){
    
       return getEntityManager().createQuery("Select a FROM Reporte as a WHERE a.estadoReporte='"+estado+"' ORDER BY a.fechaCreado ASC",Reporte.class).getResultList();
        
    }
     
     public List<Computadora> ListaPC(String estado){
    
       return getEntityManager().createQuery("Select a FROM Computadora as a WHERE a.nombrePc='"+estado+"'",Computadora.class).getResultList();
        
    }
     
     public void update(String nombre, int id){
        
    Query query = getEntityManager().createQuery("UPDATE Reporte SET idComputadora=':idComputadora' WHERE equipo=':equipo'");
    query.setParameter("idComputadora", id);
    query.setParameter("equipo", nombre);
    query.executeUpdate();
  
     }
     
    
    
}
