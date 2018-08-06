/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.Messages;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.MessageRepository;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class MessageRepositoryImpl extends SuperRepositoryImpl<Messages, Integer> implements MessageRepository{

    public MessageRepositoryImpl() {
    }
    
    

    @Override
    public List<Messages> getMessages(String date, Session session) throws Exception {
        return session.createQuery("FROM Messages WHERE date='"+date+"'").list();
    }
    
    
    
}
