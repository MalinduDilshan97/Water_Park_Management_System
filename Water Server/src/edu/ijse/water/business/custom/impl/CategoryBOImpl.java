/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.business.custom.impl;

import edu.ijse.water.business.custom.CategoryBO;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.entity.Category;
import edu.ijse.water.repository.RepositoryFactory;
import edu.ijse.water.repository.custom.CategoryRepository;
import edu.ijse.water.resource.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class CategoryBOImpl implements CategoryBO{
    
    private CategoryRepository categoryRepository;

    public CategoryBOImpl() {
        this.categoryRepository=(CategoryRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.CATEGORY);
    }
    
    

    @Override
    public boolean addCategory(CategoryDTO categoryDTO) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            categoryRepository.setSession(session);
            
            session.beginTransaction();
            
             Category category = new Category(categoryDTO.getCatId(),
                    categoryDTO.getCatName());
            boolean result = categoryRepository.save(category);
            
            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public CategoryDTO searchCategory(String catId) throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            categoryRepository.setSession(session);
            
            session.beginTransaction();
            
            Category category= new Category();
            
            category = categoryRepository.findById(catId);
            
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setCatId(category.getCatId());
            categoryDTO.setCatName(category.getCatName());
            
            session.getTransaction().commit();

            return categoryDTO;
        }
    }

    @Override
    public boolean deleteCategory(String catId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            categoryRepository.setSession(session);
            
            session.beginTransaction();

            Category category = categoryRepository.findById(catId);
            boolean result = true;

            if (category != null) {

                categoryRepository.delete(category);
            }
            
            session.getTransaction().commit();

            return result;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCategory(CategoryDTO categoryDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            categoryRepository.setSession(session);
            
            session.beginTransaction();
            
            Category category = new Category(categoryDTO.getCatId(),
                    categoryDTO.getCatName());
            categoryRepository.update(category);
            
            session.getTransaction().commit();
            
            return true;
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws Exception {
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            categoryRepository.setSession(session);
            
            session.beginTransaction();

            List<Category> categorys = categoryRepository.findAll();
            
            session.getTransaction().commit();

            if (categorys != null) {

                List<CategoryDTO> alCategory = new ArrayList<>();

                for (Category category : categorys) {
                    CategoryDTO dto = new CategoryDTO(category.getCatId(),
                            category.getCatName());
                    alCategory.add(dto);
                }

                return alCategory;

            } else {

                return null;
            }

        }
    }
    
}
