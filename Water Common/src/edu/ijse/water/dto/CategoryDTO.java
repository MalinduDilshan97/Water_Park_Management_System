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
public class CategoryDTO extends SuperDTO{
    
    private String catId;
    private String catName;

    public CategoryDTO() {
    }

    public CategoryDTO(String catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    /**
     * @return the catId
     */
    public String getCatId() {
        return catId;
    }

    /**
     * @param catId the catId to set
     */
    public void setCatId(String catId) {
        this.catId = catId;
    }

    /**
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName the catName to set
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" + "catId=" + catId + ", catName=" + catName + '}';
    }
    
    
    
}
