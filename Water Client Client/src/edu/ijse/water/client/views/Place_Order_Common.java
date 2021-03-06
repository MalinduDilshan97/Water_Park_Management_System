/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.water.client.views;

import edu.ijse.water.client.controller.ManagePendingController;
import edu.ijse.water.client.controller.ManageServiceController;
import edu.ijse.water.dto.PendingDTO;
import edu.ijse.water.dto.ServiceDTO;
import edu.ijse.water.observer.Observer;
import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SL_WOLF
 */
public class Place_Order_Common extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form AddCategory
     */
    int pid;
    String other;
    int qty;
    String serviceId;
    
    public Place_Order_Common() {
        initComponents();
        pid=0;
        other="non";
        qty=0;
        
       
    }

    Place_Order_Common(String serviceId) {
        initComponents();
        pid=0;
        other="non";
        qty=0;
        this.serviceId=serviceId;
        loadDetails();
        setTime();
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManagePendingController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(Place_Order_Common.class.getName()).log(Level.SEVERE, null, ex);
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

        lblCancel = new javax.swing.JLabel();
        lblNew = new javax.swing.JLabel();
        lblPlace = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtService = new javax.swing.JTextField();
        lblOPrice = new javax.swing.JLabel();
        lblOPrice1 = new javax.swing.JLabel();
        lblSI = new javax.swing.JLabel();
        txtWBandID = new javax.swing.JTextField();
        lblWB = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        lblBoxHeader = new javax.swing.JLabel();
        lblBox = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(832, 520));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblNew.setBackground(new java.awt.Color(153, 0, 0));
        lblNew.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNew.setForeground(new java.awt.Color(255, 255, 255));
        lblNew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNew.setText("Clear");
        lblNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblNew.setOpaque(true);
        lblNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNewMouseExited(evt);
            }
        });
        add(lblNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 60, 20));

        lblPlace.setBackground(new java.awt.Color(153, 0, 0));
        lblPlace.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPlace.setForeground(new java.awt.Color(255, 255, 255));
        lblPlace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlace.setText("Place");
        lblPlace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPlace.setOpaque(true);
        lblPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlaceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPlaceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPlaceMouseExited(evt);
            }
        });
        add(lblPlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 60, 20));

        txtPrice.setEditable(false);
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 210, -1));

        txtService.setEditable(false);
        add(txtService, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 210, -1));

        lblOPrice.setText("Time                                                 :");
        add(lblOPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        lblOPrice1.setText("Price                                                 :");
        add(lblOPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        lblSI.setText("Service                                             :");
        add(lblSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        add(txtWBandID, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 210, -1));

        lblWB.setText("Wrist Band ID                                   :");
        add(lblWB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        txtTime.setEditable(false);
        add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 210, -1));

        lblBoxHeader.setBackground(new java.awt.Color(0, 102, 153));
        lblBoxHeader.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBoxHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblBoxHeader.setText("    Fill The  Details");
        lblBoxHeader.setOpaque(true);
        add(lblBoxHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 30));

        lblBox.setBackground(new java.awt.Color(51, 0, 0));
        lblBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 390));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void lblPlaceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlaceMouseEntered
        lblPlace.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblPlaceMouseEntered

    private void lblPlaceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlaceMouseExited
        lblPlace.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblPlaceMouseExited

    private void lblCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseExited
        lblCancel.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblCancelMouseExited

    private void lblCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelMouseEntered
        lblCancel.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblCancelMouseEntered

    private void lblNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewMouseExited
        lblNew.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblNewMouseExited

    private void lblNewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewMouseEntered
        lblNew.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblNewMouseEntered

    private void lblPlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlaceMouseClicked
        PendingDTO pendingDTO = new PendingDTO();
        pendingDTO.setPid(pid);
        pendingDTO.setWbid(txtWBandID.getText());
        pendingDTO.setServiceID(serviceId);
        pendingDTO.setItemID(other);
        pendingDTO.setQty(qty);
        pendingDTO.setTime(txtTime.getText());
        
        boolean result=false;
        
        try {
            result=ManagePendingController.addDetails(pendingDTO);
            if(result){
                JOptionPane.showMessageDialog(this, "Order has been Placed successfully");
                txtWBandID.setText("");
                setTime();
            }else{
                JOptionPane.showMessageDialog(this, "Failed to Placed the Order");
                setTime();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Failed to Placed the Order", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Entrance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPlaceMouseClicked

    private void lblNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewMouseClicked
        setTime();
        txtWBandID.setText("");
    }//GEN-LAST:event_lblNewMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBox;
    private javax.swing.JLabel lblBoxHeader;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblNew;
    private javax.swing.JLabel lblOPrice;
    private javax.swing.JLabel lblOPrice1;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblSI;
    private javax.swing.JLabel lblWB;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtService;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtWBandID;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        
    }

    private void loadDetails() {
        ServiceDTO serviceDTO = new ServiceDTO();
        
         try {
             serviceDTO=ManageServiceController.searchService(serviceId);
             
             if(serviceDTO!= null){
                 txtService.setText(serviceDTO.getServiceName());
                 txtPrice.setText(""+serviceDTO.getPrice());
             }
             
         } catch (Exception ex) {
             Logger.getLogger(Place_Order_Common.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void setTime() {
        java.util.Date d1=new java.util.Date();
		SimpleDateFormat df=new SimpleDateFormat("HH:mm");
		String formatDate=df.format(d1);
		txtTime.setText(formatDate);
    }
}
