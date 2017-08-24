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
@DiscriminatorValue("fixed")
public class DiscountFixed extends DiscountType
{

    public DiscountFixed()
    {
    }
    
   double discount = 0.1;  //10% on all
  @Override
  public double calcDiscount(double priceItem, int quantity) {
    return priceItem * discount *quantity;
  }

    
}
