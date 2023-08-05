/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Backup_Restore;

import GUI.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.apache.log4j.Logger;

/**
 *
 * @author kulas
 */
public class backup_restoreFrame_manager extends javax.swing.JFrame {

    /**
     * Creates new form dashBoardFrame
     */
    static Logger log1 = Logger.getLogger(loginForm.class.getName());
    
    public backup_restoreFrame_manager() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        jPanel3.setEnabled(false);
        jPanel3.setVisible(false);
        setting3.setEnabled(false);
        setting3.setVisible(false);
        showDate();showTime();
    }
void showDate(){
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date.setText(s.format(d));
    }
    void showTime(){
        new Timer(0, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                Time.setText(s.format(d));
                 }
        }
        ).start();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        viewsetting = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        data = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        setting = new javax.swing.JLabel();
        setting3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        customer = new javax.swing.JLabel();
        staff = new javax.swing.JLabel();
        item = new javax.swing.JLabel();
        suppliers = new javax.swing.JLabel();
        dashboard = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        userManager = new javax.swing.JLabel();
        addSales = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        dashBoardMain = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        restore = new javax.swing.JLabel();
        backup = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 675));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 675));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 675));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Manager");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 40, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Status :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 40, -1, -1));

        jPanel3.setLayout(null);

        viewsetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewsetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.JPG"))); // NOI18N
        jPanel3.add(viewsetting);
        viewsetting.setBounds(0, 0, 157, 141);

        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel3.add(exit);
        exit.setBounds(0, 100, 160, 40);

        log.setText("jLabel1");
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logMouseClicked(evt);
            }
        });
        jPanel3.add(log);
        log.setBounds(0, 0, 160, 50);

        data.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(data);
        data.setBounds(0, 50, 160, 40);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 160, 140));

        jPanel2.setMaximumSize(new java.awt.Dimension(450, 675));
        jPanel2.setMinimumSize(new java.awt.Dimension(450, 675));
        jPanel2.setPreferredSize(new java.awt.Dimension(450, 675));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mechanical-gears-.png"))); // NOI18N
        setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingMouseClicked(evt);
            }
        });
        jPanel2.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, -1, -1));

        setting3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mechanical-gears-.png"))); // NOI18N
        setting3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setting3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setting3MouseClicked(evt);
            }
        });
        jPanel2.add(setting3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CEYLON LAKSHA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        home.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        home.setText("   Home");
        home.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        jPanel2.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 190, -1));

        customer.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        customer.setForeground(new java.awt.Color(255, 255, 255));
        customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customer.png"))); // NOI18N
        customer.setText("   Customer");
        customer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        customer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
        });
        jPanel2.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 190, -1));

        staff.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        staff.setForeground(new java.awt.Color(255, 255, 255));
        staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/employees.png"))); // NOI18N
        staff.setText("   Staff");
        staff.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        staff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        staff.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        staff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffMouseClicked(evt);
            }
        });
        jPanel2.add(staff, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 190, -1));

        item.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        item.setForeground(new java.awt.Color(255, 255, 255));
        item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/box.png"))); // NOI18N
        item.setText("   Item");
        item.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        item.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        item.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemMouseClicked(evt);
            }
        });
        jPanel2.add(item, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 190, -1));

        suppliers.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        suppliers.setForeground(new java.awt.Color(255, 255, 255));
        suppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hotel-supplier.png"))); // NOI18N
        suppliers.setText("   Suppliers");
        suppliers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        suppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        suppliers.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        suppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliersMouseClicked(evt);
            }
        });
        jPanel2.add(suppliers, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 190, -1));

        dashboard.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu (2).png"))); // NOI18N
        dashboard.setText("   Dashboard");
        dashboard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
        });
        jPanel2.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 190, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("All right reserved.");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 650, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Concept By Heshan Kulasooriya. ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, -1, -1));

        jLabel9.setBackground(new java.awt.Color(9, 14, 14));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Copyright @ 2021 REYGREN.");
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, 160, 60));

        userManager.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        userManager.setForeground(new java.awt.Color(255, 255, 255));
        userManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N
        userManager.setText("   Manage User");
        userManager.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        userManager.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userManager.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        userManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userManagerMouseClicked(evt);
            }
        });
        jPanel2.add(userManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 190, -1));

        addSales.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        addSales.setForeground(new java.awt.Color(255, 255, 255));
        addSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cart (1).png"))); // NOI18N
        addSales.setText("   Add Sales");
        addSales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        addSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addSales.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        addSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSalesMouseClicked(evt);
            }
        });
        jPanel2.add(addSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 190, -1));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, -1, -1));

        jLabel1.setMaximumSize(new java.awt.Dimension(450, 675));
        jLabel1.setMinimumSize(new java.awt.Dimension(450, 675));
        jLabel1.setPreferredSize(new java.awt.Dimension(450, 675));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 910, 1010));

        Date.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        Date.setForeground(new java.awt.Color(255, 255, 255));
        Date.setText("Date");
        jPanel2.add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Time.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("Time");
        jPanel2.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        dashBoardMain.setBackground(new java.awt.Color(204, 204, 204));
        dashBoardMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wes dancer~2.png"))); // NOI18N
        dashBoardMain.setOpaque(true);
        jPanel2.add(dashBoardMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 288, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 288, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close-button (2).png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 10, -1, -1));

        restore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/restore.jpg"))); // NOI18N
        restore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        restore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restoreMouseClicked(evt);
            }
        });
        jPanel1.add(restore, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 290, 170));

        backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backup.jpg"))); // NOI18N
        backup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backupMouseClicked(evt);
            }
        });
        jPanel1.add(backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, 140));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   Backup and Restore Area");
        jLabel3.setIconTextGap(10);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 790, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1166, -1));

        setSize(new java.awt.Dimension(1166, 675));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void setting3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setting3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_setting3MouseClicked

    private void settingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingMouseClicked
        jPanel3.setEnabled(true);
        jPanel3.setVisible(true);
        setting.setEnabled(false);
        setting.setVisible(false);
        setting3.setEnabled(true);
        setting3.setVisible(true);
    }//GEN-LAST:event_settingMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked
        new loginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        for (double i = 0.0; i <=1.0;i = i + 0.1)
        {
            String val = i+ "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try{
                Thread.sleep(50);
            }
            catch(Exception e)
            {
                log1.debug(e.getMessage());
            }
        }
        jLabel1.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        new GUI.Home.homeFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void userManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagerMouseClicked
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(rootPane, "Sorry! You can't Enter..","Warnning", 1, null);
    }//GEN-LAST:event_userManagerMouseClicked

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        // TODO add your handling code here
        new GUI.Customer.customerFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerMouseClicked

    private void staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffMouseClicked
        // TODO add your handling code here:
        new GUI.Staff.staffFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_staffMouseClicked

    private void itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMouseClicked
        // TODO add your handling code here:
        new GUI.Items.itemsFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemMouseClicked

    private void suppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersMouseClicked
        // TODO add your handling code here:
        new GUI.Supplier.supplierFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_suppliersMouseClicked

    private void addSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSalesMouseClicked
        // TODO add your handling code here:
        new GUI.AddSales.addSalesFrame_manager().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addSalesMouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        // TODO add your handling code here:
        new dashBoardFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardMouseClicked

    private void backupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backupMouseClicked
        // TODO add your handling code here:
        new backupForm().setVisible(true);
        
    }//GEN-LAST:event_backupMouseClicked

    private void restoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restoreMouseClicked
        // TODO add your handling code here:
        new restoreForm().setVisible(true);
       
    }//GEN-LAST:event_restoreMouseClicked

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
        new aboutus(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_userMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(backup_restoreFrame_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(backup_restoreFrame_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(backup_restoreFrame_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(backup_restoreFrame_manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new backup_restoreFrame_manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel addSales;
    private javax.swing.JLabel backup;
    private javax.swing.JLabel close;
    private javax.swing.JLabel customer;
    private javax.swing.JLabel dashBoardMain;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel data;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel home;
    private javax.swing.JLabel item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel log;
    private javax.swing.JLabel restore;
    private javax.swing.JLabel setting;
    private javax.swing.JLabel setting3;
    private javax.swing.JLabel staff;
    private javax.swing.JLabel suppliers;
    private javax.swing.JLabel user;
    private javax.swing.JLabel userManager;
    private javax.swing.JLabel viewsetting;
    // End of variables declaration//GEN-END:variables
}
