/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Customer;
import Entity.Orderr;

/**
 *
 * @author Pravien
 */
public interface FacadeOrderInterface
{

    void addOrderToCustomer(Customer customer, Orderr order);

    void createOrder(Orderr order);

    Orderr findOrder(Orderr order);
    
}
