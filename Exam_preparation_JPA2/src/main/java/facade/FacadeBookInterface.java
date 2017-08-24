/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Book;

/**
 *
 * @author Pravien
 */
public interface FacadeBookInterface
{

    void createBook(Book book);

    Book getBook(long id);

    void removeBook(Book book);

    void updateBook(Book book);
    
}
