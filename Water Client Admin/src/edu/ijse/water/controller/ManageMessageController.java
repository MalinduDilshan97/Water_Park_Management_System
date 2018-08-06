/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.controller;

import edu.ijse.water.dto.MessagesDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.proxy.ProxyHandler;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.MessageService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageMessageController {
    
    public static boolean addMessage(MessagesDTO messagesDTO) throws Exception{
        MessageService messageService=(MessageService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MESSAGE);
        return messageService.addMessage(messagesDTO);
    }
    
    public static List<MessagesDTO> getMessages(String date)throws Exception{
        MessageService messageService=(MessageService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MESSAGE);
        return messageService.getMessages(date);
    }
    
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MESSAGE);
    }
    
    public static boolean reserveMessage(int mid) throws Exception{
        MessageService messageService=(MessageService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MESSAGE);
        return messageService.reserve(mid);
    }
    
    public static boolean releaseMessage(int mid) throws Exception{
        MessageService messageService=(MessageService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.MESSAGE);
        return messageService.release(mid);
    }   
    
    
}
