/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.startup;

import edu.ijse.water.service.impl.ServiceFactoryImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SL_WOLF
 */
public class StartServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {            
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("water", ServiceFactoryImpl.getInstance());
            System.out.println("Server has been started successfully");
        } catch (RemoteException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
