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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private String orderDate;
    private int cid;

    public Orders() {
    }

    public Orders(String orderDate, int cid) {
        this.orderDate = orderDate;
        this.cid = cid;
    }

    public Orders(int oid, String orderDate, int cid) {
        this.oid = oid;
        this.orderDate = orderDate;
        this.cid = cid;
    }

    /**
     * @return the oid
     */
    public int getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(int oid) {
        this.oid = oid;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Orders{" + "oid=" + oid + ", orderDate=" + orderDate + ", cid=" + cid + '}';
    }
    
    
    
    
}
