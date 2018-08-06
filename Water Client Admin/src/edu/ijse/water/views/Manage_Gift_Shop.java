package edu.ijse.water.views;



import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SL_WOLF
 */
public class Manage_Gift_Shop extends javax.swing.JPanel {

    /**
     * Creates new form student_Registration
     */
    
    public Manage_Gift_Shop() {
        initComponents();
        lblItem.setBackground(Color.WHITE);
        lblItem.setForeground(Color.BLACK);
        
      
     
        pnlGiftMain.setVisible(true);
        Gift_List s=new Gift_List();
        pnlGiftMain.removeAll();
        s.setSize(pnlGiftMain.getSize());
        pnlGiftMain.add(s);
        pnlGiftMain.repaint();
        pnlGiftMain.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGiftMain = new javax.swing.JPanel();
        lblItem = new javax.swing.JLabel();
        lblAddStudent = new javax.swing.JLabel();
        lblRemoveStudent = new javax.swing.JLabel();
        lblUpdate = new javax.swing.JLabel();
        lblBar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlGiftMain.setBackground(new java.awt.Color(255, 255, 255));
        add(pnlGiftMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 850, 580));

        lblItem.setBackground(new java.awt.Color(255, 102, 51));
        lblItem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblItem.setForeground(new java.awt.Color(255, 255, 255));
        lblItem.setText("         + Item List");
        lblItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblItem.setOpaque(true);
        lblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblItemMouseClicked(evt);
            }
        });
        add(lblItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        lblAddStudent.setBackground(new java.awt.Color(255, 102, 51));
        lblAddStudent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAddStudent.setForeground(new java.awt.Color(255, 255, 255));
        lblAddStudent.setText("        + Add Item");
        lblAddStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddStudent.setOpaque(true);
        lblAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddStudentMouseClicked(evt);
            }
        });
        add(lblAddStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 110, 40));

        lblRemoveStudent.setBackground(new java.awt.Color(255, 102, 51));
        lblRemoveStudent.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRemoveStudent.setForeground(new java.awt.Color(255, 255, 255));
        lblRemoveStudent.setText("       + Remove Item");
        lblRemoveStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRemoveStudent.setOpaque(true);
        lblRemoveStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRemoveStudentMouseClicked(evt);
            }
        });
        add(lblRemoveStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 130, 40));

        lblUpdate.setBackground(new java.awt.Color(255, 102, 51));
        lblUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUpdate.setForeground(new java.awt.Color(255, 255, 255));
        lblUpdate.setText("     + Update Item");
        lblUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUpdate.setOpaque(true);
        lblUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpdateMouseClicked(evt);
            }
        });
        add(lblUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 110, 40));

        lblBar.setBackground(new java.awt.Color(255, 102, 51));
        lblBar.setOpaque(true);
        add(lblBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void lblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblItemMouseClicked
        
            
            lblItem.setBackground(Color.WHITE);
            lblItem.setForeground(Color.BLACK);
            lblAddStudent.setBackground(new Color(255,102,51));
            lblAddStudent.setForeground(Color.WHITE);
            lblRemoveStudent.setForeground(Color.WHITE);
            lblRemoveStudent.setBackground(new Color(255,102,51));
            lblUpdate.setForeground(Color.WHITE);
            lblUpdate.setBackground(new Color(255,102,51));
            
           
            pnlGiftMain.setVisible(true);
            Gift_List s=new Gift_List();
            pnlGiftMain.removeAll();
            s.setSize(pnlGiftMain.getSize());
            pnlGiftMain.add(s);
            pnlGiftMain.repaint();
            pnlGiftMain.revalidate();
           
  
           
        
    }//GEN-LAST:event_lblItemMouseClicked

    private void lblAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddStudentMouseClicked
        
            lblAddStudent.setBackground(Color.WHITE);
            lblAddStudent.setForeground(Color.BLACK);
            lblItem.setBackground(new Color(255,102,51));
            lblItem.setForeground(Color.WHITE);
            lblRemoveStudent.setForeground(Color.WHITE);
            lblRemoveStudent.setBackground(new Color(255,102,51));
            lblUpdate.setForeground(Color.WHITE);
            lblUpdate.setBackground(new Color(255,102,51));
            pnlGiftMain.setVisible(false);
            
            pnlGiftMain.setVisible(true);
            Gift_Add a=new Gift_Add();
            pnlGiftMain.removeAll();
            a.setSize(pnlGiftMain.getSize());
            pnlGiftMain.add(a);
            pnlGiftMain.repaint();
            pnlGiftMain.revalidate();
        
       
        
        
        
    }//GEN-LAST:event_lblAddStudentMouseClicked

    private void lblRemoveStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRemoveStudentMouseClicked
        
            lblRemoveStudent.setForeground(Color.BLACK);
            lblRemoveStudent.setBackground(Color.WHITE);
            lblAddStudent.setBackground(new Color(255,102,51));
            lblAddStudent.setForeground(Color.WHITE);
            lblItem.setForeground(Color.WHITE);
            lblItem.setBackground(new Color(255,102,51));
            lblUpdate.setForeground(Color.WHITE);
            lblUpdate.setBackground(new Color(255,102,51));
            
            pnlGiftMain.setVisible(true);
            Gift_Remove r=new Gift_Remove();
            pnlGiftMain.removeAll();
            r.setSize(pnlGiftMain.getSize());
            pnlGiftMain.add(r);
            pnlGiftMain.repaint();
            pnlGiftMain.revalidate();
            
           
       
    }//GEN-LAST:event_lblRemoveStudentMouseClicked

    private void lblUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpdateMouseClicked
        
            lblUpdate.setForeground(Color.BLACK);
            lblUpdate.setBackground(Color.WHITE);
            lblItem.setForeground(Color.WHITE);
            lblItem.setBackground(new Color(255,102,51));
            lblAddStudent.setForeground(Color.WHITE);
            lblAddStudent.setBackground(new Color(255,102,51));
            lblRemoveStudent.setForeground(Color.WHITE);
            lblRemoveStudent.setBackground(new Color(255,102,51));
            
       
            pnlGiftMain.setVisible(true);
            Gift_Update u=new Gift_Update();
            pnlGiftMain.removeAll();
            u.setSize(pnlGiftMain.getSize());
            pnlGiftMain.add(u);
            pnlGiftMain.repaint();
            pnlGiftMain.revalidate();
    }//GEN-LAST:event_lblUpdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddStudent;
    private javax.swing.JLabel lblBar;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblRemoveStudent;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JPanel pnlGiftMain;
    // End of variables declaration//GEN-END:variables
}
