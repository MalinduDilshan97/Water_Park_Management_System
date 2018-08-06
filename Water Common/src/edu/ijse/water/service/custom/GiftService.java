/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.service.custom;

import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.service.SuperService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface GiftService extends SuperService{
    
     public boolean addGift(GiftDTO giftDTO) throws Exception;
    
    public GiftDTO searchGift(String gid) throws Exception;
    
    public boolean deleteGift(String gid) throws Exception;
    
    public boolean updateGift(GiftDTO giftDTO) throws Exception;
    
    public List<GiftDTO> getAllGifts() throws Exception;
    
    
}
