/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeCustomer implements FacadeCustomerInterface
{
    EntityManagerFactory emf;
    public FacadeCustomer(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    @Override
    public void createCustomer(Customer customer)
    {
       EntityManager em= emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }

    }
    @Override
    public Customer findCustomer(Customer customer){
      EntityManager em= emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            customer= em.find(Customer.class, customer.getId());
            em.getTransaction().commit();
            return customer;
        } finally
        {
            em.close();
        }
    }
    @Override
    public List<Customer> getAllCustomer(){
       EntityManager em= emf.createEntityManager();
        List<Customer> customers = new ArrayList();
        try
        {
            em.getTransaction().begin();
            customers=em.createNamedQuery("Customer.findAll").getResultList();
            em.getTransaction().commit();
            return customers;
        } finally
        {
            em.close();
        }
    }

    
}
