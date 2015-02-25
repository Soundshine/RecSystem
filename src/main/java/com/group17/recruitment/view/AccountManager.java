package com.group17.recruitment.view;

import com.group17.recruitment.controller.Controller;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * PersonManager is a managed bean that works as Model for the UI.
 * It has setter and getter methods called by login.xhtml
 * 
 * 
 * It has action handling methods called by JSF
 * 
 * @author pmmacaya
 */
@Named(value = "accountManager")
@RequestScoped
public class AccountManager implements Serializable 
{
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private Controller controller;
    private String name;
    private String surname;
    private String ssn;
    private String email;
    private String username;
    private String password;
    private String message;

    private Exception transactionFailure;

    /**
     * @return <code>true</code> if the latest transaction succeeded, otherwise
     * <code>false</code>.
     */
    public boolean getSuccess() {
        return transactionFailure == null;
    }

    /**
     * @return The latest thrown exception.
     */
    public Exception getException() {
        return transactionFailure;
    }

    private void handleException(Exception e) {
        e.printStackTrace(System.err);
        transactionFailure = e;
    }
    /**
     * This return value is needed because of a JSF 2.2 bug. Note 3 on page 7-10
     * of the JSF 2.2 specification states that action handling methods may be
     * void. In JSF 2.2, however, a void action handling method plus an
     * if-element that evaluates to true in the faces-config navigation case
     * causes an exception.
     *
     * @return an empty string.
     */
    private String jsf22Bugfix() {
        return "";
    }
    
    /**
     * Creates an account in case the username is not in use
     *
     * @return an empty string.
     */    
    public String register()
    {  
        try{
            message = "";
            transactionFailure = null;

            //Man måste kontrollera att ingen 
            if (controller.getPerson(username)!= null)
            {
                setMessage("This username already exists. Please, choose another one.");
                return "login";
            }
            else
            {            
                controller.createPerson(username, email, name, password, surname);
                setMessage("You have been successfully registered. Now you can log in.");
                return "confirmation";
            }        
        }

        catch (Exception e) {
            handleException(e);
        }
       
        return jsf22Bugfix();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Method for setting the message parameter of the Person Manager bean
     * @param message 
     */    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    /**
     * Method for getting the message parameter of the Person Manager bean
     * @return message 
     */   
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Method for setting the username parameter of the Person Manager bean
     * @param username
     */
    public void setUsername(String username)
    {
       this.username = username;
    }


    /**
     * Method for getting the username parameter of the Person Manager bean
     * @return username 
     */
    public String getUsername()
    {
       return username;
    }

    /**
     * Method for setting the password parameter of the Person Manager bean
     * @param password 
     */
    public void setPassword(String password)
    {
       this.password = password;
    }

    /**
     * Method for getting the password parameter of the Person Manager bean
     * @return password
     */
    public String getPassword()
    {
       return password;
    }

}
