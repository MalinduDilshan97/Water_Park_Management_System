/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.dto;

/**
 *
 * @author SL_WOLF
 */
public class FoodDTO extends SuperDTO{
    
    private  String fid;
    private  String description;
    private double price;

    public FoodDTO() {
    }

    public FoodDTO(String fid, String description, double price) {
        this.fid = fid;
        this.description = description;
        this.price = price;
    }

    /**
     * @return the fid
     */
    public String getFid() {
        return fid;
    }

    /**
     * @param fid the fid to set
     */
    public void setFid(String fid) {
        this.fid = fid;
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
        return "Food{" + "fid=" + fid + ", description=" + description + ", price=" + price + '}';
    }
    
    
    
}
