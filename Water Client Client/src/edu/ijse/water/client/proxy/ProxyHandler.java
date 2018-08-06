/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.proxy;

import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.SuperService;
import edu.ijse.water.service.custom.CategoryService;
import edu.ijse.water.service.custom.CustomerService;
import edu.ijse.water.service.custom.FoodService;
import edu.ijse.water.service.custom.GiftService;
import edu.ijse.water.service.custom.MessageService;
import edu.ijse.water.service.custom.PendingService;
import edu.ijse.water.service.custom.PlaceOrderService;
import edu.ijse.water.service.custom.ServiceService;
import edu.ijse.water.service.custom.UserService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SL_WOLF
 */
public class ProxyHandler implements ServiceFactory{
    private static ProxyHandler proxyHandler;
    private ServiceFactory serviceFactory;
    private CategoryService categoryService;
    private ServiceService serviceService;
    private FoodService foodService;
    private GiftService giftService;
    private UserService userService;
    private CustomerService customerService;
    private PendingService pendingService;
    private PlaceOrderService placeOrderService;
    private MessageService messageService;
    
    private ProxyHandler(){
        try {
            serviceFactory=(ServiceFactory) Naming.lookup("rmi://localhost:5050/water");
            categoryService=(CategoryService) serviceFactory.getService(ServiceTypes.CATEGORY);
            serviceService=(ServiceService) serviceFactory.getService(ServiceTypes.SERVICE);
            foodService=(FoodService) serviceFactory.getService(ServiceTypes.FOOD);
            giftService=(GiftService) serviceFactory.getService(ServiceTypes.GIFT);
            userService=(UserService) serviceFactory.getService(ServiceTypes.USER);
            customerService=(CustomerService) serviceFactory.getService(ServiceTypes.CUSTOMER);
            pendingService=(PendingService) serviceFactory.getService(ServiceTypes.PENDING);
            placeOrderService=(PlaceOrderService) serviceFactory.getService(ServiceTypes.PLACE_ORDER);
            messageService=(MessageService) serviceFactory.getService(ServiceTypes.MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ProxyHandler getInstance(){
        if (proxyHandler == null){
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch(type){
            case CATEGORY:
                return categoryService;
            case SERVICE:
                return serviceService;
            case FOOD:
                return foodService;
            case GIFT:
                return giftService;
            case USER:
                return userService;
            case CUSTOMER:
                return customerService;
            case PENDING:
                return pendingService;
            case PLACE_ORDER:
                return placeOrderService;
            case MESSAGE:
                return messageService;
            default:
                return null;
        }
    }
    
}
