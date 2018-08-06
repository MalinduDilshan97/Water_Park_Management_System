/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SL_WOLF
 */
@Entity
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;
    private String message;
    private String date;

    public Messages() {
    }

    public Messages(int mid, String message, String date) {
        this.mid = mid;
        this.message = message;
        this.date = date;
    }

    /**
     * @return the mid
     */
    public int getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(int mid) {
        this.mid = mid;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Messages{" + "mid=" + mid + ", message=" + message + ", date=" + date + '}';
    }
    
     
    
    
}
