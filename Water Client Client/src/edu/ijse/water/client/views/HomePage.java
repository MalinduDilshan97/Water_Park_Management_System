package edu.ijse.water.client.views;



import edu.ijse.water.client.controller.ManageMessageController;
import edu.ijse.water.dto.MessagesDTO;
import edu.ijse.water.observer.Observer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SL_WOLF
 */
public class HomePage extends javax.swing.JFrame implements Observer{

    /**
     * Creates new form HomePage
     */
   
    private int count3=0;
    private int count2=0;
    private JLabel x;
    private int count=0;
    private String serviceId;
    private String serviceName;
    private Timer tmrTime;
    public HomePage() {
        initComponents();
        Load();
        
    }

    HomePage(String serviceId, String serviceName) {
        initComponents();
        Load();
        lblNotiUserName.setText(serviceName);
        setTimeAndDate();
        loadMessages();
        this.serviceId=serviceId;
        this.serviceName=serviceName;
        setLable();
        
        try {
            UnicastRemoteObject.exportObject(this, 0);
            ManageMessageController.getSubject().registerObserver(this);
        } catch (Exception ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblDashboardline = new javax.swing.JLabel();
        lblStatsLine = new javax.swing.JLabel();
        lblOrderLine = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        lblAdminLogo = new javax.swing.JLabel();
        lblBar = new javax.swing.JLabel();
        lblSignIn = new javax.swing.JLabel();
        lblSignInLogo = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblLogoutLogo = new javax.swing.JLabel();
        lblBox = new javax.swing.JLabel();
        lblDashboard = new javax.swing.JLabel();
        lblStats = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblMenuBox = new javax.swing.JLabel();
        PanelMain = new javax.swing.JPanel();
        lblMenuName = new javax.swing.JLabel();
        panelNotification = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblServerIcon = new javax.swing.JLabel();
        lblNotiUser = new javax.swing.JLabel();
        lblNotiUserName = new javax.swing.JLabel();
        lblCreate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblNotiIn = new javax.swing.JLabel();
        lblTimeDate = new javax.swing.JLabel();
        lblNotificationBox = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        lblBottomBar = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/waterworld-.png"))); // NOI18N
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 220, 40));

        lblDashboardline.setBackground(new java.awt.Color(51, 51, 51));
        lblDashboardline.setOpaque(true);
        jPanel1.add(lblDashboardline, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 10, 40));

        lblStatsLine.setBackground(new java.awt.Color(51, 51, 51));
        lblStatsLine.setOpaque(true);
        jPanel1.add(lblStatsLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 10, 40));

        lblOrderLine.setBackground(new java.awt.Color(51, 51, 51));
        lblOrderLine.setOpaque(true);
        jPanel1.add(lblOrderLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 10, 40));

        lblAdmin.setBackground(new java.awt.Color(255, 255, 255));
        lblAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAdmin.setText(" Client");
        lblAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAdminMouseExited(evt);
            }
        });
        jPanel1.add(lblAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 70, 30));

        lblAdminLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblAdminLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Entypo_d83d(0)_32.png"))); // NOI18N
        lblAdminLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAdminLogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAdminLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAdminLogoMouseExited(evt);
            }
        });
        jPanel1.add(lblAdminLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, 30, 30));

        lblBar.setBackground(new java.awt.Color(204, 204, 204));
        lblBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Nr11 (482).jpg"))); // NOI18N
        jPanel1.add(lblBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        lblSignIn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSignIn.setText("Sign in");
        lblSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSignIn.setOpaque(true);
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignInMouseExited(evt);
            }
        });
        jPanel1.add(lblSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 60, 100, 30));

        lblSignInLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Entypo_d83d(0)_24.png"))); // NOI18N
        lblSignInLogo.setOpaque(true);
        jPanel1.add(lblSignInLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 60, 30, 30));

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblLogout.setText("    Log out");
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.setOpaque(true);
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });
        jPanel1.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 100, 110, 30));

        lblLogoutLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoutLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Iconia_50(0)_48.png"))); // NOI18N
        lblLogoutLogo.setOpaque(true);
        jPanel1.add(lblLogoutLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 100, 20, 30));

        lblBox.setOpaque(true);
        jPanel1.add(lblBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 60, 130, 70));

        lblDashboard.setBackground(new java.awt.Color(39, 58, 77));
        lblDashboard.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(204, 204, 204));
        lblDashboard.setText("    +   Dash board");
        lblDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDashboard.setOpaque(true);
        lblDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDashboardMouseExited(evt);
            }
        });
        jPanel1.add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, 40));

        lblStats.setBackground(new java.awt.Color(39, 58, 77));
        lblStats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStats.setForeground(new java.awt.Color(204, 204, 204));
        lblStats.setText("    +   Check Customer Stats");
        lblStats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblStats.setOpaque(true);
        lblStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStatsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblStatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblStatsMouseExited(evt);
            }
        });
        jPanel1.add(lblStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 40));

        lblOrder.setBackground(new java.awt.Color(39, 58, 77));
        lblOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(204, 204, 204));
        lblOrder.setText("    +   Place A Service Order");
        lblOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOrder.setOpaque(true);
        lblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOrderMouseExited(evt);
            }
        });
        jPanel1.add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 240, 40));

        lblMenuBox.setBackground(new java.awt.Color(39, 58, 77));
        lblMenuBox.setOpaque(true);
        jPanel1.add(lblMenuBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 240, 580));

        PanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(PanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 890, 630));

        lblMenuName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMenuName.setForeground(new java.awt.Color(102, 102, 102));
        lblMenuName.setText("Client Dashboard");
        jPanel1.add(lblMenuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        panelNotification.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDate.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panelNotification.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 220, 40));

        lblTime.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelNotification.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 220, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Servers Up");
        panelNotification.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 80, 20));

        lblServerIcon.setBackground(new java.awt.Color(255, 255, 255));
        lblServerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/ijse/water/client/assets/Green_Arrow_Top 20 20.png"))); // NOI18N
        lblServerIcon.setOpaque(true);
        panelNotification.add(lblServerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 590, 20, 20));

        lblNotiUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNotiUser.setForeground(new java.awt.Color(204, 204, 204));
        lblNotiUser.setText("Logged As");
        panelNotification.add(lblNotiUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblNotiUserName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNotiUserName.setForeground(new java.awt.Color(204, 204, 204));
        lblNotiUserName.setText("Game Center");
        panelNotification.add(lblNotiUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblCreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCreate.setText("Messages From Management");
        panelNotification.add(lblCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 230, 30));

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        panelNotification.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 200, 300));

        lblNotiIn.setBackground(new java.awt.Color(102, 102, 102));
        lblNotiIn.setOpaque(true);
        panelNotification.add(lblNotiIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 235, 360));

        lblTimeDate.setBackground(new java.awt.Color(102, 102, 102));
        lblTimeDate.setText(" ");
        lblTimeDate.setOpaque(true);
        panelNotification.add(lblTimeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 235, 70));

        lblNotificationBox.setBackground(new java.awt.Color(39, 58, 77));
        lblNotificationBox.setOpaque(true);
        panelNotification.add(lblNotificationBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 630));

        jPanel1.add(panelNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 100, 240, 630));

        lblCount.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        lblCount.setForeground(new java.awt.Color(255, 255, 255));
        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 740, 60, 20));

        lblBottomBar.setBackground(new java.awt.Color(0, 0, 0));
        lblBottomBar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        lblBottomBar.setForeground(new java.awt.Color(255, 255, 255));
        lblBottomBar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomBar.setText("POWERED BY INSTITUTE OF JAVA AND SOFTWARE ENGINEERING");
        lblBottomBar.setOpaque(true);
        jPanel1.add(lblBottomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 1370, 40));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setOpaque(true);
        lblBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackgroundMouseClicked(evt);
            }
        });
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAdminLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminLogoMouseEntered
        lblAdmin.setBackground(new Color(240,240,240));
        lblAdmin.setForeground(Color.BLACK);
        lblAdminLogo.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_lblAdminLogoMouseEntered

    private void lblAdminLogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminLogoMouseExited
        lblAdmin.setBackground( Color.WHITE);
        lblAdmin.setForeground(Color.BLACK);
        lblAdminLogo.setBackground(Color.WHITE);
    }//GEN-LAST:event_lblAdminLogoMouseExited

    private void lblSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseEntered
        lblSignIn.setBackground(new Color(102,102,255));
        lblSignInLogo.setBackground(new Color(102,102,255));
        lblSignIn.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblSignInMouseEntered

    private void lblSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseExited
        lblSignIn.setBackground(new Color(240,240,240));
        lblSignInLogo.setBackground(new Color(240,240,240));
        lblSignIn.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblSignInMouseExited

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        lblLogout.setBackground(new Color(102,102,255));
        lblLogoutLogo.setBackground(new Color(102,102,255));
        lblLogout.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        lblLogout.setBackground(new Color(240,240,240));
        lblLogoutLogo.setBackground(new Color(240,240,240));
        lblLogout.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblLogoutMouseExited

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
         int res = JOptionPane.showConfirmDialog(this, " Do You Want To Log out ? " );
         if(res==0){
             new Login().setVisible(true);
             tmrTime.stop();
             this.dispose();
             
         }

        
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseClicked
        if(count==0){
            lblBox.setVisible(true);
            lblSignInLogo.setVisible(true);
            lblSignIn.setVisible(true);
            lblLogoutLogo.setVisible(true);
            lblLogout.setVisible(true);
            count=1;
        }else{
           lblBox.setVisible(false);
            lblSignInLogo.setVisible(false);
            lblSignIn.setVisible(false);
            lblLogoutLogo.setVisible(false);
            lblLogout.setVisible(false);
            count=0;
        }
    }//GEN-LAST:event_lblAdminMouseClicked

    private void lblAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseEntered
        lblAdmin.setBackground(new Color(240,240,240));
        lblAdmin.setForeground(Color.BLACK);
        lblAdminLogo.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_lblAdminMouseEntered

    private void lblAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminMouseExited
       lblAdmin.setBackground( Color.WHITE);
        lblAdmin.setForeground(Color.BLACK);
        lblAdminLogo.setBackground(Color.WHITE);
    }//GEN-LAST:event_lblAdminMouseExited

    private void lblAdminLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAdminLogoMouseClicked
        if(count==0){
            lblBox.setVisible(true);
            lblSignInLogo.setVisible(true);
            lblSignIn.setVisible(true);
            lblLogoutLogo.setVisible(true);
            lblLogout.setVisible(true);
            count=1;
        }else{
           lblBox.setVisible(false);
            lblSignInLogo.setVisible(false);
            lblSignIn.setVisible(false);
            lblLogoutLogo.setVisible(false);
            lblLogout.setVisible(false);
            count=0;
        }
    }//GEN-LAST:event_lblAdminLogoMouseClicked

    private void lblDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseEntered
       
        lblDashboard.setForeground(Color.WHITE);
        lblDashboardline.setVisible(true);
       
    }//GEN-LAST:event_lblDashboardMouseEntered

    private void lblDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseExited
  
        lblDashboard.setForeground(new Color(204,204,204));
        lblDashboardline.setVisible(false);
    }//GEN-LAST:event_lblDashboardMouseExited

    private void lblStatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatsMouseEntered
        lblStats.setForeground(Color.WHITE);
        lblStatsLine.setVisible(true);
    }//GEN-LAST:event_lblStatsMouseEntered

    private void lblStatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatsMouseExited
        lblStats.setForeground(new Color(204,204,204));
        lblStatsLine.setVisible(false);
    }//GEN-LAST:event_lblStatsMouseExited

    private void lblOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseEntered
        lblOrder.setForeground(Color.WHITE);
        lblOrderLine.setVisible(true);
    }//GEN-LAST:event_lblOrderMouseEntered

    private void lblOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseExited
        lblOrder.setForeground(new Color(204,204,204));
        lblOrderLine.setVisible(false);
    }//GEN-LAST:event_lblOrderMouseExited

    private void lblDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDashboardMouseClicked
        x.setBackground(new Color(39,58,77));
        lblDashboard.setBackground(new Color(51,51,51));
        x=lblDashboard;
        count2=0;
        count3=0;
        
        lblMenuName.setText("Client Dashboard");
        panelNotification.setVisible(true);
        PanelMain.setVisible(false);
        
        PanelMain.setVisible(true);
        Dashboard d=new Dashboard();
        PanelMain.removeAll();
        d.setSize(PanelMain.getSize());
        PanelMain.add(d);
        PanelMain.repaint();
        PanelMain.revalidate();
        
    }//GEN-LAST:event_lblDashboardMouseClicked

    private void lblStatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStatsMouseClicked
        x.setBackground(new Color(39,58,77));
        lblStats.setBackground(new Color(51,51,51));
        x=lblStats;
        count2=0;
        count3=0;
        
        lblMenuName.setText("Check Customer Stats");
        PanelMain.setVisible(true);
        Check_Stats check_Stats = new Check_Stats();
        PanelMain.removeAll();
        check_Stats.setSize(PanelMain.getSize());
        PanelMain.add(check_Stats);
        PanelMain.repaint();
        PanelMain.revalidate();
     
    }//GEN-LAST:event_lblStatsMouseClicked

    private void lblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseClicked
        lblOrderLine.setVisible(true);
        x.setBackground(new Color(39,58,77));
        lblOrder.setBackground(new Color(51,51,51));
        x=lblOrder;

        
        count2=0;
        count3=0;
        
       if(serviceId.matches("service001")){
           lblMenuName.setText("Register a Customer");
       }else if(serviceId.matches("service002")){
           lblMenuName.setText("Checkout a Customer");
       }else if(serviceId.matches("service003") | serviceId.matches("service004")){
           lblMenuName.setText("Place a Customer Order");
       }else{
           lblMenuName.setText("Place a Service Order");
       }
        
        PanelMain.setVisible(true);
        Place_Order place_Order= new Place_Order(serviceId,serviceName);
        PanelMain.removeAll();
        place_Order.setSize(PanelMain.getSize());
        PanelMain.add(place_Order);
        PanelMain.repaint();
        PanelMain.revalidate();
        
    }//GEN-LAST:event_lblOrderMouseClicked

    private void lblBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackgroundMouseClicked

        count2=0;
        count3=0;
        lblBox.setVisible(false);
        lblSignInLogo.setVisible(false);
        lblSignIn.setVisible(false);
        lblLogoutLogo.setVisible(false);
        lblLogout.setVisible(false);
        count=0;
    }//GEN-LAST:event_lblBackgroundMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMain;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAdminLogo;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBar;
    private javax.swing.JLabel lblBottomBar;
    private javax.swing.JLabel lblBox;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblCreate;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JLabel lblDashboardline;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblLogoutLogo;
    private javax.swing.JLabel lblMenuBox;
    private javax.swing.JLabel lblMenuName;
    private javax.swing.JLabel lblNotiIn;
    private javax.swing.JLabel lblNotiUser;
    private javax.swing.JLabel lblNotiUserName;
    private javax.swing.JLabel lblNotificationBox;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderLine;
    private javax.swing.JLabel lblServerIcon;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JLabel lblSignInLogo;
    private javax.swing.JLabel lblStats;
    private javax.swing.JLabel lblStatsLine;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTimeDate;
    private javax.swing.JPanel panelNotification;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

    private void Load() {
        lblBox.setBackground(new Color(240,240,240));
        lblSignInLogo.setBackground(new Color(240,240,240));
        lblSignIn.setBackground(new Color(240,240,240));
        lblLogoutLogo.setBackground(new Color(240,240,240));
        lblLogout.setBackground(new Color(240,240,240));
        lblBox.setVisible(false);
        lblSignInLogo.setVisible(false);
        lblSignIn.setVisible(false);
        lblLogoutLogo.setVisible(false);
        lblLogout.setVisible(false);
        lblDashboard.setBackground(new Color(51,51,51));
        x=lblDashboard;
        lblDashboardline.setVisible(false);
        lblStatsLine.setVisible(false);
        lblStatsLine.setVisible(false);
        lblOrderLine.setVisible(false);
        
        PanelMain.setVisible(true);
        Dashboard d=new Dashboard();
        PanelMain.removeAll();
        d.setSize(PanelMain.getSize());
        PanelMain.add(d);
        PanelMain.repaint();
        PanelMain.revalidate();
    }

    private void setTimeAndDate() {
         java.util.Date d1=new java.util.Date();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-dd");
		String formatDate=df.format(d1);
		lblDate.setText(formatDate);
        
        
        tmrTime=new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("hh: mm: ss");
                lblTime.setText(sdf.format(dt));
            }

        } );
         tmrTime.start();
    }

    @Override
    public void updateObservers() throws Exception {
        loadMessages();
    }

    private void loadMessages() {
        txtArea.setText("");
        try {
            List<MessagesDTO> messagesDTOs = ManageMessageController.getMessages(lblDate.getText());

            if (messagesDTOs == null) {
                return;
            }

            for (MessagesDTO messagesDTO : messagesDTOs) {
                
                txtArea.append(messagesDTO.getMessage()+"\n");
                
            }

        } catch (Exception ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setLable() {
       if(serviceId.matches("service001")){
           lblOrder.setText("    +   Register a Customer");
       }else if(serviceId.matches("service002")){
           lblOrder.setText("    +   Checkout a Customer");
       }else if(serviceId.matches("service003") | serviceId.matches("service004")){
           lblOrder.setText("    +   Place a Customer Order");
       }else{
           lblOrder.setText("    +   Place a Service Order");
       }
    }

    
}
