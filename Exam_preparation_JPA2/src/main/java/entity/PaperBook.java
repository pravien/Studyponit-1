/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Pravien
 */
@DiscriminatorValue("PaperBook")
@Entity
public class PaperBook extends Book
{
    private double shippingWeight;
    private boolean inStock;

    public PaperBook()
    {
    }

    public PaperBook(double shippingWeight, boolean inStock, Long Isbn, String title, String author, double price)
    {
        super(Isbn, title, author, price);
        this.shippingWeight = shippingWeight;
        this.inStock = inStock;
    }

    
    
    public double getShippingWeight()
    {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight)
    {
        this.shippingWeight = shippingWeight;
    }

    public boolean isInStock()
    {
        return inStock;
    }

    public void setInStock(boolean inStock)
    {
        this.inStock = inStock;
    }
    
    
    
}
