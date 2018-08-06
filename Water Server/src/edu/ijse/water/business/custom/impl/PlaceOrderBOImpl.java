/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.PlaceOrderBO;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.dto.OrderDetailsDTO;
import edu.ijse.water.dto.PlaceOrderDTO;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.entity.Category;
import edu.ijse.water.entity.OrderDetails;
import edu.ijse.water.entity.OrderDetails_PK;
import edu.ijse.water.entity.Orders;
import edu.ijse.water.entity.Payment;
import edu.ijse.water.entity.Service;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.OrderDetailsRepository;
import edu.ijse.water.repository.custom.OrdersRepository;
import edu.ijse.water.repository.custom.PaymentRepository;
import edu.ijse.water.repository.custom.impl.OrderDetailsRepositoryImpl;
import edu.ijse.water.repository.custom.impl.OrdersRepositoryImpl;
import edu.ijse.water.resource.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class PlaceOrderBOImpl implements PlaceOrderBO{
    
    private OrdersRepository ordersRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private PaymentRepository paymentRepository;

    public PlaceOrderBOImpl() {
        this.ordersRepository=new OrdersRepositoryImpl();
        this.orderDetailsRepository= new OrderDetailsRepositoryImpl();
        this.paymentRepository=(PaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PAYMENT);
        
    }
    
    

    @Override
    public boolean placeOrder(PlaceOrderDTO placeOrderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            Orders orders = new Orders();
            orders.setCid(placeOrderDTO.getCid());
            orders.setOrderDate(placeOrderDTO.getOrderDate());
            
            List<OrderDetailsDTO>orderDetailsDTOs=placeOrderDTO.getOrderDetailsDTOs();
            
           
            ordersRepository.setSession(session);
            session.beginTransaction();
           
            boolean result=ordersRepository.addOrders(orders);
            
            if(result){
                
                Payment payment = new Payment();
                payment.setPid(0);
                payment.setDate(placeOrderDTO.getOrderDate());
                payment.setPaymentDetails(placeOrderDTO.getPaymentDetails());
                payment.setPaymentType(placeOrderDTO.getPaymentType());
                payment.setAmount(placeOrderDTO.getAmount());
                payment.setOid(orders.getOid());
                
               paymentRepository.setSession(session);
               boolean res= paymentRepository.save(payment);
               
               if(res){
                   
                    for(OrderDetailsDTO orderDetailsDTO :orderDetailsDTOs){
                        OrderDetails orderDetails=new OrderDetails();
                    
                        ServiceDTO serviceDTO = orderDetailsDTO.getServiceDTO();
                        Service service = new Service();
                    
                        service.setServiceId(serviceDTO.getServiceId());
                        service.setServiceName(serviceDTO.getServiceName());
                        service.setPrice(serviceDTO.getPrice());
                        service.setPassword(serviceDTO.getPassword());
            
                        CategoryDTO categoryDTO= serviceDTO.getCategoryDTO();
                        Category category = new Category();
                        category.setCatId(categoryDTO.getCatId());
                        category.setCatName(categoryDTO.getCatName());
                    
                        service.setCategory(category);
                        
                        orderDetails.setPrice(orderDetailsDTO.getPrice());
                        orderDetails.setOrders(orders);
                        orderDetails.setService(service);
                    
                        //OrderDetails details=new OrderDetails(orders.getOid(), service.getServiceId(),orderDetailsDTO.getPrice(), orders, service);
                        orderDetails.setOrderDetails_PK(new OrderDetails_PK(orders.getOid(), service.getServiceId()));
                        
                        
                        orderDetailsRepository.addOrderDetails(orderDetails,session);
                        
                       
                    }
                   
               }
               
                session.getTransaction().commit();
                return true;
                    
            }else{
                session.getTransaction().rollback();
                return false;
                
            }
            
        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }
    
    }
    
}
