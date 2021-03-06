/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author SL_WOLF
 */
@Entity
public class User {
    @Id
    private String uid;
    private String UserName;
    private  String password;

    public User() {
    }

    public User(String uid, String UserName, String password) {
        this.uid = uid;
        this.UserName = UserName;
        this.password = password;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
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

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", UserName=" + UserName + ", password=" + password + '}';
    }
    
    
}
