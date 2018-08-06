/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.CustomerDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface CustomerBO extends SuperBO{
    
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception;
    
    public List<CustomerDTO> getCustomer(String wbid,String date)throws Exception;
    
    public List<CustomerDTO> getCustomerByDate(String date)throws Exception;
    
    public CustomerDTO getCustomerBy(String wbid,String date)throws Exception;
    
}
