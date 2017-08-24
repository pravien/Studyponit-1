/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.OrderLine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeOrderLine implements FacadeOrderLineInterface
{

    private final EntityManagerFactory emf;

    public FacadeOrderLine(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public void createOrderLine(OrderLine orderLine)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(orderLine);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

}
