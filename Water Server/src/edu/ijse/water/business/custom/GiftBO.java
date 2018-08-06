/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.GiftDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface GiftBO extends SuperBO{
    
    public boolean addGift(GiftDTO foodDTO) throws Exception;
    
    public GiftDTO searchGift(String gid) throws Exception;
    
    public boolean deleteGift(String gid) throws Exception;
    
    public boolean updateGift(GiftDTO foodDTO) throws Exception;
    
    public List<GiftDTO> getAllGifts() throws Exception;
    
}
