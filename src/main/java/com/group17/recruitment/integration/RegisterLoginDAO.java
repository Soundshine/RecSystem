/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.integration;

import com.group17.recruitment.model.Person;
import com.group17.recruitment.model.PersonDTO;
import com.group17.recruitment.model.Role;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author pmmacaya
 */
@Stateless
public class RegisterLoginDAO {
    
    @PersistenceContext(unitName = "recruitmentPU")
    private EntityManager em;
    
    public PersonDTO checkUsername(String username){
        Query query = em.createQuery("SELECT p FROM Person AS p "
                + "WHERE p.username = ?1");
        return (PersonDTO) query.setParameter(1, username).getSingleResult();
    }
    
    public Boolean register (String username, String email, String name, String password, String surname)
    {
        Query query = em.createNativeQuery("SELECT id FROM Role WHERE name = ?1");
        query.setParameter(1, "applicant");
        Long roleId = (Long)query.getSingleResult();
        
        Person person = new Person(username, email, name, password, surname,
                        em.find(Role.class, roleId));
        em.persist(person);
        
        return true;
    }
    
    
}
