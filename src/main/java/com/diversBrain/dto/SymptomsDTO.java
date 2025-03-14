package com.diversBrain.dto;

import java.sql.Date;
import java.time.Duration;

public class SymptomsDTO {
    private String name;
    private Date date;
    private Duration lasting; 
    private int intensity;
    private String triggers; 
    private String calming;
    private String description;



    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Duration getLasting() {
        return lasting;
    }
    public void setLasting(Duration lasting) {
        this.lasting = lasting;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIntensity() {
        return intensity;
    }
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    public String getTriggers() {
        return triggers;
    }
    public void setTriggers(String triggers) {
        this.triggers = triggers;
    }
    public String getCalming() {
        return calming;
    }
    public void setCalming(String calming) {
        this.calming = calming;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public SymptomsDTO() {
    }

    
}
