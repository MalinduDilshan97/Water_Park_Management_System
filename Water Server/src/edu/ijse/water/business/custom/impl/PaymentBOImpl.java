/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.PaymentBO;
import edu.ijse.water.dto.PaymentDTO;
import edu.ijse.water.entity.Payment;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.PaymentRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class PaymentBOImpl implements PaymentBO{
    
    private PaymentRepository paymentRepository;

    public PaymentBOImpl() {
        this.paymentRepository=(PaymentRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.PAYMENT);
    }
    
    

    @Override
    public List<PaymentDTO> getPayment(String date) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            paymentRepository.setSession(session);
            
            session.beginTransaction();
            
            List<Payment> payments=paymentRepository.getPayment(date,session);
            session.getTransaction().commit();
            
            if(payments!=null){
       
                List<PaymentDTO> alPayments= new ArrayList<>();
                
                 for(Payment payment : payments){
                
                    PaymentDTO paymentDTO = new PaymentDTO();
                    paymentDTO.setPid(payment.getPid());
                    paymentDTO.setDate(payment.getDate());
                    paymentDTO.setAmount(payment.getAmount());
                    paymentDTO.setPaymentDetails(payment.getPaymentDetails()); 
                    paymentDTO.setPaymentType(payment.getPaymentType()); 
                    paymentDTO.setOid(payment.getOid()); 
                    
                    alPayments.add(paymentDTO);
                
                 }
                 return alPayments;
            }else{
                return null;
            }
       
            
        }
    }
    
}
