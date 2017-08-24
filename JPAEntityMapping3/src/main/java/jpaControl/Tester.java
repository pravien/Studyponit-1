/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;


import entity.Customer;
import entity.DiscountFixed;
import entity.DiscountQuantity;
import entity.DiscountType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester
{
    
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU3");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //enums testcode
        Customer cust = new Customer("cake");
        DiscountType dt = new DiscountQuantity();
        DiscountType dt1 = new DiscountFixed();
        DiscountType dt2 = new DiscountFixed();
        cust.setdType(dt);
        cust.setdType(dt1);
        cust.setdType(dt2);
        em.persist(cust);
        em.getTransaction().commit();//committer sql statement
        em.close();
    }
    
}
