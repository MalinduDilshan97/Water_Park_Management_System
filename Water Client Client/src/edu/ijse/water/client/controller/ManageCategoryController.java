/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.CategoryService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageCategoryController {
    public static boolean addCategory(CategoryDTO categoryDTO) throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.addCategory(categoryDTO);
    }
    
    public static CategoryDTO searchCategory(String catID) throws Exception{
         CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
         return categoryService.searchCategory(catID);
     }
    
    public static boolean deleteCategory(String catID) throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.deleteCategory(catID);
    }
    
    public static boolean updateCategory(CategoryDTO categoryDTO) throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.updateCategory(categoryDTO);
    }
    
    public static List<CategoryDTO> getAllCategories() throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.getAllCategories();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
    }
    
    public static boolean reserveCategory(String catId) throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.reserve(catId);
    }
    
    public static boolean releaseCategory(String catId) throws Exception{
        CategoryService categoryService =(CategoryService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CATEGORY);
        return categoryService.release(catId);
    }   
    
}
