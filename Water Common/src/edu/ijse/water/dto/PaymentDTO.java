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
public class PaymentDTO extends SuperDTO{
    private int pid;
    private double amount;
    private String paymentType;
    private String paymentDetails;
    private String date;
    private int oid;

    public PaymentDTO() {
    }

    public PaymentDTO(int pid, double amount, String paymentType, String paymentDetails, String date, int oid) {
        this.pid = pid;
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentDetails = paymentDetails;
        this.date = date;
        this.oid = oid;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
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

    @Override
    public String toString() {
        return "PaymentDTO{" + "pid=" + pid + ", amount=" + amount + ", paymentType=" + paymentType + ", paymentDetails=" + paymentDetails + ", date=" + date + ", oid=" + oid + '}';
    }
    
    
    
}
