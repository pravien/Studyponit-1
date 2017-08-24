/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Pravien
 */
public interface FacadeCustomerInterface
{
    
    public void createCustomer(Customer customer);
    
    
    
    public Customer findCustomer(Customer customer);
    
    public List<Customer> getAllCustomer();
    
}
