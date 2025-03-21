package com.diversBrain.models;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "symptoms")
public class Symptoms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date date;
    private Duration lasting; 
    private int intensity;
    private String triggers; 
    private String calming;
    private String description;


    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id")
    // private User user;

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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((lasting == null) ? 0 : lasting.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + intensity;
        result = prime * result + ((triggers == null) ? 0 : triggers.hashCode());
        result = prime * result + ((calming == null) ? 0 : calming.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Symptoms other = (Symptoms) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (lasting == null) {
            if (other.lasting != null)
                return false;
        } else if (!lasting.equals(other.lasting))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (intensity != other.intensity)
            return false;
        if (triggers == null) {
            if (other.triggers != null)
                return false;
        } else if (!triggers.equals(other.triggers))
            return false;
        if (calming == null) {
            if (other.calming != null)
                return false;
        } else if (!calming.equals(other.calming))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Symptoms [date=" + date + ", lasting=" + lasting + ", nom=" + name + ", intensity=" + intensity
                + ", triggers=" + triggers + ", calming=" + calming + ", description=" + description + "]";
    }
    
    public Symptoms(Date date, Duration lasting, String name, int intensity, String triggers, String calming,
            String description) {
        this.date = date;
        this.lasting = lasting;
        this.name = name;
        this.intensity = intensity;
        this.triggers = triggers;
        this.calming = calming;
        this.description = description;
    }

    public Symptoms() {
    }
    // public void setUser(User currentUser) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    // }
    
}
