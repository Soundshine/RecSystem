/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pmmacaya
 */
@Entity
public class Availability implements Serializable, AvailabilityDTO {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "availabilityIdSeq", sequenceName = "AVAILABILITY_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "availabilityIdSeq")
    @Column(name = "id")
    private Long id;
    
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "person", referencedColumnName = "id", nullable = false)
    private Person person;
            
    public Availability(){
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Availability(Date fromDate, Date toDate, Person person)
    {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.person = person;
    }

    @Override
    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public Long getPerson() {
        return person.getId();
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Availability)) {
            return false;
        }
        Availability other = (Availability) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group17.recruitment.model.Availability[ id=" + id + " ]";
    }
    
}
