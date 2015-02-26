/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.controller;

import com.group17.recruitment.integration.RegisterLoginDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author pmmacaya
 */
@Stateless
public class Controller {
    
    @EJB
    private RegisterLoginDAO registerLoginDAO;
   
    /**
     * Creates a new person with the specified data.
     *
     * @param name
     * @param surname
     * @param email
     * @param username Holder's username
     * @param password Holder's password
     * @return 
     */
    public Boolean createPerson(String username, String email, String name, String password, String surname)
    {
        return registerLoginDAO.register(username, email, name, password, surname);
    }
    
    /**
     * Search for the specified person.
     * 
     * @param username The username of the searched person.
     * @return The person if it was found.
     */
    public Boolean getPerson(String username){
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
