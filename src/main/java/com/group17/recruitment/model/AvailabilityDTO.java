/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group17.recruitment.model;

import java.util.Date;

/**
 *
 * @author pmmacaya
 */
public interface AvailabilityDTO {
    public Date getToDate();
    public Date getFromDate();
    public Long getId();
    public Long getPerson();
    
    
}
