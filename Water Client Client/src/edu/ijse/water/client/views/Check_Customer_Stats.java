/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.views;

import edu.ijse.water.client.controller.ManageFoodController;
import edu.ijse.water.client.controller.ManageGiftController;
import edu.ijse.water.client.controller.ManagePendingController;
import edu.ijse.water.client.controller.ManageServiceController;
import edu.ijse.water.dto.CategoryDTO;
import edu.ijse.water.dto.FoodDTO;
import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.dto.OrderDetailsDTO;
import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.dto.ServiceDTO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SL_WOLF
 */
public class Check_Customer_Stats extends javax.swing.JPanel {

    /**
     * Creates new form Service_Add
     */
    DefaultTableModel dtm;
    List<FoodDTO> foodDTOs;
    List<GiftDTO> giftDTOs;
    List<ServiceDTO> serviceDTOs;
    private  String tabelService;
    private  String tabelItem;
    private  double tabelPrice;
    private  String tabelTime;
    private double totalAmont;
    String date;
    public Check_Customer_Stats() {
        initComponents();
        SetDate();
        dtm = (DefaultTableModel) tblOrders.getModel();
        dtm.setRowCount(0);
        loadAllFoods();
        loadAllGifts();
        loadAllServices();
        totalAmont=0;
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
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        lblClear = new javax.swing.JLabel();
        lblCancel = new javax.swing.JLabel();
        lblWB = new javax.swing.JLabel();
        txtWBandID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        lblSerch = new javax.swing.JLabel();
        lblBox = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(832, 520));
        setMinimumSize(new java.awt.Dimension(832, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBoxHeader.setBackground(new java.awt.Color(0, 102, 153));
        lblBoxHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBoxHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblBoxHeader.setText("     Check Customer Stats");
        lblBoxHeader.setOpaque(true);
        add(lblBoxHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 30));

        lblTotal.setText("Total                                             :");
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 210, -1));

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

        lblWB.setText("Wrist Band ID                         :");
        add(lblWB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtWBandID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWBandIDActionPerformed(evt);
            }
        });
        add(txtWBandID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 210, -1));

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service", "Others", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblOrders);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 710, 230));

        lblSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Entypo_d83d(0)_32_1.png"))); // NOI18N
        add(lblSerch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 30, 20));

        lblBox.setBackground(new java.awt.Color(51, 0, 0));
        lblBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 380));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setText(" ");
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtWBandIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWBandIDActionPerformed
            dtm.setRowCount(0);
            totalAmont=0;
        
        
            try {
            List<PendingDTO> pendingDTOs = ManagePendingController.getAll(txtWBandID.getText());

            if (pendingDTOs == null) {
                return;
            }

            for (PendingDTO pendingDTO : pendingDTOs) {
                
                tabelTime=pendingDTO.getTime();
                  
                    for (ServiceDTO serviceDTO : serviceDTOs) {
                 
                        String serID=pendingDTO.getServiceID();
                        
                        if(serID.matches(serviceDTO.getServiceId())){
                            tabelService=serviceDTO.getServiceName();
                            
                            if(pendingDTO.getServiceID().matches("service003")){
                                
                                for (FoodDTO foodDTO : foodDTOs) {
                                    
                                    if(pendingDTO.getItemID().matches(foodDTO.getFid())){
                                        
                                        tabelItem=(foodDTO.getDescription()+" * "+pendingDTO.getQty());
                                        double price=(foodDTO.getPrice() * pendingDTO.getQty());
                                        tabelPrice=price;
                                        
                                    }

                                }
                            }else if(pendingDTO.getServiceID().matches("service004")){
                                
                                for(GiftDTO giftDTO : giftDTOs){
                                    
                                    if(pendingDTO.getItemID().matches(giftDTO.getGid())){
                                        tabelItem=(giftDTO.getDescription()+" * "+pendingDTO.getQty());
                                        double price=(giftDTO.getPrice() * pendingDTO.getQty());
                                        tabelPrice=price;
                                    }
                                }
                                
                            }else{
                                tabelItem="";
                                tabelPrice=serviceDTO.getPrice();
                            }
                        } 
                    }
              
                Object[] rowData = {
                    tabelService,
                    tabelItem,
                    tabelPrice,
                };
                dtm.addRow(rowData);
                totalAmont=totalAmont+tabelPrice;
                txtTotal.setText(""+totalAmont);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No data found...", "Error", JOptionPane.ERROR_MESSAGE); 
            Logger.getLogger(Check_Customer_Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtWBandIDActionPerformed

    private void lblClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseClicked
       dtm.setRowCount(0);
       txtTotal.setText("");
       txtWBandID.setText("");
    }//GEN-LAST:event_lblClearMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBox;
    private javax.swing.JLabel lblBoxHeader;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblSerch;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblWB;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtWBandID;
    // End of variables declaration//GEN-END:variables

    private void SetDate() {
        java.util.Date d1=new java.util.Date();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd");
		String formatDate=df.format(d1);
                date=formatDate;
		
    }

    private void loadAllFoods() {
        try {
             foodDTOs = ManageFoodController.getAllFoods();
        } catch (Exception ex) {
            Logger.getLogger(Check_Customer_Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllGifts() {
        try {
             giftDTOs = ManageGiftController.getAllGifts();
        } catch (Exception ex) {
            Logger.getLogger(Check_Customer_Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadAllServices() {
        try {
            serviceDTOs = ManageServiceController.getAllServices();
        } catch (Exception ex) {
            Logger.getLogger(Check_Customer_Stats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
