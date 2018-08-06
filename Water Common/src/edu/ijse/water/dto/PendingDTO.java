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
public class PendingDTO extends SuperDTO{
    private int pid;
    private String wbid;
    private String serviceID;
    private String itemID;
    private String time;
    private int qty;

    public PendingDTO() {
    }

    public PendingDTO(int pid, String wbid, String serviceID, String itemID, String time, int qty) {
        this.pid = pid;
        this.wbid = wbid;
        this.serviceID = serviceID;
        this.itemID = itemID;
        this.time = time;
        this.qty = qty;
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
     * @return the wbid
     */
    public String getWbid() {
        return wbid;
    }

    /**
     * @param wbid the wbid to set
     */
    public void setWbid(String wbid) {
        this.wbid = wbid;
    }

    /**
     * @return the serviceID
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * @param serviceID the serviceID to set
     */
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    /**
     * @return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "PendingDTO{" + "pid=" + pid + ", wbid=" + wbid + ", serviceID=" + serviceID + ", itemID=" + itemID + ", time=" + time + ", qty=" + qty + '}';
    }

   
}
