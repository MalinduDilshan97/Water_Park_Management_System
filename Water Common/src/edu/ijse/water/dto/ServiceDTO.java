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
public class ServiceDTO extends SuperDTO{
    
    private String serviceId;
    private String serviceName;
    private double price;
    private String password;
    private CategoryDTO categoryDTO;

    public ServiceDTO() {
    }

    public ServiceDTO(String serviceId, String serviceName, double price, String password, CategoryDTO categoryDTO) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
        this.password = password;
        this.categoryDTO = categoryDTO;
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
     * @return the categoryDTO
     */
    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    /**
     * @param categoryDTO the categoryDTO to set
     */
    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" + "serviceId=" + serviceId + ", serviceName=" + serviceName + ", price=" + price + ", password=" + password + '}';
    }

    

   
  
    
    
    
}
