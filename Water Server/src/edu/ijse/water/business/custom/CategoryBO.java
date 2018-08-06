/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.CategoryDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface CategoryBO extends SuperBO{
    
    public boolean addCategory(CategoryDTO categoryDTO) throws Exception;
    
    public CategoryDTO searchCategory(String catId) throws Exception;
    
    public boolean deleteCategory(String catId) throws Exception;
    
    public boolean updateCategory(CategoryDTO categoryDTO) throws Exception;
    
    public List<CategoryDTO> getAllCategories() throws Exception;
    
}
