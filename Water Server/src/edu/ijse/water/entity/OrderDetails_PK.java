/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author SL_WOLF
 */
@Embeddable
public class OrderDetails_PK implements Serializable{
    
    private int oid;
    private String serviceId;

    public OrderDetails_PK() {
    }

    public OrderDetails_PK(int oid, String serviceId) {
        this.oid = oid;
        this.serviceId = serviceId;
    }

    
    
    
    
}
