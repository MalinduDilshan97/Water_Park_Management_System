/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.dto;

import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class PlaceOrderDTO extends SuperDTO{
    
    private String orderDate;
    private int cid;
    private double amount;
    private String paymentType;
    private String paymentDetails;
    private List<OrderDetailsDTO> orderDetailsDTOs;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String orderDate, int cid, double amount, String paymentType, String paymentDetails, List<OrderDetailsDTO> orderDetailsDTOs) {
        this.orderDate = orderDate;
        this.cid = cid;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.orderDetailsDTOs = orderDetailsDTOs;
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

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * @return the paymentDetails
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * @param paymentDetails the paymentDetails to set
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * @return the orderDetailsDTOs
     */
    public List<OrderDetailsDTO> getOrderDetailsDTOs() {
        return orderDetailsDTOs;
    }

    /**
     * @param orderDetailsDTOs the orderDetailsDTOs to set
     */
    public void setOrderDetailsDTOs(List<OrderDetailsDTO> orderDetailsDTOs) {
        this.orderDetailsDTOs = orderDetailsDTOs;
    }

    @Override
    public String toString() {
        return "PlaceOrderDTO{" + "orderDate=" + orderDate + ", cid=" + cid + ", amount=" + amount + ", paymentType=" + paymentType + ", paymentDetails=" + paymentDetails + ", orderDetailsDTOs=" + orderDetailsDTOs + '}';
    }

    
}
