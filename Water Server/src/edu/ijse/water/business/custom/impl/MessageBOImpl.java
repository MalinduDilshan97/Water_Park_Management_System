/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.MessageBO;
import edu.ijse.water.dto.MessagesDTO;
import edu.ijse.water.entity.Messages;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.MessageRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class MessageBOImpl implements MessageBO{
    
    MessageRepository messageRepository;

    public MessageBOImpl() {
        this.messageRepository=(MessageRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.MESSAGE);
    }
    
    
     @Override
    public boolean addMessage(MessagesDTO messagesDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            messageRepository.setSession(session);
            
            session.beginTransaction();
            
             Messages messages = new Messages(messagesDTO.getMid(),
                    messagesDTO.getMessage(),
                    messagesDTO.getDate());
            boolean result = messageRepository.save(messages);
            
            session.getTransaction().commit();

            return result;
        }
    }
    
    

    @Override
    public List<MessagesDTO> getMessages(String date) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            messageRepository.setSession(session);
            
            session.beginTransaction();

            List<Messages> messages = messageRepository.getMessages(date, session);
            
            session.getTransaction().commit();

            if (messages != null) {

                List<MessagesDTO> alMessages = new ArrayList<>();

                for (Messages message : messages) {
                    MessagesDTO dto = new MessagesDTO(message.getMid(),
                            message.getMessage(),
                            message.getDate());
                    alMessages.add(dto);
                }

                return alMessages;

            } else {

                return null;
            }

        }
    }

   
}
