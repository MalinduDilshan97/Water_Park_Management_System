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
public class OrderDetailsDTO extends SuperDTO{
    private double price;
    private ServiceDTO serviceDTO;

    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(double price, ServiceDTO serviceDTO) {
        this.price = price;
        this.serviceDTO = serviceDTO;
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
     * @return the serviceDTO
     */
    public ServiceDTO getServiceDTO() {
        return serviceDTO;
    }

    /**
     * @param serviceDTO the serviceDTO to set
     */
    public void setServiceDTO(ServiceDTO serviceDTO) {
        this.serviceDTO = serviceDTO;
    }

    @Override
    public String toString() {
        return "OrderDetailsDTO{" + "price=" + price + ", serviceDTO=" + serviceDTO + '}';
    }
    
    
    
}
