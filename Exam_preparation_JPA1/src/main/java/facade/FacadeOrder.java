/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Customer;
import Entity.Orderr;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeOrder implements FacadeOrderInterface
{
    
    private final EntityManagerFactory emf;
    

    public FacadeOrder(EntityManagerFactory emf)
    {
        this.emf = emf;
        
    }
    
    @Override
    public void createOrder(Orderr order){
        EntityManager em= emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(order);
            em.persist(order.getCustomer());
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }
    
    @Override
    public void addOrderToCustomer (Customer customer, Orderr order){
        EntityManager em= emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            order.setCustomer(customer);
            em.merge(order);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }
    
    @Override
    public Orderr findOrder(Orderr order){
       EntityManager em= emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            order= em.find(Orderr.class, order.getId());
            em.getTransaction().commit();
            return order;
        } finally
        {
            em.close();
        } 
    }
    
}
