/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.repository.custom.impl;

import edu.ijse.water.dto.IDDTO;
import edu.ijse.water.repository.custom.IDRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SL_WOLF
 */
public class IDRepositoryImpl implements IDRepository{
    
    private Session session;

    public IDRepositoryImpl() {
    }
    
    

    @Override
    public Object getResult(IDDTO idDTO) throws Exception {
        return session.createSQLQuery("select " + idDTO.getColName() + " from " + idDTO.getEntityName() + " order by 1 desc limit 1;").uniqueResult();
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
