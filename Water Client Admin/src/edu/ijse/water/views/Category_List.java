/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.views;

import edu.ijse.water.controller.ManageCategoryController;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.observer.Observer;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SL_WOLF
 */
public class Category_List extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form Category_List
     */
    public Category_List() {
        initComponents();
        loadAllCategories();
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageCategoryController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(Category_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblBoxHeader = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(830, 520));
        setMinimumSize(new java.awt.Dimension(830, 520));
        setPreferredSize(new java.awt.Dimension(830, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Category Name"
            }
        ));
        tblList.setRowHeight(20);
        jScrollPane1.setViewportView(tblList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 790, 420));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 10));

        lblBoxHeader.setBackground(new java.awt.Color(0, 102, 153));
        lblBoxHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBoxHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblBoxHeader.setText("  Category List");
        lblBoxHeader.setOpaque(true);
        add(lblBoxHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 30));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBoxHeader;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        loadAllCategories();
    }

    private void loadAllCategories() {
        DefaultTableModel dtm = (DefaultTableModel) tblList.getModel();
        dtm.setRowCount(0);

        try {
            List<CategoryDTO> categoryDTOs = ManageCategoryController.getAllCategories();

            if (categoryDTOs == null) {
                return;
            }

            for (CategoryDTO categoryDTO : categoryDTOs) {
                
                boolean reult=Important(categoryDTO);
                
                if(reult){
                    
                Object[] rowData = {
                categoryDTO.getCatId(),
                categoryDTO.getCatName()
                };
                dtm.addRow(rowData);
                    
                }
                
                
            }

        } catch (Exception ex) {
            Logger.getLogger(Category_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean Important(CategoryDTO categoryDTO) {
        if(categoryDTO.getCatId().matches("Category001") | categoryDTO.getCatId().matches("Category002")){
            return false;
        }else{
            return true;
        }

    }
}
