/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

/**
 *
 * @author Pravien
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name="Book.findAll", query="SELECT c FROM Book c")
public class Book implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long Isbn;
    private String title;
    private String author;
    private double price;

    public Book()
    {
    }

    public Book(Long Isbn, String title, String author, double price)
    {
        this.Isbn = Isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public Long getIsbn()
    {
        return Isbn;
    }

    public void setId(Long Isbn)
    {
        this.Isbn = Isbn;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (Isbn != null ? Isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book))
        {
            return false;
        }
        Book other = (Book) object;
        if ((this.Isbn == null && other.Isbn != null) || (this.Isbn != null && !this.Isbn.equals(other.Isbn)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Book[ id=" + Isbn + " "+title+"]";
    }
    
}
