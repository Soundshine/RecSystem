/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pmmacaya
 */
@Entity
@Table(name="\"Role\"")
public class Role implements Serializable, RoleDTO {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "roleIdSeq", sequenceName = "ROLETYPE_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleIdSeq")
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name="name", nullable = false, unique = true)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<Person> persons;
    
    public Role() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String getName(){
        return name;
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group17.recruitment.model.Role[ id=" + id + " ]";
    }
    
}
