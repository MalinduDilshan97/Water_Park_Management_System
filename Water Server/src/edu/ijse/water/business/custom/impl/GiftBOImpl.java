/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.GiftBO;
import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.entity.Gift;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.GiftRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class GiftBOImpl implements GiftBO{
    
    private GiftRepository giftRepository;

    public GiftBOImpl() {
        this.giftRepository=(GiftRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.GIFT);
    }
    
    

    @Override
    public boolean addGift(GiftDTO foodDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            giftRepository.setSession(session);
            
            session.beginTransaction();
            
             Gift gift = new Gift(foodDTO.getGid(),
                    foodDTO.getDescription(),
                    foodDTO.getPrice());
             
            boolean result = giftRepository.save(gift);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public GiftDTO searchGift(String gid) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            giftRepository.setSession(session);
            
            session.beginTransaction();
            
            Gift gift= new Gift();
            
            gift = giftRepository.findById(gid);
            
            GiftDTO giftDTO = new GiftDTO();
            giftDTO.setGid(gift.getGid());
            giftDTO.setDescription(gift.getDescription());
            giftDTO.setPrice(gift.getPrice());
            
            session.getTransaction().commit();

            return giftDTO;
        }
    }

    @Override
    public boolean deleteGift(String gid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            giftRepository.setSession(session);
            
            session.beginTransaction();

            Gift gift = giftRepository.findById(gid);
            boolean result = true;

            if (gift != null) {

                giftRepository.delete(gift);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateGift(GiftDTO foodDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            giftRepository.setSession(session);
            
            session.beginTransaction();
            
            Gift gift = new Gift(foodDTO.getGid(),
                    foodDTO.getDescription(),
                    foodDTO.getPrice());
            
            giftRepository.update(gift);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<GiftDTO> getAllGifts() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            giftRepository.setSession(session);
            
            session.beginTransaction();

            List<Gift> gifts = giftRepository.findAll();
            
            session.getTransaction().commit();

            if (gifts != null) {

                List<GiftDTO> alGift = new ArrayList<>();

                for (Gift gift : gifts) {
                    GiftDTO dto = new GiftDTO(gift.getGid(),
                            gift.getDescription(),
                            gift.getPrice());
                    alGift.add(dto);
                }

                return alGift;

            } else {

                return null;
            }

        }
    
    
    }
    
}
