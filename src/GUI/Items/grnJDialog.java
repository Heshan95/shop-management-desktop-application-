/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.Date;
import java.util.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.userModel;
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
public class grnJDialog extends javax.swing.JDialog {

    /**
     * Creates new form grnJDialog
     */
    static Logger log1 = Logger.getLogger(grnJDialog.class.getName());

    Connection conn;
    private userModel um;
    DefaultTableModel userTableModel;

    public grnJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FileCombo();
        FileCombo1();
        autoId();

        invoicedDate.setDate(Date.from(Instant.now()));
        loading1.setText("0");
        freight1.setText("0");
        other1.setText("0");
        tax1.setText("0");
        discount.setText("0");
        total.setText("0");
        qty.setText("0");
        qtyPrice.setText("0");
        qtyTotal();
        total();
        total.setEditable(false);
        other1.setEditable(false);
        userTableModel = (DefaultTableModel) grnTable.getModel();
        um = new userModel();
        loadProductTable(userTableModel);
    }

    private void FileCombo() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/lakshaapplication?useSSL=false", "root", "Tc@19720228");
            String sql = "SELECT mobile,name FROM suppliers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                comboBoxName.addItem(name);
                comboBoxMobile.addItem(mobile);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }

    private void FileCombo1() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/lakshaapplication?useSSL=false", "root", "Tc@19720228");
            String sql = "SELECT * FROM company";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                comboBoxCompany.addItem(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }

    void clean() {
        autoId();
        comboBoxName.setSelectedItem(0);
        comboBoxCompany.setSelectedItem(0);
        comboBoxMobile.setSelectedItem(0);
        biilNo.setText("");
        billDate.setDate(null);
        dueDate.setDate(null);
        qty.setText("");
        itemTextArea.setText("");
        loading1.setText("0");
        freight1.setText("0");
        other1.setText("0");
        tax1.setText("0");
        discount.setText("0");
        total.setText("0");
        qty.setText("0");
        qtyPrice.setText("0");
    }

    void total() {
        double lExpences;
        double fExpences;
        double oExpences;
        double tax;
        double dcont;
        double tt;

        oExpences = Double.parseDouble(other1.getText());
        lExpences = Double.parseDouble(loading1.getText());
        fExpences = Double.parseDouble(freight1.getText());
        tax = Double.parseDouble(tax1.getText());
        dcont = Double.parseDouble(discount.getText());

        tt = lExpences + fExpences + oExpences + tax - (lExpences + fExpences + oExpences + tax) * dcont / 100;

        total.setText(Double.toString(tt));
    }

    void qtyTotal() {
        int q;
        double qp;
        double oExpences;

        q = Integer.parseInt(qty.getText());
        qp = Double.parseDouble(qtyPrice.getText());

        oExpences = q * qp;

        other1.setText(Double.toString(oExpences));
    }

    void loadProductTable(DefaultTableModel dtm) {
        try {
            dtm.setRowCount(0);
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT * FROM grn");
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("invoice_no"));
                v.add(rs.getString("company"));
                v.add(rs.getString("suppliers_mobile"));
                v.add(rs.getString("date"));
                v.add(rs.getString("bill_no"));
                v.add(rs.getString("s_name"));
                v.add(rs.getString("biil_date"));
                v.add(rs.getString("due_date"));
                v.add(rs.getString("item"));
                v.add(rs.getString("qty"));
                v.add(rs.getString("other_expences"));
                v.add(rs.getString("qty_price"));
                v.add(rs.getString("id_grn"));
                v.add(rs.getString("loading_expences"));
                v.add(rs.getString("freight_expences"));
                v.add(rs.getString("method"));
                v.add(rs.getString("discount"));
                v.add(rs.getString("tax"));
                v.add(rs.getString("total"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }

    private void autoId() {
        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery("SELECT id_grn FROM grn ORDER BY id_grn DESC LIMIT 1");
            if (rs.next()) {
                String rnno = rs.getString("id_grn");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                invoiceNo1.setText(ftxt);

            } else {
                invoiceNo1.setText("1111");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        biilNo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cashRadioBtn = new javax.swing.JRadioButton();
        creditRadioBtn = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTextArea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        invoiceNo1 = new javax.swing.JTextField();
        loading1 = new javax.swing.JTextField();
        freight1 = new javax.swing.JTextField();
        other1 = new javax.swing.JTextField();
        tax1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        grnTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        updateBtn = new javax.swing.JButton();
        updateBtn1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        comboBoxCompany = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        comboBoxMobile = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        qtyPrice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cleanBtn = new javax.swing.JButton();
        invoicedDate = new com.toedter.calendar.JDateChooser();
        dueDate = new com.toedter.calendar.JDateChooser();
        billDate = new com.toedter.calendar.JDateChooser();
        grn_full_report = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("G R N");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Please fill in following below.");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel1.setText("GRN Details here");

        jLabel2.setText("Supplier Name");

        comboBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Date");

        jLabel4.setText("Bill No");

        biilNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biilNoActionPerformed(evt);
            }
        });
        biilNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                biilNoKeyTyped(evt);
            }
        });

        jLabel5.setText("Bill Date");

        jLabel6.setText("Due Date");

        jLabel7.setText("Payment Method");

        buttonGroup1.add(cashRadioBtn);
        cashRadioBtn.setSelected(true);
        cashRadioBtn.setText("Cash");
        cashRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(creditRadioBtn);
        creditRadioBtn.setText("Credit");

        jLabel8.setText("Item");

        itemTextArea.setColumns(20);
        itemTextArea.setRows(5);
        jScrollPane1.setViewportView(itemTextArea);

        jLabel9.setText("Invoice No");

        jLabel10.setText("Loading Expence");

        jLabel12.setText("Discount");

        jLabel13.setText("Freight Expence");

        jLabel14.setText("Qty Total Price");

        jLabel15.setText("Tax");

        discount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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

        invoiceNo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invoiceNo1KeyTyped(evt);
            }
        });

        loading1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        loading1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loading1ActionPerformed(evt);
            }
        });
        loading1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loading1KeyReleased(evt);
            }
        });

        freight1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        freight1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freight1ActionPerformed(evt);
            }
        });
        freight1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                freight1KeyReleased(evt);
            }
        });

        other1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        other1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                other1ActionPerformed(evt);
            }
        });
        other1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                other1KeyReleased(evt);
            }
        });

        tax1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tax1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tax1ActionPerformed(evt);
            }
        });
        tax1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tax1KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel16.setText("Total");

        total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        grnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice No", "company", "S-Mobile", "Date", "Bill no", "Supplier", "Billing Date", "Due Date", "Item", "Qty", "q total", "q_price", "ID", "lexpense", "fexpense", "Payment Method", "discount", "tax", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grnTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(grnTable);
        if (grnTable.getColumnModel().getColumnCount() > 0) {
            grnTable.getColumnModel().getColumn(0).setMinWidth(80);
            grnTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            grnTable.getColumnModel().getColumn(0).setMaxWidth(80);
            grnTable.getColumnModel().getColumn(1).setMinWidth(0);
            grnTable.getColumnModel().getColumn(1).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(1).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(2).setMinWidth(0);
            grnTable.getColumnModel().getColumn(2).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(2).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(3).setMinWidth(0);
            grnTable.getColumnModel().getColumn(3).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(3).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(4).setMinWidth(0);
            grnTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(4).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(5).setMinWidth(90);
            grnTable.getColumnModel().getColumn(5).setPreferredWidth(90);
            grnTable.getColumnModel().getColumn(5).setMaxWidth(90);
            grnTable.getColumnModel().getColumn(6).setMinWidth(120);
            grnTable.getColumnModel().getColumn(6).setPreferredWidth(120);
            grnTable.getColumnModel().getColumn(6).setMaxWidth(120);
            grnTable.getColumnModel().getColumn(7).setMinWidth(100);
            grnTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            grnTable.getColumnModel().getColumn(7).setMaxWidth(100);
            grnTable.getColumnModel().getColumn(8).setMinWidth(200);
            grnTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            grnTable.getColumnModel().getColumn(8).setMaxWidth(200);
            grnTable.getColumnModel().getColumn(9).setMinWidth(40);
            grnTable.getColumnModel().getColumn(9).setPreferredWidth(40);
            grnTable.getColumnModel().getColumn(9).setMaxWidth(40);
            grnTable.getColumnModel().getColumn(10).setMinWidth(0);
            grnTable.getColumnModel().getColumn(10).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(10).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(11).setMinWidth(0);
            grnTable.getColumnModel().getColumn(11).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(11).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(12).setMinWidth(0);
            grnTable.getColumnModel().getColumn(12).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(12).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(13).setMinWidth(0);
            grnTable.getColumnModel().getColumn(13).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(13).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(14).setMinWidth(0);
            grnTable.getColumnModel().getColumn(14).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(14).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(15).setMinWidth(100);
            grnTable.getColumnModel().getColumn(15).setPreferredWidth(100);
            grnTable.getColumnModel().getColumn(15).setMaxWidth(100);
            grnTable.getColumnModel().getColumn(16).setMinWidth(0);
            grnTable.getColumnModel().getColumn(16).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(16).setMaxWidth(0);
            grnTable.getColumnModel().getColumn(17).setMinWidth(0);
            grnTable.getColumnModel().getColumn(17).setPreferredWidth(0);
            grnTable.getColumnModel().getColumn(17).setMaxWidth(0);
        }

        addBtn.setBackground(new java.awt.Color(0, 51, 51));
        addBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus (2).png"))); // NOI18N
        addBtn.setText("Add Details");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        addBtn.setContentAreaFilled(false);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setOpaque(true);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 51, 51));
        updateBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Details");
        updateBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        updateBtn.setContentAreaFilled(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.setOpaque(true);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        updateBtn1.setBackground(new java.awt.Color(0, 51, 51));
        updateBtn1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        updateBtn1.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn1.setText("Print");
        updateBtn1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        updateBtn1.setContentAreaFilled(false);
        updateBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn1.setOpaque(true);
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Qty");

        qty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });

        jLabel18.setText("Company");

        jLabel19.setText("Supplier Mobile");

        jLabel20.setText("Qty Price");

        qtyPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        qtyPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyPriceActionPerformed(evt);
            }
        });
        qtyPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyPriceKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel21.setText("(Buying Price)");

        cleanBtn.setBackground(new java.awt.Color(0, 51, 51));
        cleanBtn.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        cleanBtn.setForeground(new java.awt.Color(255, 255, 255));
        cleanBtn.setText("Clean");
        cleanBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        cleanBtn.setContentAreaFilled(false);
        cleanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cleanBtn.setOpaque(true);
        cleanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanBtnActionPerformed(evt);
            }
        });

        invoicedDate.setEnabled(false);

        grn_full_report.setBackground(new java.awt.Color(0, 51, 51));
        grn_full_report.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        grn_full_report.setForeground(new java.awt.Color(255, 255, 255));
        grn_full_report.setText("GRN Avilable Stock Report");
        grn_full_report.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
        grn_full_report.setContentAreaFilled(false);
        grn_full_report.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grn_full_report.setOpaque(true);
        grn_full_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grn_full_reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(updateBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cleanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(grn_full_report, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(545, 545, 545)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(other1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6)
                                .addGap(283, 283, 283)
                                .addComponent(jLabel9)
                                .addGap(49, 49, 49)
                                .addComponent(invoiceNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addContainerGap(707, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxCompany, 0, 173, Short.MAX_VALUE)
                                    .addComponent(invoicedDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(billDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel16))
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel17))
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cashRadioBtn)
                                                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel21))
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(creditRadioBtn)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(16, 16, 16)
                                                        .addComponent(qtyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel14))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel10)
                                                            .addComponent(jLabel13)))))
                                            .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(biilNo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loading1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(freight1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tax1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel11)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(comboBoxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel6))
                        .addComponent(jLabel9)
                        .addComponent(invoiceNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel18)
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel19)
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(cashRadioBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel20)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel21))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(creditRadioBtn)
                                                .addGap(19, 19, 19)
                                                .addComponent(qtyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(other1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(loading1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(freight1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(tax1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel8))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(invoicedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(biilNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(billDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn1)
                            .addComponent(addBtn)
                            .addComponent(cleanBtn)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(comboBoxCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(comboBoxMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(grn_full_report))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cashRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashRadioBtnActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void tax1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tax1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tax1ActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String id = invoiceNo1.getText();
        String sName = comboBoxName.getSelectedItem().toString();
        String Company = comboBoxCompany.getSelectedItem().toString();
        String sMobile = comboBoxMobile.getSelectedItem().toString();
        Date d1 = invoicedDate.getDate();
        String bNo = biilNo.getText();
        Date d2 = billDate.getDate();
        Date d3 = dueDate.getDate();
        double qPrice = Double.parseDouble(qtyPrice.getText());
        double lExpences = Double.parseDouble(loading1.getText());
        double fExpences = Double.parseDouble(freight1.getText());
        double oExpences = Double.parseDouble(other1.getText());
        double tax = Double.parseDouble(tax1.getText());
        double dcont = Double.parseDouble(discount.getText());
        double t = Double.parseDouble(total.getText());
        String item = itemTextArea.getText();
        String iNO = invoiceNo1.getText();

        String item1 = itemTextArea.getText();
        double qPrice1 = Double.parseDouble(qtyPrice.getText());
        String q1 = qty.getText();
        String iNO1 = invoiceNo1.getText();
        boolean method = cashRadioBtn.isSelected();
        String q = qty.getText();

        if (q.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill amount of Qty");
            return;
        }

        // DB.dbConnection.getConnection().createStatement().execute("INSERT INTO grn_item Value('0','" + itemTextArea.getText() + "','" + qtyPrice.getText() + "','" + qty.getText() + "','" + invoiceNo1.getText() + "')");
        String resrultGrn = um.insertGrn(id, sName, Company, sMobile, d1, bNo, d2, d3, method, q, qPrice, item, iNO, lExpences, fExpences, oExpences, tax, dcont, t);
        String resrultGrn_item = um.insertGrn(item1, qPrice1, q1, iNO1);
        JOptionPane.showConfirmDialog(rootPane, resrultGrn, "", 0, 1);
        clean();
        loadProductTable(userTableModel);


    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        String sName = comboBoxName.getSelectedItem().toString();
        String Company = comboBoxCompany.getSelectedItem().toString();
        String sMobile = comboBoxMobile.getSelectedItem().toString();
        Date d1 = invoicedDate.getDate();
        String bNo = biilNo.getText();
        Date d2 = billDate.getDate();
        Date d3 = dueDate.getDate();
        boolean method = cashRadioBtn.isSelected();
        String q = qty.getText();
        double qPrice = Double.parseDouble(qtyPrice.getText());
        String item = itemTextArea.getText();
        String iNO = invoiceNo1.getText();
        double lExpences = Double.parseDouble(loading1.getText());
        double fExpences = Double.parseDouble(freight1.getText());
        double oExpences = Double.parseDouble(other1.getText());
        double tax = Double.parseDouble(tax1.getText());
        double dcont = Double.parseDouble(discount.getText());
        double t = Double.parseDouble(total.getText());
        String id = invoiceNo1.getText();

        String resrultGrn = um.updateGrn(id, sName, Company, sMobile, d1, bNo, d2, d3, method, q, qPrice, item, iNO, lExpences, fExpences, oExpences, tax, dcont, t);
        um.loadTable("", 0, userTableModel);
        JOptionPane.showConfirmDialog(rootPane, resrultGrn, "Message !", -1, 1);
        clean();
        loadProductTable(userTableModel);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        
        int row=grnTable.getSelectedRow();
        Object o1 = grnTable.getValueAt(row, 0);
        String grqnID= String.valueOf(o1);
        
       
        String reportPath = "C:\\Users\\kulas\\JaspersoftWorkspace\\MyReports\\GRN_invoice.jrxml";
        Map m = new HashMap();
        m.put("grnNo",  grqnID);

        try {

            JasperReport jc = JasperCompileManager.compileReport(reportPath);

            JasperPrint jp = JasperFillManager.fillReport(jc, m, DB.dbConnection.getConnection());
             this.dispose();
            JRViewer jv = new JRViewer(jp);
            GUI.AddSales.report gu = new GUI.AddSales.report();
            gu.tabbedPane.add(jv);
         //   System.out.println("ok");
            gu.setVisible(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_updateBtn1ActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void loading1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loading1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loading1ActionPerformed

    private void biilNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biilNoActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_biilNoActionPerformed

    private void other1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_other1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_other1ActionPerformed

    private void biilNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_biilNoKeyTyped
        if ("".equals(biilNo.getText())) {

        }

    }//GEN-LAST:event_biilNoKeyTyped

    private void invoiceNo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoiceNo1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_invoiceNo1KeyTyped

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void loading1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loading1KeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_loading1KeyReleased

    private void freight1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_freight1KeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_freight1KeyReleased

    private void other1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_other1KeyReleased
        // TODO add your handling code here
        total();
    }//GEN-LAST:event_other1KeyReleased

    private void tax1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tax1KeyReleased
        total();
    }//GEN-LAST:event_tax1KeyReleased

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_discountKeyReleased

    private void qtyPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyPriceActionPerformed

    private void freight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freight1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_freight1ActionPerformed

    private void qtyPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyPriceKeyReleased
        // TODO add your handling code here:
        qtyTotal();
        total();
    }//GEN-LAST:event_qtyPriceKeyReleased

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        // TODO add your handling code here:
        qtyTotal();
        total();
    }//GEN-LAST:event_qtyKeyReleased

    private void grnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grnTableMouseClicked

        try {
            DefaultTableModel dtm = (DefaultTableModel) grnTable.getModel();
            invoiceNo1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 0).toString());
            comboBoxCompany.setSelectedItem(dtm.getValueAt(grnTable.getSelectedRow(), 1).toString());
            comboBoxMobile.setSelectedItem(dtm.getValueAt(grnTable.getSelectedRow(), 2).toString());
            invoicedDate.setDateFormatString(dtm.getValueAt(grnTable.getSelectedRow(), 3).toString());
            biilNo.setText(dtm.getValueAt(grnTable.getSelectedRow(), 4).toString());
            comboBoxName.setSelectedItem(dtm.getValueAt(grnTable.getSelectedRow(), 5).toString());
            billDate.setDateFormatString(dtm.getValueAt(grnTable.getSelectedRow(), 6).toString());
            dueDate.setDateFormatString(dtm.getValueAt(grnTable.getSelectedRow(), 7).toString());
            //  System.out.println("biil date" + dtm.getValueAt(grnTable.getSelectedRow(), 6).toString());
            //   System.out.println("due date" + dtm.getValueAt(grnTable.getSelectedRow(), 7).toString());
            itemTextArea.setText(dtm.getValueAt(grnTable.getSelectedRow(), 8).toString());
            qty.setText(dtm.getValueAt(grnTable.getSelectedRow(), 9).toString());
            other1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 10).toString());
            qtyPrice.setText(dtm.getValueAt(grnTable.getSelectedRow(), 11).toString());
            invoiceNo1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 12).toString());
            loading1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 13).toString());
            freight1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 14).toString());
            // cashRadioBtn.setSelected((boolean) dtm.getValueAt(grnTable.getSelectedColumn(), 15));
            // creditRadioBtn.setSelected(!(boolean) dtm.getValueAt(grnTable.getSelectedColumn(), 15));
            discount.setText(dtm.getValueAt(grnTable.getSelectedRow(), 16).toString());
            tax1.setText(dtm.getValueAt(grnTable.getSelectedRow(), 17).toString());
            total.setText(dtm.getValueAt(grnTable.getSelectedRow(), 18).toString());

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
    }//GEN-LAST:event_grnTableMouseClicked

    private void cleanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanBtnActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_cleanBtnActionPerformed

    private void grn_full_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grn_full_reportActionPerformed
        this.dispose();
        String reportPath = "C:\\Users\\kulas\\JaspersoftWorkspace\\MyReports\\GRN.jrxml";
        Map m = new HashMap();
        //        m.put("Date", new Date(System.currentTimeMillis()));
        try {

            JasperReport jc = JasperCompileManager.compileReport(reportPath);

            JasperPrint jp = JasperFillManager.fillReport(jc, m, DB.dbConnection.getConnection());
            JRViewer jv = new JRViewer(jp);
            GUI.AddSales.report gu = new GUI.AddSales.report();
            gu.tabbedPane.add(jv);
            //System.out.println("ok");
            gu.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_grn_full_reportActionPerformed

    private void comboBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxNameActionPerformed

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
            java.util.logging.Logger.getLogger(grnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                grnJDialog dialog = new grnJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField biilNo;
    private com.toedter.calendar.JDateChooser billDate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cashRadioBtn;
    private javax.swing.JButton cleanBtn;
    private javax.swing.JComboBox comboBoxCompany;
    private javax.swing.JComboBox comboBoxMobile;
    private javax.swing.JComboBox comboBoxName;
    private javax.swing.JRadioButton creditRadioBtn;
    private javax.swing.JTextField discount;
    private com.toedter.calendar.JDateChooser dueDate;
    private javax.swing.JTextField freight1;
    private javax.swing.JTable grnTable;
    private javax.swing.JButton grn_full_report;
    private javax.swing.JTextField invoiceNo1;
    private com.toedter.calendar.JDateChooser invoicedDate;
    private javax.swing.JTextArea itemTextArea;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField loading1;
    private javax.swing.JTextField other1;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField qtyPrice;
    private javax.swing.JTextField tax1;
    private javax.swing.JTextField total;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    // End of variables declaration//GEN-END:variables
}
