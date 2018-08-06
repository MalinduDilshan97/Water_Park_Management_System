/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.FoodDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface FoodBO extends SuperBO{
    
    public boolean addFood(FoodDTO foodDTO) throws Exception;
    
    public FoodDTO searchFood(String fid) throws Exception;
    
    public boolean deleteFood(String fid) throws Exception;
    
    public boolean updateFood(FoodDTO foodDTO) throws Exception;
    
    public List<FoodDTO> getAllFoods() throws Exception;
    
}
