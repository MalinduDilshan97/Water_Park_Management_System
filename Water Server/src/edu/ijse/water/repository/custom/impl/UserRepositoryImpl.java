/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.entity.User;
import edu.ijse.water.repository.SuperRepositoryImpl;
import edu.ijse.water.repository.custom.UserRepository;
import java.io.Serializable;

/**
 *
 * @author SL_WOLF
 */
public class UserRepositoryImpl extends SuperRepositoryImpl<User, String> implements UserRepository{

    public UserRepositoryImpl() {
    }
    
    
}
