/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.AddSales;

import GUI.*;
import GUI.Items.grnJDialog;
import GUI.Items.payment;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.log4j.Logger;

/**
 *
 * @author kulas
 */
public class addSalesFrame extends javax.swing.JFrame {

    static Logger log1 = Logger.getLogger(addSalesFrame.class.getName());

    /**
     * Creates new form dashBoardFrame
     */
    public addSalesFrame() {
        initComponents();
        autoId();
        setBackground(new Color(0, 0, 0, 0));
        jPanel3.setEnabled(false);
        jPanel3.setVisible(false);
        setting3.setEnabled(false);
        setting3.setVisible(false);
        showDate();
        showTime();
        date.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        invoiceiID.setEditable(false);
//        getLastId();
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date.setText(s.format(d));
    }

    void showTime() {
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

    public void clear() {
        pBarcode.setText("");
        name.setText("");
        qty.setText("");
        price.setText("");
    }

    public static void fullclear() {
        pBarcode.setText("");
        name.setText("");
        qty.setText("");
        price.setText("");
        cBarcode.setText("");
        customerName.setText("Customer Name");
        cMobile.setText("");
        netTotal.setText("0.00");
        discount.setText("0");
        paidAmount.setText("0.00");
        balance.setText("0.00");
        DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
        dtm.setRowCount(0);
    }

//    public String getLastId() {
//        String lastId = "";
//        try {
//            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT MAX (id_invoice) as id FROM invoice");
//            if (rs.next()) {
//                if (rs.getString("id") != null) {
//                    lastId = (Integer.parseInt(rs.getString("id")) + 1) + "";
//                } else {
//                    lastId = "1";
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return lastId;
//    }
    void total() {
        double nTotal;
        double dcont;
        double payAmount;
        double tt;
        double balac;

        nTotal = Double.parseDouble(netTotal.getText());
        dcont = Double.parseDouble(discount.getText());
        if (discount.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Disconut price can not be Null");
            return;
        }
        payAmount = Double.parseDouble(paidAmount.getText());

        tt = nTotal - (nTotal * dcont / 100) - payAmount;

        balance.setText(Double.toString(tt));
    }

    public static void payment_balance() {
        paidAmount.setText(GUI.Items.payment.payment.getText());
        balance.setText(GUI.Items.payment.balance.getText());

    }

    private void autoId() {
        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT id_invoice FROM invoice ORDER BY id_invoice DESC LIMIT 1");
            if (rs.next()) {
                String rnno = rs.getString("id_invoice");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);

                String ftxt = txt + snum;
                invoiceiID.setText(ftxt);

            } else {
                invoiceiID.setText("1111");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
            log1.debug(e.getMessage());
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
        jLabel6 = new javax.swing.JLabel();
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
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pBarcode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        netTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        removeBtn = new javax.swing.JButton();
        add = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        history = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cBarcode = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        cMobile = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        invoiceiID = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 675));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 675));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 675));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(null);

        viewsetting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewsetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.JPG"))); // NOI18N
        viewsetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewsettingMouseClicked(evt);
            }
        });
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 431, 160, 140));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vertical-line.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 400, -1, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 288, -1));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close-button (2).png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1125, 11, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Admin");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Status :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("   Add Sales Itmes");
        jLabel3.setIconTextGap(10);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 39, 813, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Product Barcode");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 140, -1, -1));

        pBarcode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        pBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pBarcodeKeyTyped(evt);
            }
        });
        jPanel1.add(pBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 140, 156, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel7.setText("Hi !");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 15, 35, -1));

        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setBorder(null);
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 103, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel12.setText("Product Name");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 178, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 177, 234, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel13.setText("Qty");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(718, 178, -1, -1));

        price.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 177, 100, -1));

        qty.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        qty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        qty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 177, 46, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel14.setText("Price");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 178, -1, -1));

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Qty", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        invoiceTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invoiceTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTable);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(1).setMinWidth(100);
            invoiceTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            invoiceTable.getColumnModel().getColumn(1).setMaxWidth(100);
            invoiceTable.getColumnModel().getColumn(2).setMinWidth(100);
            invoiceTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            invoiceTable.getColumnModel().getColumn(2).setMaxWidth(100);
            invoiceTable.getColumnModel().getColumn(3).setMinWidth(100);
            invoiceTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            invoiceTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 211, 813, 308));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel15.setText("Net Total");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 533, -1, -1));

        netTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        netTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        netTotal.setText("0.00");
        netTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        netTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netTotalActionPerformed(evt);
            }
        });
        jPanel1.add(netTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 532, 121, -1));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel16.setText("Discount");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 560, -1, -1));

        discount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        discount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        discount.setText("0");
        discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });
        jPanel1.add(discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 559, 121, -1));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel17.setText("Paid Amount");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 592, -1, -1));

        paidAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        paidAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        paidAmount.setText("0.00");
        paidAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paidAmount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paidAmountMouseClicked(evt);
            }
        });
        paidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountKeyReleased(evt);
            }
        });
        jPanel1.add(paidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 591, 121, -1));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel18.setText("Balance");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 624, -1, -1));

        balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balance.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        balance.setText("0.00");
        balance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        balance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                balanceKeyReleased(evt);
            }
        });
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 623, 121, -1));

        removeBtn.setBackground(new java.awt.Color(0, 51, 51));
        removeBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Remove Selected Item");
        removeBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        removeBtn.setContentAreaFilled(false);
        removeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeBtn.setOpaque(true);
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        jPanel1.add(removeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 534, 183, -1));

        add.setBackground(new java.awt.Color(0, 51, 51));
        add.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        add.setContentAreaFilled(false);
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.setOpaque(true);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(992, 173, 163, -1));

        clearBtn.setBackground(new java.awt.Color(0, 51, 51));
        clearBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Clear Fields");
        clearBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        clearBtn.setContentAreaFilled(false);
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.setOpaque(true);
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(992, 135, 163, -1));

        history.setBackground(new java.awt.Color(0, 51, 51));
        history.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        history.setForeground(new java.awt.Color(255, 255, 255));
        history.setText("Payment History");
        history.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        history.setContentAreaFilled(false);
        history.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        history.setOpaque(true);
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        jPanel1.add(history, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 609, 183, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel8.setText("Customer Mobile");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 104, 114, -1));

        cBarcode.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cBarcode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBarcodeActionPerformed(evt);
            }
        });
        cBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cBarcodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cBarcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cBarcodeKeyTyped(evt);
            }
        });
        jPanel1.add(cBarcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 103, 156, -1));

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel19.setText("Date");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 140, -1, -1));

        customerName.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        customerName.setText("Customer Name");
        jPanel1.add(customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 15, 134, -1));

        cMobile.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cMobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMobileActionPerformed(evt);
            }
        });
        cMobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cMobileKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cMobileKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cMobileKeyTyped(evt);
            }
        });
        jPanel1.add(cMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 103, 150, -1));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jLabel20.setText("Customer Barcode");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 104, 114, -1));

        invoiceiID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(invoiceiID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 100, 114, -1));

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel21.setText("Invoice ID");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 103, -1, -1));

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
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                log1.debug(e.getMessage());
            }
        }
        jLabel1.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked
        // TODO add your handling code here:
        new GUI.Home.homeFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeMouseClicked

    private void userManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagerMouseClicked
        // TODO add your handling code here:
        new GUI.ManagerUser.managerUserFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userManagerMouseClicked

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        // TODO add your handling code here:
        new GUI.Customer.customerFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerMouseClicked

    private void staffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffMouseClicked
        // TODO add your handling code here:
        new GUI.Staff.staffFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_staffMouseClicked

    private void itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMouseClicked
        // TODO add your handling code here:
        new GUI.Items.itemsFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemMouseClicked

    private void suppliersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliersMouseClicked
        // TODO add your handling code here:
        new GUI.Supplier.supplierFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_suppliersMouseClicked

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        // TODO add your handling code here:
        new dashBoardFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardMouseClicked

    private void viewsettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewsettingMouseClicked
        // TODO add your handling code here:
        new GUI.Backup_Restore.backup_restoreFrame().setVisible(true);
    }//GEN-LAST:event_viewsettingMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // clear();

//        String tt = netTotal.getText();
//        String p = paidAmount.getText();
//        String id = invoiceiID.getText();
        String reportPath = "E:\\new.jrxml";
        Map m = new HashMap();
        m.put("total", "1000");
        // m.put("balance", 1250);
//        m.put("paidAmont", "500");
//        m.put("netTotal", "500");
        //datasource
        report newinv = new report();
        try {
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, m, DB.dbConnection.getConnection());
            newinv.tabbedPane.add(new JRViewer(jp));
            newinv.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_clearBtnActionPerformed

    private void pBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pBarcodeKeyTyped
        if ("".equals(pBarcode.getText())) {

        }
    }//GEN-LAST:event_pBarcodeKeyTyped

    private void pBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pBarcodeKeyReleased
        try {
            serachProductFormProductTable sp = new serachProductFormProductTable(null, true);
            if (!sp.isVisible()) {
                sp.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }//GEN-LAST:event_pBarcodeKeyReleased

    private void invoiceTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceTableKeyPressed

    private void cBarcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cBarcodeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cBarcodeKeyReleased

    private void cBarcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cBarcodeKeyTyped
        if ("".equals(cBarcode.getText())) {

        }

        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM customer WHERE customer_barcode LIKE '%" + cBarcode.getText() + "%'");
            String name = "";
            String mobile = "";
            while (rs.next()) {
                name = rs.getString("lname");
                mobile = rs.getString("mobile");

                customerName.setText(name);
                cMobile.setText(mobile);

            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }

    }//GEN-LAST:event_cBarcodeKeyTyped

    private void cBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBarcodeActionPerformed

    private void cBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cBarcodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBarcodeKeyPressed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            if (name.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "SELECT products");
                return;
            }
            if (qty.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "SELECT products");
                return;
            }
            if (price.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter products");
                return;
            }

            DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
            Vector v = new Vector();
            v.add(name.getText());
            v.add(price.getText());
            v.add(qty.getText());

            v.add((Double.parseDouble(price.getText()) * Double.parseDouble(qty.getText())) + "");
            dtm.addRow(v);
            netTotal.setText(Double.parseDouble(netTotal.getText()) + (Double.parseDouble(price.getText()) * Double.parseDouble(qty.getText())) + "");
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        clear();
    }//GEN-LAST:event_addActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void netTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netTotalActionPerformed

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        total();
    }//GEN-LAST:event_discountKeyReleased

    private void paidAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyReleased
        total();

    }//GEN-LAST:event_paidAmountKeyReleased

    private void paidAmountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paidAmountMouseClicked
        new payment(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_paidAmountMouseClicked

    private void balanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_balanceKeyReleased

    }//GEN-LAST:event_balanceKeyReleased

    private void cMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cMobileActionPerformed

    private void cMobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cMobileKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cMobileKeyPressed

    private void cMobileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cMobileKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cMobileKeyReleased

    private void cMobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cMobileKeyTyped
        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM customer WHERE  mobile LIKE '%" + cMobile.getText() + "%'");
            String name = "";
            String barcode = "";
            while (rs.next()) {
                name = rs.getString("lname");

                barcode = rs.getString("customer_barcode");
                customerName.setText(name);

                cBarcode.setText(barcode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }//GEN-LAST:event_cMobileKeyTyped

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
        dtm.setRowCount(0);
    }//GEN-LAST:event_removeBtnActionPerformed

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        invoiceTable.getSelectedRow();

    }//GEN-LAST:event_invoiceTableMouseClicked

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        new businessHistory(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_historyActionPerformed

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
            java.util.logging.Logger.getLogger(addSalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addSalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addSalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addSalesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addSalesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JButton add;
    private javax.swing.JLabel addSales;
    public static javax.swing.JTextField balance;
    public static javax.swing.JTextField cBarcode;
    public static javax.swing.JTextField cMobile;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel close;
    private javax.swing.JLabel customer;
    public static javax.swing.JLabel customerName;
    private javax.swing.JLabel dashBoardMain;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel data;
    public static javax.swing.JTextField date;
    public static javax.swing.JTextField discount;
    private javax.swing.JLabel exit;
    private javax.swing.JButton history;
    private javax.swing.JLabel home;
    public static javax.swing.JTable invoiceTable;
    public static javax.swing.JTextField invoiceiID;
    private javax.swing.JLabel item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel log;
    public static javax.swing.JTextField name;
    public static javax.swing.JTextField netTotal;
    public static javax.swing.JTextField pBarcode;
    public static javax.swing.JTextField paidAmount;
    public static javax.swing.JTextField price;
    public static javax.swing.JTextField qty;
    private javax.swing.JButton removeBtn;
    private javax.swing.JLabel setting;
    private javax.swing.JLabel setting3;
    private javax.swing.JLabel staff;
    private javax.swing.JLabel suppliers;
    private javax.swing.JLabel user;
    private javax.swing.JLabel userManager;
    private javax.swing.JLabel viewsetting;
    // End of variables declaration//GEN-END:variables

    public static void invoice_save() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
            String invid = invoiceiID.getText();
            String dates = date.getText();
            String cBarcde = cBarcode.getText();
            String query = "INSERT INTO invoice(id_invoice,date_time,customer_customer_barcode) VALUES (?,?,?)";
            try {
                PreparedStatement psm = DB.dbConnection.getConnection().prepareStatement(query);
                psm.setString(1, invid);
                psm.setString(2, dates);
                psm.setString(3, cBarcde);
                psm.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

            String query2 = "SELECT id_invoice FROM invoice";
            String id = "";
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery(query2);
            while (rs.next()) {
                id = rs.getString("id_invoice");
                customerName.setText(id);
            }
            String name = "";
            String qty = "";
            String nettotal = "";
            for (int i = 0; i < dtm.getRowCount(); i++) {
                name = dtm.getValueAt(i, 0).toString();
                qty = dtm.getValueAt(i, 2).toString();
                nettotal = dtm.getValueAt(i, 3).toString();

                // DB.dbConnection.getConnection().createStatement().executeUpdate("INSERT INTO stock  qty = qty -'" + nettotal + "' WHERE id_stock = '" + stockID + "'");
                DB.dbConnection.getConnection().createStatement().executeUpdate("INSERT INTO invoice_item VALUES ('0','" + name + "','" + qty + "','" + nettotal + "','" + discount.getText() + "','" + invoiceiID.getText() + "')");
            }
            String result = updateQty(id, name, qty);
            if (!result.equals("")) {
                productUpdate(name, result);
            }
            //JOptionPane.showMessageDialog(null, "Saved !");
            GUI.AddSales.addSalesFrame.fullclear();
        } catch (Exception e) {
            //   e.printStackTrace();
            log1.debug(e.getMessage());
        }

    }

    private static void productUpdate(String name, String result) {
        String query = "update products set qty=? where name=?";
        try {
            PreparedStatement psm = DB.dbConnection.getConnection().prepareStatement(query);
            psm.setString(1, result);
            psm.setString(2, name);
            psm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String updateQty(String id, String name, String qty) {
        String msg = "";
        String query = "select * from products where name='" + name + "'";
        try {
            Statement stm = DB.dbConnection.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                String avlqty = rs.getString("qty");
                int castedavlqty = Integer.parseInt(avlqty);
                int takenQty = Integer.parseInt(qty);
                int remainingQty = castedavlqty - takenQty;
                String castedremaining = String.valueOf(remainingQty);
                msg = castedremaining;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static void saveGrnDate() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String name = dtm.getValueAt(i, 0).toString();
                String price = dtm.getValueAt(i, 1).toString();
                String q = dtm.getValueAt(i, 2).toString();
                String t = dtm.getValueAt(i, 3).toString();
                //DB.dbConnection.getConnection().createStatement().executeUpdate("INSERT INTO grn_item VALUES ('0','" + id + "','" + price + "','" + q + "','" + invoiceiID.getText() + "')");
                DB.dbConnection.getConnection().createStatement().executeUpdate("INSERT INTO grn_item VALUES ('0','" + name + "'  ,'" + price + "','" + q + "','" + t + "','" + invoiceiID.getText() + "');");
            }

            //JOptionPane.showMessageDialog(paidAmount, "Saved !");
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }

    public static void othertableLoad() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) invoiceTable.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                String id = dtm.getValueAt(i, 0).toString();
                String n = dtm.getValueAt(i, 1).toString();
                String p = dtm.getValueAt(i, 2).toString();
                String q = dtm.getValueAt(i, 3).toString();
                String t = dtm.getValueAt(i, 4).toString();

                ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT id_stock FROM stock WHERE products_product_barcode='" + id + "'");
                if (rs.next()) {
                    DB.dbConnection.getConnection().createStatement().executeUpdate("UPDATE stock SET qty = qty+'" + q + "' WHERE id_stock = '" + rs.getString("id_stock") + "'");
                } else {
                    DB.dbConnection.getConnection().createStatement().executeUpdate("INSERT INTO stock VALUES('0','" + id + "','" + p + "','" + q + "')");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }

    public static String id() {
        String i = invoiceiID.getText();
        return i;
    }

}