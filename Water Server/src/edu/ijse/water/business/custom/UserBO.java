/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.dto.UserDTO;
import java.util.List;

/**
 *
 * @author SL_WOLF
 */
public interface UserBO extends SuperBO{
    
    public boolean addUser(UserDTO userDTO) throws Exception;
    
    public UserDTO searchUser(String uid) throws Exception;
    
    public boolean deleteUser(String uid) throws Exception;
    
    public boolean updateUser(UserDTO userDTO) throws Exception;
    
    public List<UserDTO> getAllUsers() throws Exception;
    
}
