/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.UserBO;
import edu.ijse.water.dto.UserDTO;
import edu.ijse.water.entity.User;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.UserRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class UserBOImpl implements UserBO{
    
    private UserRepository userRepository;

    public UserBOImpl() {
        this.userRepository=(UserRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.USER);
    }
    
    

    @Override
    public boolean addUser(UserDTO userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);
            
            session.beginTransaction();
            
             User user = new User(userDTO.getUid(),
                    userDTO.getUserName(),
                    userDTO.getPassword());
             
            boolean result = userRepository.save(user);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public UserDTO searchUser(String uid) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);
            
            session.beginTransaction();
            
            User user= new User();
            
            user = userRepository.findById(uid);
            
            UserDTO userDTO = new UserDTO();
            userDTO.setUid(user.getUid());
            userDTO.setUserName(user.getUserName());
            userDTO.setPassword(user.getPassword());
            
            session.getTransaction().commit();

            return userDTO;
        }
    }

    @Override
    public boolean deleteUser(String uid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);
            
            session.beginTransaction();

            User user = userRepository.findById(uid);
            boolean result = true;

            if (user != null) {

                userRepository.delete(user);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);
            
            session.beginTransaction();
            
             User user = new User(userDTO.getUid(),
                    userDTO.getUserName(),
                    userDTO.getPassword());
            
            userRepository.update(user);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);
            
            session.beginTransaction();

            List<User> users = userRepository.findAll();
            
            session.getTransaction().commit();

            if (users != null) {

                List<UserDTO> alUser = new ArrayList<>();

                for (User user : users) {
                    UserDTO dto = new UserDTO(user.getUid(),
                            user.getUserName(),
                            user.getPassword());
                    alUser.add(dto);
                }

                return alUser;

            } else {

                return null;
            }

        }
    }
    
}
