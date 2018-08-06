/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.controller;


import edu.ijse.water.dto.CustomerDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.proxy.ProxyHandler;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.CustomerService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageCustomerController {
    
     public static boolean addCustomer(CustomerDTO customerDTO) throws Exception{
         CustomerService customerService =(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.addCustomer(customerDTO);
    }
     
     public static List<CustomerDTO> getCustomer(String wbid, String date) throws Exception {
         CustomerService customerService =(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
         return customerService.getCustomer(wbid, date);
     }
     
     public static List<CustomerDTO> getCustomerByDate(String date)throws Exception{
         CustomerService customerService =(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
         return customerService.getCustomerByDate(date);
     }
     
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    }
    
    public static boolean reserveCustomer(int cid) throws Exception{
        CustomerService customerService =(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.reserve(cid);
    }
    
    public static boolean releaseCustomer(int cid) throws Exception{
        CustomerService customerService =(CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        return customerService.release(cid);
    }   
    
}
