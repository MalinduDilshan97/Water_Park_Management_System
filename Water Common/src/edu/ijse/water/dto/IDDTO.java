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
public class IDDTO extends SuperDTO{
    
    private String entityName;
    private String colName;

    public IDDTO() {
    }

    public IDDTO(String entityName, String colName) {
        this.entityName = entityName;
        this.colName = colName;
    }

    /**
     * @return the entityName
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * @param entityName the entityName to set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * @return the colName
     */
    public String getColName() {
        return colName;
    }

    /**
     * @param colName the colName to set
     */
    public void setColName(String colName) {
        this.colName = colName;
    }

    @Override
    public String toString() {
        return "IdDTO{" + "entityName=" + entityName + ", colName=" + colName + '}';
    }
    
    
    
}
