/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author pmmacaya
 */
@Entity
public class Competence_Profile implements Serializable, Competence_ProfileDTO {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "competenceProfileIdSeq", 
            sequenceName = "COMPETENCEPROFILE_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competenceProfileIdSeq")
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "years_of_experience", nullable = false, columnDefinition="Decimal(4,2)")
    private Double years_of_experience;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "competence", referencedColumnName = "id", nullable = false)
    private Competence competence;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "application", referencedColumnName = "id", nullable = false)
    private Person person;
    
    public Competence_Profile(){
    }
    
    public Competence_Profile(Double years_of_experience, Competence competence,
                              Person person)
    {
        this.years_of_experience = years_of_experience;
        this.competence = competence;
        this.person = person;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public Long getCompetence(){
        return competence.getId();
    }
    
    public void setCompetence(Competence competence){
        this.competence = competence;
    }
    
    @Override
    public Double getYearsOfExperience(){
        return years_of_experience;
    }
    
    public void setYearsOfExperience(Double years_of_experience){
        this.years_of_experience = years_of_experience;
    }

    public Double getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(Double years_of_experience) {
        this.years_of_experience = years_of_experience;
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
        if (!(object instanceof Competence_Profile)) {
            return false;
        }
        Competence_Profile other = (Competence_Profile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.group17.recruitment.model.Competence_Profile[ id=" + id + " ]";
    }
    
}
