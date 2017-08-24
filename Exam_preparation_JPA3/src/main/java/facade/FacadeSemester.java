/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Semester;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeSemester
{
    EntityManagerFactory emf;

    public FacadeSemester(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public Semester findIdBySemesterName(String semesterName){
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Semester semester = (Semester) em.createNamedQuery("Semester.findByName").getSingleResult();
            em.getTransaction().commit();
            return semester;
        } finally
        {
            em.close();
        }
    }
    
}
