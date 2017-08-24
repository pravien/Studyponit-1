/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import facade.FacadeStudent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Pravien
 */
public class Tester
{
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        FacadeStudent facadeStudent = new FacadeStudent(emf);
        
        
        System.out.println(facadeStudent.amountOfStudentsForSemester("CLcos-v14e"));
    }
}
