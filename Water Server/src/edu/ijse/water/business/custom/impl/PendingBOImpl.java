/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.PendingBO;
import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.entity.Pending;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.PendingRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class PendingBOImpl implements PendingBO{
    
    private PendingRepository pendingRepository;

    public PendingBOImpl() {
        this.pendingRepository=(PendingRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PENDING);
    }
    
    

    @Override
    public boolean addDetail(PendingDTO pendingDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            pendingRepository.setSession(session);
            
            session.beginTransaction();
            
             Pending pending = new Pending();
             pending.setPid(pendingDTO.getPid());
             pending.setWbid(pendingDTO.getWbid());
             pending.setServiceID(pendingDTO.getServiceID());
             pending.setItemID(pendingDTO.getItemID());
             pending.setTime(pendingDTO.getTime());
             pending.setQty(pendingDTO.getQty());
             
            boolean result = pendingRepository.save(pending);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean addAll(ArrayList<PendingDTO> allDTOs) throws Exception{
        boolean result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            pendingRepository.setSession(session);
            
            session.beginTransaction();
            
            for(PendingDTO pendingDTO :allDTOs){
            
                Pending pending = new Pending();
                pending.setPid(pendingDTO.getPid());
                pending.setWbid(pendingDTO.getWbid());
                pending.setServiceID(pendingDTO.getServiceID());
                pending.setItemID(pendingDTO.getItemID());
                pending.setTime(pendingDTO.getTime());
                pending.setQty(pendingDTO.getQty());
             
                result = pendingRepository.save(pending);
            
            }
            
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public List<PendingDTO> getAll(String wbid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            pendingRepository.setSession(session);
            
            session.beginTransaction();

            List<Pending> pendings = pendingRepository.getAllByWbid(wbid,session);
            
            session.getTransaction().commit();

            if (pendings != null) {

                List<PendingDTO> alPending = new ArrayList<>();

                for (Pending pending : pendings) {
                    PendingDTO dto = new PendingDTO(pending.getPid(),
                            pending.getWbid(),
                            pending.getServiceID(),
                            pending.getItemID(),
                            pending.getTime(),
                            pending.getQty());
                    alPending.add(dto);
                }

                return alPending;

            } else {

                return null;
            }

        }
    }
    
}
