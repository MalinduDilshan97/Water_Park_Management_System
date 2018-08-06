/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.ServiceService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageServiceController {
    
    public static boolean addService(ServiceDTO serviceDTO) throws Exception{
        ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.addService(serviceDTO);
    }
    
    public static ServiceDTO searchService(String serviceId) throws Exception{
         ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
         return serviceService.searchService(serviceId);
     }
    
    public static boolean deleteService(String serviceId) throws Exception{
       ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.deleteService(serviceId);
    }
    
    public static boolean updateService(ServiceDTO serviceDTO) throws Exception{
        ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.updateService(serviceDTO);
    }
    
    public static List<ServiceDTO> getAllServices() throws Exception{
        ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.getAllServices();
    }
    
    public static Subject getSubject() throws Exception{
        return  (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
    }
    
    public static boolean reserveService(String serviceId) throws Exception{
        ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.reserve(serviceId);
    }
    
    public static boolean releaseService(String serviceId) throws Exception{
        ServiceService serviceService =(ServiceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SERVICE);
        return serviceService.release(serviceId);
    }   
    
}
