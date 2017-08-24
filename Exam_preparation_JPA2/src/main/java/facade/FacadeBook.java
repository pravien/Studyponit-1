/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeBook implements FacadeBookInterface
{

    EntityManagerFactory emf;

    public FacadeBook(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public void createBook(Book book)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

    @Override
    public Book getBook(long id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Book book = em.find(Book.class, id);
            em.getTransaction().commit();
            return book;
        } finally
        {
            em.close();
        }
    }

    @Override
    public void updateBook(Book book)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

    @Override
    public void removeBook(Book book)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            if (!em.contains(book))
            {
                book = em.merge(book);
            }
            em.remove(book);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }

    public List<Book> getAllBooks()
    {
        List list = new ArrayList();
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            list = em.createNamedQuery("Book.findAll").getResultList();
            em.getTransaction().commit();
            return list;
        } finally
        {
            em.close();
        }

    }

}
