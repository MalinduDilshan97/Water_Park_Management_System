/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.views;

import edu.ijse.water.controller.ManageCategoryController;
import edu.ijse.water.controller.ManageServiceController;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.observer.Observer;
import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author SL_WOLF
 */
public class Service_Add extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form Service_Add
     */
    Border defaultBorder;
    int priceBorder;
    int idBorder;
    int nameBorder;
    int passBorder;
    public Service_Add() {
        initComponents();
        defaultBorder = txtPassword.getBorder();
        priceBorder = 0;
        idBorder = 0;
        passBorder = 0;
        nameBorder=0;
        lblAdd.setVisible(false);
        loadAllCategories();
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageServiceController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(Service_Add.class.getName()).log(Level.SEVERE, null, ex);
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

        lblBoxHeader = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new org.jdesktop.swingx.JXTextField();
        lblCategory = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new org.jdesktop.swingx.JXTextField();
        lblAdd = new javax.swing.JLabel();
        lblClear = new javax.swing.JLabel();
        lblCancel = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        cmbCatId = new javax.swing.JComboBox<>();
        lblBox = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(832, 520));
        setMinimumSize(new java.awt.Dimension(832, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBoxHeader.setBackground(new java.awt.Color(0, 102, 153));
        lblBoxHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBoxHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblBoxHeader.setText("     Add Service Details");
        lblBoxHeader.setOpaque(true);
        add(lblBoxHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 30));

        lblId.setText("Service ID                                     :");
        add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtId.setPrompt("s001");
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 210, -1));

        lblCategory.setText("Category                                      :");
        add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txtCategory.setEditable(false);
        add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 210, -1));

        lblName.setText("Service Name                               :");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 210, -1));

        lblPrice.setText("Price                                             :");
        add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        txtPrice.setPrompt("xx.xx");
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
        });
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 210, -1));

        lblAdd.setBackground(new java.awt.Color(153, 0, 0));
        lblAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAdd.setForeground(new java.awt.Color(255, 255, 255));
        lblAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdd.setText("Add");
        lblAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdd.setOpaque(true);
        lblAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddMouseExited(evt);
            }
        });
        add(lblAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 60, 20));

        lblClear.setBackground(new java.awt.Color(153, 0, 0));
        lblClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClear.setForeground(new java.awt.Color(255, 255, 255));
        lblClear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClear.setText("Clear");
        lblClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClear.setOpaque(true);
        lblClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblClearMouseExited(evt);
            }
        });
        add(lblClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 60, 20));

        lblCancel.setBackground(new java.awt.Color(153, 0, 0));
        lblCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCancel.setForeground(new java.awt.Color(255, 255, 255));
        lblCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCancel.setText("Cancel");
        lblCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCancel.setOpaque(true);
        lblCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelMouseExited(evt);
            }
        });
        add(lblCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 60, 20));

        lblPassword.setText(" Password                                    :");
        add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 170, -1));

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 210, -1));

        cmbCatId.setMaximumRowCount(100);
        cmbCatId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCatIdItemStateChanged(evt);
            }
        });
        add(cmbCatId, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 140, -1));

        lblBox.setBackground(new java.awt.Color(51, 0, 0));
        lblBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 380));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setText(" ");
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseClicked
        
        String catID= cmbCatId.getSelectedItem().toString();
        
        ServiceDTO serviceDTO = new ServiceDTO();
           serviceDTO.setServiceId(txtId.getText());
           serviceDTO.setServiceName(txtName.getText());
           serviceDTO.setPrice(Double.parseDouble(txtPrice.getText()));
           serviceDTO.setPassword(txtPassword.getText());
           
           CategoryDTO categoryDTO = new CategoryDTO();
           categoryDTO.setCatId(catID);
           categoryDTO.setCatName(txtCategory.getText());
           
           serviceDTO.setCategoryDTO(categoryDTO);
           
           boolean result;
           
        try {
            result=ManageServiceController.addService(serviceDTO);
            if(result){
                JOptionPane.showMessageDialog(this, "Service has been saved successfully");
                Clear();
            }else{
                JOptionPane.showMessageDialog(this, "Failed to save the Service");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to save the Service", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Service_Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblAddMouseClicked

    private void lblAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseEntered
        lblAdd.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblAddMouseEntered

    private void lblAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddMouseExited
        lblAdd.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblAddMouseExited

    private void lblClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseEntered
        lblClear.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblClearMouseEntered

    private void lblClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseExited
        lblClear.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblClearMouseExited

    private void lblCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseEntered
        lblCancel.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblCancelMouseEntered

    private void lblCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseExited
        lblCancel.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblCancelMouseExited

    private void cmbCatIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCatIdItemStateChanged
       CategoryDTO categoryDTO = new CategoryDTO();
        
         try {
             categoryDTO=ManageCategoryController.searchCategory((String) cmbCatId.getSelectedItem());
             
             if(categoryDTO!= null){
                 txtCategory.setText(categoryDTO.getCatName());
             }else{
                 JOptionPane.showMessageDialog(this,"Check The Category ID Again");
             }
             
         } catch (Exception ex) {
             Logger.getLogger(Category_Remove.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_cmbCatIdItemStateChanged

    private void lblClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseClicked
        Clear();
    }//GEN-LAST:event_lblClearMouseClicked

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
         if(txtName.getText().matches("[A-Za-z ]+")){
            txtName.setBorder(defaultBorder);
            nameBorder=1;
            check();
        }else{
            txtName.setBorder(BorderFactory.createLineBorder(Color.red));
            nameBorder=0;
            check();
        }
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(txtPassword.getText().matches("[A-Za-z0-9]+")){
            txtPassword.setBorder(defaultBorder);
            passBorder=1;
            check();
        }else{
            txtPassword.setBorder(BorderFactory.createLineBorder(Color.red));
            passBorder=0;
            check();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
         if(txtId.getText().matches("s[0-9]+")){
            txtId.setBorder(defaultBorder);
            idBorder=1;
            check();
        }else{
            txtId.setBorder(BorderFactory.createLineBorder(Color.red));
            idBorder=0;
            check();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        if(txtPrice.getText().matches("[0-9]+.[0-9]+")){
            txtPrice.setBorder(defaultBorder);
            priceBorder=1;
            check();
        }else{
            txtPrice.setBorder(BorderFactory.createLineBorder(Color.red));
            priceBorder=0;
            check();
        }
    }//GEN-LAST:event_txtPriceKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCatId;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBox;
    private javax.swing.JLabel lblBoxHeader;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JTextField txtCategory;
    private org.jdesktop.swingx.JXTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private org.jdesktop.swingx.JXTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        
    }

    private void loadAllCategories() {
        cmbCatId.removeAllItems();
        try {
            List<CategoryDTO> categoryDTOs = ManageCategoryController.getAllCategories();

            if (categoryDTOs == null) {
                return;
            }

            for (CategoryDTO categoryDTO : categoryDTOs) {
                
                boolean reult=Important(categoryDTO);
                if(reult){
                     cmbCatId.addItem(categoryDTO.getCatId());
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

    private void check() {
        if(idBorder>0){
            if(nameBorder>0){
                if(priceBorder>0){
                    if(passBorder>0){
                        lblAdd.setVisible(true);
                    }else{
                        lblAdd.setVisible(false);
                    }
                }else{
                    lblAdd.setVisible(false);
                }
            }else{
                lblAdd.setVisible(false);
            }
        }else{
            lblAdd.setVisible(false);
        }
    }

    private void Clear() {
        txtId.setText("");
        txtId.setBorder(defaultBorder);
        txtName.setText("");
        txtName.setBorder(defaultBorder);
        txtPassword.setText("");
        txtPassword.setBorder(defaultBorder);
        txtPrice.setText("");
        txtPrice.setBorder(defaultBorder);
        priceBorder = 0;
        idBorder = 0;
        passBorder = 0;
        nameBorder=0;
    }
}