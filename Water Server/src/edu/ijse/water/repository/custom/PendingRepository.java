/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom;

import edu.ijse.water.entity.Pending;
import edu.ijse.water.repository.SuperRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public interface PendingRepository extends SuperRepository<Pending, Integer>{

   
    public List<Pending> getAllByWbid(String wbid,Session session) throws Exception;
    
    public void removeWbid(String wbid,Session session) throws Exception;
    
    
    
}
