/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.CustomerDTO;
import edu.ijse.water.service.SuperService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface CustomerService extends SuperService{
    
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception;
    
    public List<CustomerDTO> getCustomer(String wbid,String date)throws Exception;
    
    public List<CustomerDTO> getCustomerByDate(String date)throws Exception;
    
    public CustomerDTO getCustomerBy(String wbid,String date)throws Exception;
}
