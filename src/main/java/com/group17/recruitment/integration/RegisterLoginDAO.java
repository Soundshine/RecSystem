/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.integration;

import com.group17.recruitment.model.Person;
import com.group17.recruitment.model.PersonDTO;
import com.group17.recruitment.model.Role;
import java.util.List;
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
    
    public Boolean checkUsername(String username){
        Query query = em.createNativeQuery("SELECT * FROM Person WHERE username = ?");
        query.setParameter(1, username);
        return query.getResultList().size() <= 0;
    }
    
    public Boolean register (String username, String email, String name, String password, String surname)
    {
        Query query = em.createNativeQuery("SELECT id FROM Role WHERE name = 'applicant'");
        Long roleId = (Long)query.getSingleResult();
        
        Person person = new Person(username, email, name, password, surname,
                        em.find(Role.class, roleId));
        em.persist(person);
        
        return true;
    }
    
    private List<PersonDTO> checkUsernameAndPassword(String username, String password)
    {
        Query query = em.createQuery("SELECT p FROM Person AS p "
                + "WHERE p.username = ?1 AND p.password = ?2", PersonDTO.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return query.getResultList();
    }
    
    private String getRoleName(Long roleId)
    {
        Query query = em.createNativeQuery("SELECT name FROM Role "
            + "WHERE id = ?");
        query.setParameter(1, roleId);
        String roleName = (String)query.getSingleResult();
        
        return roleName;
    }   
    
    public Boolean loginAsApplicant(String username, String password)
    {
        List<PersonDTO> listPersons = checkUsernameAndPassword(username, password);
        if(listPersons.size() > 0)
        {
            if(getRoleName(listPersons.get(0).getRole()).equals("applicant"))
                return true;
        }
        return false;
    }
    
    public Boolean loginAsRecruiter(String username, String password)
    {
        List<PersonDTO> listPersons = checkUsernameAndPassword(username, password);
        if(listPersons.size() > 0)
        {
            if(getRoleName(listPersons.get(0).getRole()).equals("recruiter"))
                return true;
        }
        return false;
    }
    
}
