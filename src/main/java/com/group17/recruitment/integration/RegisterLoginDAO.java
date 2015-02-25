/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.integration;

import com.group17.recruitment.model.Person;
import com.group17.recruitment.model.PersonDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pmmacaya
 */
@Stateless
public class RegisterLoginDAO {
    
    @PersistenceContext(unitName = "recruitmentPU")
    private EntityManager em;
    
    public Person checkUsername(String username){
        Query query = em.createQuery("SELECT p FROM Person AS p "
                + "WHERE p.username = ?", PersonDTO.class);
        query.setParameter(1, username);
        return (Person) query.getSingleResult();
    }
}
