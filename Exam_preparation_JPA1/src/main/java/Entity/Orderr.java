/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Pravien
 */
@Entity
@NamedQuery(name="Orderr.findOrder", query="SELECT c FROM Orderr c WHERE c.orderId LIKE :id")
public class Orderr implements Serializable
{


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @OneToMany(mappedBy = "orderr",cascade = CascadeType.PERSIST)
    private List<OrderLine> orderLines = new ArrayList();

    public Orderr()
    {
        
    }

    public Orderr(Customer customer)
    {
        this.customer = customer;
        
    }

    public List<OrderLine> getOrderLines()
    {
        return orderLines;
    }

    public void addOrderLines(OrderLine orderLines)
    {
        this.orderLines.add(orderLines);
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(long orderId)
    {
        this.orderId = orderId;
    }
    

    public Long getId()
    {
        return orderId;
    }

    public void setId(Long id)
    {
        this.orderId = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderr))
        {
            return false;
        }
        Orderr other = (Orderr) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Entity.Order[ id=" + orderId + " ]";
    }
    
}
