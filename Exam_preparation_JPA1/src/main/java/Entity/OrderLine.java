/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pravien
 */
@Entity
public class OrderLine implements Serializable
{

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ItemType itemType;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double qunatity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Orderr orderr;

    public OrderLine()
    {
    }

    public OrderLine(ItemType itemType, double qunatity,Orderr orderr)
    {
        this.orderr = orderr;
        this.itemType = itemType;
        this.qunatity = qunatity;
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public void setItemType(ItemType itemType)
    {
        this.itemType = itemType;
    }

    public double getQunatity()
    {
        return qunatity;
    }

    public void setQunatity(double qunatity)
    {
        this.qunatity = qunatity;
    }

    public Orderr getOrderr()
    {
        return orderr;
    }

    public void setOrderr(Orderr orderr)
    {
        this.orderr = orderr;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderLine))
        {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Entity.OrderLine[ id=" + id + " ]";
    }
    
}
