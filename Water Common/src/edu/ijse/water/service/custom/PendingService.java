/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.service.SuperService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface PendingService extends SuperService{
    
    public boolean addDetail(PendingDTO pendingDTO) throws Exception;
    
    public boolean addAll(ArrayList<PendingDTO> allDTOs)throws Exception;
    
    public List<PendingDTO> getAll(String wbid) throws Exception;
}
