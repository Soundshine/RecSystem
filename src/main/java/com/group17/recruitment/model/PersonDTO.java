package com.group17.recruitment.model;

/**
 * The views read-only view of an Account.
 *
 * @author pmmacaya
 */
public interface PersonDTO {
        
    /**
     * Gets the username of the holder of this Account.
     *
     * @return the username of the holder of this Account.
     */
    public String getUsername();
    
    /**
     * Gets the password of the holder of this Account.
     *
     * @return the password of the holder of this Account.
     */    
    public String getPassword();  
    
    public Long getId();
    public String getName();
    public String getSurname();
    public String getEmail();
    public Long getRole();
    
}
