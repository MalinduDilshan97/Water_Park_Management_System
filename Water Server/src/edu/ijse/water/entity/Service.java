/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author SL_WOLF
 */
@Entity
public class Service {
    @Id
    private String serviceId;
    private String serviceName;
    private double price;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Service() {
    }

    public Service(String serviceId, String serviceName, double price, String password, Category category) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
        this.password = password;
        this.category = category;
    }

    /**
     * @return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceId=" + serviceId + ", serviceName=" + serviceName + ", price=" + price + ", password=" + password + '}';
    }

    
    
    
    
}
