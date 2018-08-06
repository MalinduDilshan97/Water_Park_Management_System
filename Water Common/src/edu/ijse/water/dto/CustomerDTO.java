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
public class CustomerDTO extends SuperDTO{
    private int cid;
    private String wbid;
    private String date;
    private String time;

    public CustomerDTO() {
    }

    public CustomerDTO(int cid, String wbid, String date, String time) {
        this.cid = cid;
        this.wbid = wbid;
        this.date = date;
        this.time = time;
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

    @Override
    public String toString() {
        return "CustomerDTO{" + "cid=" + cid + ", wbid=" + wbid + ", date=" + date + ", time=" + time + '}';
    }

   
    
}
