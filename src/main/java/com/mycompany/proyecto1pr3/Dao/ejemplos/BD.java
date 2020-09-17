/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto1pr3.Dao.ejemplos;

import com.mycompany.proyecto1pr3.Dao.modelo.PaisModelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BD {

    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public BD (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
      
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
        
        
    public void consultar(){
    em = getEntityManager();
    String sql = "SELECT * FROM pais";
    Query query = em.createNativeQuery(sql,PaisModelo.class);
    List<PaisModelo> lista = query.getResultList();
    for (PaisModelo p : lista){
        System.out.print(p + "\n");
        }
    }
    
    
    public void Insertar(Integer id, String nombre, String abreviatura, String idioma, String moneda, String religion){
        
        try{
        em=getEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO PAIS(ID,NOMBRE,ABREVIATURA,IDIOMA,MONEDA,RELIGION)VALUES(?,?,?,?,?,?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, id);
        query.setParameter(2, nombre);
        query.setParameter(3, abreviatura);
        query.setParameter(4, idioma);
        query.setParameter(5, moneda);
        query.setParameter(6, religion);
        query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Inserción de pais con exito");
    
        }catch(Exception ex){
        System.out.println("Sucedio un error en la ejecucion " + ex.getMessage());
        
        
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
    
    
    }
  
    public void actualizar(String nombre, String abreviatura, String idioma, String moneda, String religion, Integer id){
        try{ 
            em=getEntityManager();
            em.getTransaction().begin();
            String sql = "UPDATE PAIS SET NOMBRE=?,ABREVIATURA=?,IDIOMA=?,MONEDA=?,RELIGION=?, WHERE ID=?";
            Query query = em.createNativeQuery(sql);
            query.setParameter(1, nombre);
            query.setParameter(2, abreviatura);
            query.setParameter(3, idioma);
            query.setParameter(4, moneda);
            query.setParameter(5, religion);
            query.setParameter(6, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Actualización de pais con exito");
    
        }catch(Exception ex){
            System.out.println("Sucedio un error en la ejecucion " + ex.getMessage());
                
        }finally{
        if(em !=null){
            em.close();
            
            }
                      
        }
    
    }
    
  
 
    public void eliminar(Integer id) {
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            String sql = "DELETE FROM PAIS WHERE ID = ?";
            Query query = em.createNativeQuery(sql).setParameter(1, id);
            query.executeUpdate();
            em.getTransaction().commit();
            System.out.println("Borrado de pais satisfactorio");
           
        }catch(Exception ex){
            
            System.out.println("Sucedio un error en la ejecucion"+ex.getMessage());
       
        }finally{
    
        if(em !=null){
            em.close();
            
            }
    
        }
             
        
    }

    
}
