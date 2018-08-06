/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.SuperBO;
import edu.ijse.water.business.custom.ServiceBO;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.entity.Category;
import edu.ijse.water.entity.Service;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.CategoryRepository;
import edu.ijse.water.repository.custom.ServiceRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class ServiceBOImpl implements ServiceBO{
    
    private ServiceRepository serviceRepository;

    public ServiceBOImpl() {
        this.serviceRepository=(ServiceRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.SERVICE);
    }
    
    

    @Override
    public boolean addService(ServiceDTO serviceDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            serviceRepository.setSession(session);
            
            session.beginTransaction();
            
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
           
            boolean result = serviceRepository.save(service);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public ServiceDTO searchService(String serviceId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            serviceRepository.setSession(session);
            
            session.beginTransaction();
            
            Service service = new Service();
            
            service = serviceRepository.findById(serviceId);
            
            ServiceDTO serviceDTO = new ServiceDTO();
            serviceDTO.setServiceId(service.getServiceId());
            serviceDTO.setServiceName(service.getServiceName());
            serviceDTO.setPrice(service.getPrice());
            serviceDTO.setPassword(service.getPassword());
            
            Category category = service.getCategory();
            
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCatId(category.getCatId());
            categoryDTO.setCatName(category.getCatName());
            
            serviceDTO.setCategoryDTO(categoryDTO);
            
            session.getTransaction().commit();

            return serviceDTO;
        }
    }

    @Override
    public boolean deleteService(String serviceId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            serviceRepository.setSession(session);
            
            session.beginTransaction();

            Service service = serviceRepository.findById(serviceId);
            boolean result = true;

            if (service != null) {
                
                Category category = new Category("cat","cat");
                service.setCategory(category);
                
                serviceRepository.update(service);
                serviceRepository.delete(service);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateService(ServiceDTO serviceDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            serviceRepository.setSession(session);
            
            session.beginTransaction();
            
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
            
            
            serviceRepository.update(service);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ServiceDTO> getAllServices() throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            serviceRepository.setSession(session);
            
            session.beginTransaction();

            List<Service> services = serviceRepository.findAll();
            
            session.getTransaction().commit();

            if (services != null) {

                List<ServiceDTO> alServices = new ArrayList<>();

                for (Service service : services) {
                    ServiceDTO dto = new ServiceDTO();
                    dto.setServiceId(service.getServiceId());
                    dto.setServiceName(service.getServiceName());
                    dto.setPrice(service.getPrice());
                    dto.setPassword(service.getPassword());
                    
                    Category category = service.getCategory();
                    CategoryDTO categoryDTO= new CategoryDTO();
                    
                    categoryDTO.setCatId(category.getCatId());
                    categoryDTO.setCatName(category.getCatName());
                    
                    dto.setCategoryDTO(categoryDTO);
                    
                    alServices.add(dto);
                }

                return alServices;

            } else {

                return null;
            }

        }
    }
    
}
