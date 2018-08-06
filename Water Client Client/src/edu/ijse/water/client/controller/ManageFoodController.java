/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.FoodDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.FoodService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageFoodController {
    public static boolean addFood(FoodDTO foodDTO) throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.addFood(foodDTO);
    }
    
    public static FoodDTO searchFood(String fid) throws Exception{
         FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
         return foodService.searchFood(fid);
     }
    
    public static boolean deleteFood(String fid) throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.deleteFood(fid);
    }
    
    public static boolean updateFood(FoodDTO foodDTO) throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.updateFood(foodDTO);
    }
    
    public static List<FoodDTO> getAllFoods() throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.getAllFoods();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
    }
    
    public static boolean reserveFood(String fid) throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.reserve(fid);
    }
    
    public static boolean releaseFood(String fid) throws Exception{
        FoodService foodService =(FoodService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.FOOD);
        return foodService.release(fid);
    }   
}
