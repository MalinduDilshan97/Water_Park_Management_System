/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.PendingService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManagePendingController {
    
    public static boolean addDetails(PendingDTO pendingDTO) throws Exception{
         PendingService pendingService =(PendingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
        return pendingService.addDetail(pendingDTO);
    }
    
    public static boolean addAll(ArrayList<PendingDTO> allDTOs)throws Exception{
        PendingService pendingService =(PendingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
        return pendingService.addAll(allDTOs);
    }
    
    public static List<PendingDTO> getAll(String wbid) throws Exception{
        PendingService pendingService =(PendingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
        return pendingService.getAll(wbid);
    }
     
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
    }
    
    public static boolean reserveCustomer(int pid) throws Exception{
        PendingService pendingService =(PendingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
        return pendingService.reserve(pid);
    }
    
    public static boolean releaseCustomer(int pid) throws Exception{
        PendingService pendingService =(PendingService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PENDING);
        return pendingService.release(pid);
    }   
    
}
