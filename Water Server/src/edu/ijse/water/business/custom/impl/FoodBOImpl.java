/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.FoodBO;
import edu.ijse.water.dto.FoodDTO;
import edu.ijse.water.entity.Food;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.FoodRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class FoodBOImpl implements FoodBO{
    
    private FoodRepository foodRepository;

    public FoodBOImpl() {
        this.foodRepository=(FoodRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.FOOD);
    }
    
    

    @Override
    public boolean addFood(FoodDTO foodDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            foodRepository.setSession(session);
            
            session.beginTransaction();
            
             Food food = new Food(foodDTO.getFid(),
                    foodDTO.getDescription(),
                    foodDTO.getPrice());
             
            boolean result = foodRepository.save(food);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public FoodDTO searchFood(String fid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            foodRepository.setSession(session);
            
            session.beginTransaction();
            
            Food food= new Food();
            
            food = foodRepository.findById(fid);
            
            FoodDTO foodDTO = new FoodDTO();
            foodDTO.setFid(food.getFid());
            foodDTO.setDescription(food.getDescription());
            foodDTO.setPrice(food.getPrice());
            
            session.getTransaction().commit();

            return foodDTO;
        }
    }

    @Override
    public boolean deleteFood(String fid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            foodRepository.setSession(session);
            
            session.beginTransaction();

            Food food = foodRepository.findById(fid);
            boolean result = true;

            if (food != null) {

                foodRepository.delete(food);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateFood(FoodDTO foodDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            foodRepository.setSession(session);
            
            session.beginTransaction();
            
            Food food = new Food(foodDTO.getFid(),
                    foodDTO.getDescription(),
                    foodDTO.getPrice());
            
            foodRepository.update(food);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FoodDTO> getAllFoods() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            foodRepository.setSession(session);
            
            session.beginTransaction();

            List<Food> foods = foodRepository.findAll();
            
            session.getTransaction().commit();

            if (foods != null) {

                List<FoodDTO> alFood = new ArrayList<>();

                for (Food food : foods) {
                    FoodDTO dto = new FoodDTO(food.getFid(),
                            food.getDescription(),
                            food.getPrice());
                    alFood.add(dto);
                }

                return alFood;

            } else {

                return null;
            }

        }
    
    }
    
}
