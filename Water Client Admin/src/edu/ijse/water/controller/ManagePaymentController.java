/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.controller;

import edu.ijse.water.dto.PaymentDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.proxy.ProxyHandler;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.PaymentService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManagePaymentController {
    
    public static List<PaymentDTO> getPayment(String date)throws Exception{
        PaymentService paymentService= (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.getPayment(date);
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
    }
    
    public static boolean reservePayment(int pid) throws Exception{
        PaymentService paymentService= (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.reserve(pid);
    }
    
    public static boolean releasePayment(int pid) throws Exception{
        PaymentService paymentService= (PaymentService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PAYMENT);
        return paymentService.release(pid);
    }   
    
}
