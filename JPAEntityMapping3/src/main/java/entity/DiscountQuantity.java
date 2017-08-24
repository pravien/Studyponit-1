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
@Entity
@DiscriminatorValue("Quan")
public class DiscountQuantity extends DiscountType
{

    public DiscountQuantity()
    {
    }
    int quantityForDiscount = 3;
    double discount = 0.2; //20% on all if quantity is 3 or more

    @Override
    public double calcDiscount(double priceItem, int quantity)
    {
        return quantity >= quantityForDiscount ? priceItem * quantity * discount : 0;
    }

}
