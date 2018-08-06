/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.service.SuperService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface ServiceService extends SuperService{
    
    public boolean addService(ServiceDTO serviceDTO) throws Exception;
    
    public ServiceDTO searchService(String serviceId) throws Exception;
    
    public boolean deleteService(String serviceId) throws Exception;
    
    public boolean updateService(ServiceDTO serviceDTO) throws Exception;
    
    public List<ServiceDTO> getAllServices() throws Exception;
    
}
