/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Semester;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Pravien
 */
public class FacadeStudent
{

    EntityManagerFactory emf;

    public FacadeStudent(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    public List<Student> getAllStudents(){
        List list = new ArrayList();
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            list = em.createNamedQuery("Student.findAl").getResultList();
            em.getTransaction().commit();
            return list;
        } finally
        {
            em.close();
        } 
    }
    
    public List<Student> getStudentsByName(String name){
        EntityManager em = emf.createEntityManager();
        List list = new ArrayList();
        try
        {
            em.getTransaction().begin();
            list = em.createNamedQuery("Student.findByFirstname").getResultList();
            em.getTransaction().commit();
            return list;
        } finally
        {
            em.close();
        }        
    }
    
    public void createStudent(Student student){
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }
    
    public void assignStudentToSemester(Student student,long semesterId){
        EntityManager em = emf.createEntityManager();
        student.setCurrentsemesterId(semesterId);
        try
        {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } finally
        {
            em.close();
        }
    }
            
     public List<Student> getStudentsByLastName(String lastName){
        EntityManager em = emf.createEntityManager();
        List list = new ArrayList();
        try
        {
            em.getTransaction().begin();
            list = em.createNamedQuery("Student.findByLastname").getResultList();
            em.getTransaction().commit();
            return list;
        } finally
        {
            em.close();
        }        
    }
     
     public int amountOfStudentsForSemester(String semesterName){
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            int k = (int) em.createNamedQuery("Student.amountOfStudentsForSemester").setParameter("name", semesterName).getSingleResult();
            em.getTransaction().commit();
            return k;
        } finally
        {
            em.close();
        }        
    }
}
