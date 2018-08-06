/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.controller;

import edu.ijse.water.client.proxy.ProxyHandler;
import edu.ijse.water.dto.UserDTO;
import edu.ijse.water.observer.Subject;
import edu.ijse.water.service.ServiceFactory;
import edu.ijse.water.service.custom.UserService;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public class ManageUserController {
    
    public static boolean addUser(UserDTO userDTO) throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.addUser(userDTO);
    }
    
    public static UserDTO searchUser(String uid) throws Exception{
         UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
         return userService.searchUser(uid);
     }
    
    public static boolean deleteUser(String uid) throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.deleteUser(uid);
    }
    
    public static boolean updateUser(UserDTO userDTO) throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.updateUser(userDTO);
    }
    
    public static List<UserDTO> getAllUsers() throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.getAllUsers();
    }
    
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
    }
    
    public static boolean reserveUser(String uid) throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.reserve(uid);
    }
    
    public static boolean releaseUser(String uid) throws Exception{
        UserService userService =(UserService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.USER);
        return userService.release(uid);
    }   
    
}
