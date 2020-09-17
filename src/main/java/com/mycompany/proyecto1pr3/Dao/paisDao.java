/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.proyecto1pr3.Dao;

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
public class paisDao {

    protected EntityManager em;
    private EntityManagerFactory tran = null;
    
    
    public paisDao (){
    
        tran = Persistence.createEntityManagerFactory("HibernatePU");
    
    }
    
    public PaisModelo fyndbyId(PaisModelo O){
        em = getEntityManager();
        return em.find(PaisModelo.class, O.getId());
    }
    
    private EntityManager getEntityManager(){
        
        return tran.createEntityManager();     
    
    }
    
    
    public void selectall(){
    
    //Iniciamos variable que contiene la sentencia a ejecutar
     
        em = getEntityManager();
        String hql = "SELECT O FROM PaisModelo O ";
        Query query = em.createQuery(hql);
        List<PaisModelo> lista = query.getResultList();
        for (PaisModelo O : lista){
        System.out.print(O + "\n");
        }
        
    }

    
    
    
    public void Insertar (PaisModelo pais1){
    
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pais1);
            em.getTransaction().commit();
            

        }catch (Exception ex){
        
            System.out.println("Error al insertar:" + ex.getMessage());
        
        
        }finally{
        
        if(em !=null){
            em.close();
            }
        
        }
    }

        
     public void actualizar (PaisModelo pais1){
     try{
         em = getEntityManager();
         em.getTransaction().begin();
         em.merge(pais1);
         em.getTransaction().commit();
         
     
     }catch (Exception ex){
     
         System.out.println("Error al actualizar el objeto:"+ex.getMessage());
     
     
        }finally{
            if(em !=null){
                
                em.close();
            
            }
        }  
         
     }
    
    
    public void eliminar (PaisModelo pais1){
    try{
        em = getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(pais1));
        em.getTransaction().commit();

   
    
    }catch (Exception ex){
        System.out.println("Error al eliminar el pais:"+ ex.getMessage());
    
    
        }finally{
    
        if(em !=null){
            em.close();
            
            }
        }
    }   
}
