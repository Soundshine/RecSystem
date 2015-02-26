package com.group17.recruitment.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author pmmacaya
 */
@Entity
@Table(name = "person")
public class Person implements Serializable, PersonDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "personIdSeq", sequenceName = "PERSON_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personIdSeq")
    @Column(name = "id")
    private Long id;
    
    @Column(name="username", unique = true, nullable = false)
    private String username;
    
    @Column(name="password", nullable = false)
    private String password;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "ssn", length = 13)
    private String ssn;
    
    @Column(name = "email", nullable = false)
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    private String email;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Competence_Profile> competenceProfile;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<Availability> availability;
    
    /**
     * Creates a new instance of Person
     */
    public Person(){
    }
    
    /**
     * Creates a new instance of Account
     * @param name
     * @param surname
     * @param username
     * @param email
     * @param password
     * @param role
     */
    public Person(String username, String email, String name, String password, String surname, Role role){
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.role = role;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
           
    @Override
    public Long getRole() {
       return role.getId(); 
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group17.recruitment.model.Person[ id=" + id + " ]";
    }       

}
