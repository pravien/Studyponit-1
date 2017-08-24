/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Book;
import entity.EBook;
import entity.PaperBook;
import facade.FacadeBook;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class test
{
    
    public static void main(String[] args)
    {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
       
       Book book1 = new Book(1l,"jenslyn","john",20);
       Book book2 = new EBook("www.jen.dk",100,22l,"jenslyn","john",20);
       Book book3 = new PaperBook(50,true,44l,"jenslyn","john",20);
       
       FacadeBook facadeBook = new FacadeBook(emf);
       //add books
       facadeBook.createBook(book1);
       facadeBook.createBook(book2);
       facadeBook.createBook(book3);
       System.out.println(facadeBook.getAllBooks());
       
       //update tilte
       book1.setTitle("bolyn");
       book2.setTitle("samse");
       book3.setTitle("yolo");
       facadeBook.updateBook(book1);
       facadeBook.updateBook(book2);
       facadeBook.updateBook(book3);
       System.out.println(facadeBook.getAllBooks());
       
       //delete every customer, we expect size 0.
       facadeBook.removeBook(book1);
       facadeBook.removeBook(book2);
       facadeBook.removeBook(book3);
       System.out.println(facadeBook.getAllBooks().size());
        
    }
    
}
