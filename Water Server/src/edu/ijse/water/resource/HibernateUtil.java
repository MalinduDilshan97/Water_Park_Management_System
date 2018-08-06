/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.resource;

import edu.ijse.water.entity.Category;
import edu.ijse.water.entity.Customer;
import edu.ijse.water.entity.Food;
import edu.ijse.water.entity.Gift;
import edu.ijse.water.entity.Messages;
import edu.ijse.water.entity.OrderDetails;
import edu.ijse.water.entity.Orders;
import edu.ijse.water.entity.Payment;
import edu.ijse.water.entity.Pending;
import edu.ijse.water.entity.Service;
import edu.ijse.water.entity.User;
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author SL_WOLF
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
             // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            
            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Service.class)
                    .addAnnotatedClass(Food.class)
                    .addAnnotatedClass(Gift.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Pending.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(OrderDetails.class)
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(Messages.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
