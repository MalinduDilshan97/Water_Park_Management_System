/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author SL_WOLF
 */
@Entity
public class OrderDetails {
    
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false))
    private Orders orders;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "serviceId",referencedColumnName = "serviceId",insertable = false,updatable = false))
    private Service service;
    @EmbeddedId
    private OrderDetails_PK orderDetails_PK;

    public OrderDetails() {
    }

    public OrderDetails(int oid,String serviceId,double price, Orders orders, Service service) {
        this.price = price;
        this.orders = orders;
        this.service = service;
        orderDetails_PK =(new OrderDetails_PK(oid, serviceId));
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
     * @return the orders
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     * @return the service
     */
    public Service getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * @return the orderDetails_PK
     */
    public OrderDetails_PK getOrderDetails_PK() {
        return orderDetails_PK;
    }

    /**
     * @param orderDetails_PK the orderDetails_PK to set
     */
    public void setOrderDetails_PK(OrderDetails_PK orderDetails_PK) {
        this.orderDetails_PK = orderDetails_PK;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "price=" + price + ", orders=" + orders + ", service=" + service + ", orderDetails_PK=" + orderDetails_PK + '}';
    }

    
}
