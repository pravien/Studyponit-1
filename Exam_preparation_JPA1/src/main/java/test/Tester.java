/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Entity.Customer;
import Entity.ItemType;
import Entity.OrderLine;
import Entity.Orderr;
import facade.FacadeCustomer;
import facade.FacadeItemType;
import facade.FacadeOrder;
import facade.FacadeOrderLine;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class Tester
{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
    public static void main(String[] args)
    {   
        Tester tester = new Tester();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        FacadeCustomer customerControl = new FacadeCustomer(emf);
        FacadeOrder orderControl = new FacadeOrder(emf);
          Customer cust = new Customer("jens","jens@gmail.dk");
//        Customer cust2 = new Customer("bo","bo@gmail.dk");
          Orderr order = new Orderr(cust);
         //customerControl.createCustomer(cust);
//        customerControl.createCustomer(cust2);
//        orderControl.createOrder(order);
//        orderControl.addOrderToCustomer(cust2, order);
//        //orderControl.addOrderToCustomer(cust2, order2);
        
        
        //test are ordreline og ordretype
        FacadeItemType itemTypeconttrol = new FacadeItemType(emf);
        FacadeOrderLine orderLineControl = new FacadeOrderLine(emf);
        
        ItemType itemType1 = new ItemType("skrue","4mm",20.0);
        OrderLine orderLine = new OrderLine(itemType1,2,order);
        //itemTypeconttrol.createItemType(itemType1);
        //orderLineControl.createOrderLine(orderLine);
        order.addOrderLines(orderLine);
        orderControl.createOrder(order);
        
        //order = orderControl.findOrder(order);
        //System.out.println(orderControl.findOrder(order).getOrderLines().get(0).get);
        System.out.println(tester.totalPriceOrder(order));
        //System.out.println(customerControl.findCustomer(cust).getName());
        //System.out.println(customerControl.getAllCustomer());
    }
    
    public  double totalPriceOrder(Orderr order){
       FacadeOrder orderControl = new FacadeOrder(emf);
       List<OrderLine> orders = orderControl.findOrder(order).getOrderLines();
        double sum=0;
        for(int i = 0; i<orders.size();i++){
            double qunatity = orders.get(i).getQunatity();
            double price = orders.get(i).getItemType().getPrice();
            sum+=qunatity*price;
        }
        return sum;
    }
}
