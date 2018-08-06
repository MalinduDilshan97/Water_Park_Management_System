/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business;

import edu.ijse.water.business.custom.impl.CategoryBOImpl;
import edu.ijse.water.business.custom.impl.CustomerBOImpl;
import edu.ijse.water.business.custom.impl.FoodBOImpl;
import edu.ijse.water.business.custom.impl.GiftBOImpl;
import edu.ijse.water.business.custom.impl.IDBOImpl;
import edu.ijse.water.business.custom.impl.MessageBOImpl;
import edu.ijse.water.business.custom.impl.PaymentBOImpl;
import edu.ijse.water.business.custom.impl.PendingBOImpl;
import edu.ijse.water.business.custom.impl.PlaceOrderBOImpl;
import edu.ijse.water.business.custom.impl.ServiceBOImpl;
import edu.ijse.water.business.custom.impl.UserBOImpl;


/**
 *
 * @author SL_WOLF
 */
public class BOFactory {
    
    public enum BOTypes{
        CATEGORY,SERVICE,FOOD,GIFT,USER,CUSTOMER,PENDING,PLACE_ORDER,PAYMENT,MESSAGE,ID
    }
    
    private static BOFactory boFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    
    public SuperBO getBO(BOTypes type){
        switch(type){
            case CATEGORY:
                return new CategoryBOImpl();
            case SERVICE:
                return new ServiceBOImpl();
            case FOOD:
                return new FoodBOImpl();
            case GIFT:
                return new GiftBOImpl();
            case USER:
                return new UserBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case PENDING:
                return new PendingBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case MESSAGE:
                return new MessageBOImpl();
            case ID:
                return new IDBOImpl();
            default:
                return null;
        }
    }
}
