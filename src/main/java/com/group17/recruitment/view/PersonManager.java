package com.group17.recruitment.view;

import com.group17.recruitment.controller.Controller;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
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
@Named(value = "personManager")
@ConversationScoped
public class PersonManager implements Serializable 
{
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private Controller controller;
    private String username;
    private String password;
    private String message;

    private Exception transactionFailure;
    @Inject
    private Conversation conversation;

    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }


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
        stopConversation();
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

    /**
     * Logins the user in case the user has already an account
     * @return an empty string
     */   /* 
    public String login()
    {   
        message = "";
        
        startConversation();

        PersonDTO account = controller.getAccount(username);

        if (account == null)
        {
            setMessage("You are not registered in the system.");
        }
        else if (account.getBanned()!= 0)
        {
            setMessage("You have been banned. You cannot enter into the system.");
        }
        else if (account.getPassword().equals(password) == false)
        {
            setMessage("The password is incorrect.");
        }
        else
        {
            if (account.getUsername().equalsIgnoreCase("admin"))
                return "admin";
            else
                return "customer";                
        }
        return "login";
    }*/

    /**
     * Log outs the user (stops the conversation)
     * 
     * @return password
     */  /*  
    public String logout()
    {
        username = null;
        password = null;

        stopConversation();
        
        return "login";
    }*/
}
