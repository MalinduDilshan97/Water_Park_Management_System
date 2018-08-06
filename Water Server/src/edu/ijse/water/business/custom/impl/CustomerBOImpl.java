/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.CustomerBO;
import edu.ijse.water.dto.CustomerDTO;
import edu.ijse.water.entity.Customer;
import edu.ijse.water.entity.Pending;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.CustomerRepository;
import edu.ijse.water.repository.custom.PendingRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class CustomerBOImpl implements CustomerBO{
    
    private CustomerRepository customerRepository ;
    private PendingRepository pendingRepository;

    public CustomerBOImpl() {
        this.customerRepository=(CustomerRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CUSTOMER);
        this.pendingRepository=(PendingRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PENDING);
    }
    
    

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            pendingRepository.setSession(session);
            
            session.beginTransaction();
 
             Customer customer = new Customer(customerDTO.getCid(),
                     customerDTO.getWbid(),
                    customerDTO.getDate(),
                    customerDTO.getTime());
             
            boolean result = customerRepository.save(customer);
            
            
            
            if(result){
                List<Pending> pendings = pendingRepository.getAllByWbid(customerDTO.getWbid(),session);
                
                if (pendings != null){
                for (Pending pending : pendings) {
                    
                        pendingRepository.delete(pending);
                    
                }
            }
                
            }
            session.getTransaction().commit();
            return result;
        }
    }
    
    @Override
    public List<CustomerDTO> getCustomer(String wbid, String date) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
            List<Customer> customers=customerRepository.getCustomer(wbid,date,session);
            session.getTransaction().commit();
            
            if(customers!=null){
       
                List<CustomerDTO> alCustomers= new ArrayList<>();
                
                 for(Customer customer : customers){
                
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCid(customer.getCid());
                    customerDTO.setWbid(customer.getWbid());
                    customerDTO.setTime(customer.getTime());
                    customerDTO.setDate(customer.getDate()); 
                    
                    alCustomers.add(customerDTO);
                
                 }
                 return alCustomers;
            }else{
                return null;
            }
       
            
        }
    }

    @Override
    public List<CustomerDTO> getCustomerByDate(String date) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
            List<Customer> customers=customerRepository.getCustomerByDate(date,session);
            session.getTransaction().commit();
            
            if(customers!=null){
       
                List<CustomerDTO> alCustomers= new ArrayList<>();
                
                 for(Customer customer : customers){
                
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setCid(customer.getCid());
                    customerDTO.setWbid(customer.getWbid());
                    customerDTO.setTime(customer.getTime());
                    customerDTO.setDate(customer.getDate()); 
                    
                    alCustomers.add(customerDTO);
                
                 }
                 return alCustomers;
            }else{
                return null;
            }
       
            
        }
    }

    @Override
    public CustomerDTO getCustomerBy(String wbid, String date) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            customerRepository.setSession(session);
            
            session.beginTransaction();
            
            Customer customer= new Customer();
            
            customer = customerRepository.getCustomerBy(wbid, date, session);
            
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCid(customer.getCid());
            customerDTO.setWbid(customer.getWbid());
            customerDTO.setDate(customer.getDate());
            customerDTO.setTime(customer.getTime());
            
            session.getTransaction().commit();

            return customerDTO;
        }
    }

    
    
    
    
    
}
