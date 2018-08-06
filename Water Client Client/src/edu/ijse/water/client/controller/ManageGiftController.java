/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.GiftService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageGiftController {
    public static boolean addGift(GiftDTO giftDTO) throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.addGift(giftDTO);
    }
    
    public static GiftDTO searchGift(String gid) throws Exception{
         GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
         return giftService.searchGift(gid);
     }
    
    public static boolean deleteGift(String gid) throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.deleteGift(gid);
    }
    
    public static boolean updateGift(GiftDTO giftDTO) throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.updateGift(giftDTO);
    }
    
    public static List<GiftDTO> getAllGifts() throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.getAllGifts();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
    }
    
    public static boolean reserveGift(String gid) throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.reserve(gid);
    }
    
    public static boolean releaseGift(String gid) throws Exception{
        GiftService giftService =(GiftService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.GIFT);
        return giftService.release(gid);
    }   
}
