/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository;

import edu.ijse.water.repository.custom.impl.CategoryRepositoryImpl;
import edu.ijse.water.repository.custom.impl.CustomerRepositoryImpl;
import edu.ijse.water.repository.custom.impl.FoodRepositoryImpl;
import edu.ijse.water.repository.custom.impl.GiftRepositoryImpl;
import edu.ijse.water.repository.custom.impl.IDRepositoryImpl;
import edu.ijse.water.repository.custom.impl.MessageRepositoryImpl;
import edu.ijse.water.repository.custom.impl.OrderDetailsRepositoryImpl;
import edu.ijse.water.repository.custom.impl.OrdersRepositoryImpl;
import edu.ijse.water.repository.custom.impl.PaymentRepositoryImpl;
import edu.ijse.water.repository.custom.impl.PendingRepositoryImpl;
import edu.ijse.water.repository.custom.impl.ServiceRepositoryImpl;
import edu.ijse.water.repository.custom.impl.UserRepositoryImpl;



/**
 *
 * @author SL_WOLF
 */
public class RepositoryFactory {
    
    public enum RepositoryTypes{
        CATEGORY,SERVICE,FOOD,GIFT,USER,CUSTOMER,PENDING,PAYMENT,MESSAGE,ID
    }
    
    public static RepositoryFactory repositoryFactory;
    
    private RepositoryFactory(){
        
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null){
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes type){
        switch (type){
            case CATEGORY:
                return new CategoryRepositoryImpl();
            case SERVICE:
                return  new ServiceRepositoryImpl();
            case FOOD:
                return  new FoodRepositoryImpl();
            case GIFT:
                return new GiftRepositoryImpl();
            case USER:
                return new UserRepositoryImpl();
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case PENDING:
                return new PendingRepositoryImpl();
            case PAYMENT:
                return new PaymentRepositoryImpl();
            case MESSAGE:
                return new MessageRepositoryImpl();
            case ID:
                return new IDRepositoryImpl();
            default: 
                return null;
        }
    }
    
}
