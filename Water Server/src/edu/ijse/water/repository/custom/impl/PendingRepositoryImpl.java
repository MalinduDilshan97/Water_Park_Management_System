/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.Pending;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.PendingRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class PendingRepositoryImpl extends SuperRepositoryImpl<Pending, Integer> implements PendingRepository {
    
    public PendingRepositoryImpl() {
    }
    
    @Override
    public List<Pending> getAllByWbid(String wbid, Session session) throws Exception {
        return session.createQuery("FROM Pending WHERE wbid='" + wbid + "'").list();
    }
    
    @Override
    public void removeWbid(String wbid, Session session) throws Exception {

    }
    
}
