/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.IDBO;
import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.IDRepository;
import edu.ijse.water.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class IDBOImpl implements IDBO{
    
    private IDRepository iDRepository;

    public IDBOImpl() {
        iDRepository=(IDRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ID);
    }
    
    

    @Override
    public String getResult(IDDTO idDTO) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            iDRepository.setSession(session);
            session.beginTransaction();
            session.getTransaction().commit();
            Object lastId=iDRepository.getResult(idDTO);
            return lastId.toString();
        }catch(Exception ex){
            //ex.printStackTrace();
            return null;
        }
    }
    
}
