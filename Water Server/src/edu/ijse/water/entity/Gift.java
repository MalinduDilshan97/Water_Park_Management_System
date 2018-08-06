/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author SL_WOLF
 */
@Entity
public class Gift {
    @Id
    private  String gid;
    private  String description;
    private double price;

    public Gift() {
    }

    public Gift(String gid, String description, double price) {
        this.gid = gid;
        this.description = description;
        this.price = price;
    }

    /**
     * @return the gid
     */
    public String getGid() {
        return gid;
    }

    /**
     * @param gid the gid to set
     */
    public void setGid(String gid) {
        this.gid = gid;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gift{" + "gid=" + gid + ", description=" + description + ", price=" + price + '}';
    }
    
    
    
}
