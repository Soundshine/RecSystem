/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.controller;

import com.group17.recruitment.integration.RegisterLoginDAO;
import com.group17.recruitment.model.Person;
import com.group17.recruitment.model.PersonDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pmmacaya
 */
@Stateless
public class Controller {
    
    @EJB
    private RegisterLoginDAO registerLoginDAO;

    @PersistenceContext(unitName = "recruitmentPU")
    private EntityManager em;
   
    /**
     * Creates a new account with the specified data.
     *
     * @param name
     * @param surname
     * @param email
     * @param username Holder's username
     * @param password Holder's password
     */
    public Boolean createPerson(String username, String email, String name, String password, String surname)
    {
        return registerLoginDAO.register(name, surname, email, username, password);
    }
    
    /**
     * Search for the specified account.
     * 
     * @param username The account username of the searched account.
     * @return The account if it was found.
     */
    public PersonDTO getPerson(String username){
        try
        {           
           return registerLoginDAO.checkUsername(username);
        }
        catch (Exception e)
        {
            return null;
        }       
    }
}
