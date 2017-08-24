/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaControl;

import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class Structure
{
    public static void main(String[] args)
    {
        HashMap puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source","scripts/DropCreate.sql");
        
        Persistence.generateSchema("JPAPU", puproperties);
        puproperties.remove("javax.persistence.sql-load-script-source");
        
        //puproperties.put("javax.persistence.sql-load-script-source",puproperties);
        
        Persistence.generateSchema("JPAPU", puproperties);
    
    }
    
}
