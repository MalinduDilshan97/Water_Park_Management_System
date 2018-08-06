/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.MessagesDTO;
import edu.ijse.water.service.SuperService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface MessageService extends SuperService{
    
     public boolean addMessage(MessagesDTO messagesDTO) throws Exception;
    
    public List<MessagesDTO> getMessages(String date)throws Exception;
    
}
