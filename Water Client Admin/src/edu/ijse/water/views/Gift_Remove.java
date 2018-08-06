package edu.ijse.water.views;



import edu.ijse.water.controller.ManageGiftController;
import edu.ijse.water.dto.GiftDTO;
import edu.ijse.water.observer.Observer;
import java.awt.Color;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SL_WOLF
 */
public class Gift_Remove extends javax.swing.JPanel implements Observer{

    /**
     * Creates new form Remove_student
     */
    
     private String reservedGid = "";
     private boolean update = false;
     Border idBorder;
    
    public Gift_Remove() {
        initComponents();
        idBorder = txtDesc.getBorder();
        lblRemove.setVisible(false);
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageGiftController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(Gift_Remove.class.getName()).log(Level.SEVERE, null, ex);
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

        lblBar = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new org.jdesktop.swingx.JXTextField();
        txtDesc = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblRemove = new javax.swing.JLabel();
        lblClear = new javax.swing.JLabel();
        lblCancel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblBox = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBar.setBackground(new java.awt.Color(0, 102, 153));
        lblBar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblBar.setForeground(new java.awt.Color(255, 255, 255));
        lblBar.setText("    Remove Item");
        lblBar.setOpaque(true);
        add(lblBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 30));

        lblId.setText("Item ID                                     :");
        add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        txtId.setPrompt("g001");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 210, -1));

        txtDesc.setEditable(false);
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 210, -1));

        lblDesc.setText("Description                                :");
        add(lblDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lblPrice.setText("Price                                         :");
        add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        txtPrice.setEditable(false);
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 210, -1));

        lblRemove.setBackground(new java.awt.Color(153, 0, 0));
        lblRemove.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRemove.setForeground(new java.awt.Color(255, 255, 255));
        lblRemove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRemove.setText("Remove");
        lblRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemove.setOpaque(true);
        lblRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRemoveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRemoveMouseExited(evt);
            }
        });
        add(lblRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 60, 20));

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
        add(lblClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 60, 20));

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
        add(lblCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 60, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/assets/Entypo_d83d(0)_32_1.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, 20));

        lblBox.setText(" ");
        lblBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 790, 390));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setText(" ");
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void lblRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveMouseClicked
        try {
            boolean result = ManageGiftController.deleteGift(txtId.getText());

            if (result) {
                JOptionPane.showMessageDialog(this, "Item has been deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Item can't be deleted");
            }

            ManageGiftController.releaseGift(reservedGid);
            reservedGid = "";
            txtId.setText("");
            txtDesc.setText("");
            txtPrice.setText("");
            txtId.requestFocusInWindow();
            update = false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Item can't be deleted", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Gift_Remove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblRemoveMouseClicked

    private void lblRemoveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveMouseEntered
        lblRemove.setBackground(new Color(255,51,51));
    }//GEN-LAST:event_lblRemoveMouseEntered

    private void lblRemoveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveMouseExited
        lblRemove.setBackground(new Color(153,0,0));
    }//GEN-LAST:event_lblRemoveMouseExited

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

    private void lblClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClearMouseClicked
        txtId.setText("");
        txtId.setBorder(idBorder);
        txtDesc.setText("");
        txtPrice.setText("");
        lblRemove.setVisible(false);
    }//GEN-LAST:event_lblClearMouseClicked

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if(txtId.getText().matches("g[0-9]+")){
            txtId.setBorder(idBorder);
            lblRemove.setVisible(true);
        }else{
            txtId.setBorder(BorderFactory.createLineBorder(Color.red));
            lblRemove.setVisible(false);
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        GiftDTO giftDTO = new GiftDTO();
        
         try {
             giftDTO=ManageGiftController.searchGift(txtId.getText());
             
             if(giftDTO!= null){
                 //txtName.setText(categoryDTO.getCatName());
             }else{
                 JOptionPane.showMessageDialog(this,"Check The  ID Again");
             }
             
         } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "No data found...", "Error", JOptionPane.ERROR_MESSAGE); 
             Logger.getLogger(Category_Remove.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        try {
                    if (reservedGid == "") {
                        ManageGiftController.releaseGift(reservedGid);
                    }
                    reservedGid = txtId.getText();
                    boolean reserveCategory = ManageGiftController.reserveGift(reservedGid);

                    if (reserveCategory) {
                        update = true;
                        txtDesc.setText(giftDTO.getDescription());
                        txtPrice.setText(""+giftDTO.getPrice());
                    } else {
                        update = false;
                        JOptionPane.showMessageDialog(Gift_Remove.this, "Item has been already reserved");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(Gift_Remove.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_txtIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBar;
    private javax.swing.JLabel lblBox;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lblClear;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblRemove;
    private javax.swing.JTextField txtDesc;
    private org.jdesktop.swingx.JXTextField txtId;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateObservers() throws Exception {
        
    }
}