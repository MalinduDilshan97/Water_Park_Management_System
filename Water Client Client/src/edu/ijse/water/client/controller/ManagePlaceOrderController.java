/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.PlaceOrderDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.PlaceOrderService;


/**
 *
 * @author SL_WOLF
 */
public class ManagePlaceOrderController {
     public static boolean placeOrder(PlaceOrderDTO placeOrderDTO)throws Exception{
         PlaceOrderService placeOrderService = (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);
         return placeOrderService.placeOrder(placeOrderDTO);
     }
     
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);
    }
    
    public static boolean reserveFood(String cid) throws Exception{
        PlaceOrderService placeOrderService = (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);
        return placeOrderService.reserve(cid);
    }
    
    public static boolean releaseFood(String cid) throws Exception{
        PlaceOrderService placeOrderService = (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACE_ORDER);
        return placeOrderService.release(cid);
    }   
}
