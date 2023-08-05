/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author kulas
 */
public class userModel {

    Connection conn;
    double dtotal;
    static Logger log1 = Logger.getLogger(userModel.class.getName());

    public userModel() {
        conn = DB.dbConnection.getConnection();
    }
    public String login(String combo, String username, String password) {
        String msg = "";
        String query = "SELECT * FROM user WHERE status = ? AND un =? AND pw =?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, combo);
            ps.setString(2, username);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            String name = "";
            String pw = "";
            while (rs.next()) {
                name = rs.getString("un");
                pw = rs.getString("pw");
            }
            if (name.equals("") && pw.equals("")) {
                msg = "Invalide Username or Password";
                log1.debug(msg);
            } else {
                msg = pw;
                // msg = "Welcome," + " " + name + " " + "Have a nice day..!!! ";

            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
            msg = "error" + e.getMessage();
        }
        return msg;
    }

    public String insertStaff(String barcode, String job, String first_name, String last_name, String intial, String mail, String a1, String a2, String id, String phone, double income, String status) {
        String msg = null;
        String castedIncome=String.valueOf(income);
        String query = "INSERT INTO staff(id_staff,job_role,fname,lname,n_initials,email,address1,address2,nic,mobile,salary,status)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barcode);
            ps.setString(2, job);
            ps.setString(3, first_name);
            ps.setString(4, last_name);
            ps.setString(5, intial);
            ps.setString(6, mail);
            ps.setString(7, a1);
            ps.setString(8, a2);
            ps.setString(9, id);
            ps.setString(10, phone);
            ps.setString(11, castedIncome);
            ps.setString(12, status);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;

    }

    public String insertCustomer(String barcode, String first_name, String last_name, String mail, String id, String phone, String a1, String a2, String c, String note) {
        String msg = null;
        String query = "INSERT INTO customer(customer_barcode,fname,lname,email,nic,mobile,address1,address2,city,note)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barcode);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            ps.setString(4, mail);
            ps.setString(5, id);
            ps.setString(6, phone);
            ps.setString(7, a1);
            ps.setString(8, a2);
            ps.setString(9, c);
            ps.setString(10, note);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            
            msg = "Ooops !!! Something Wrong ! ";
            log1.debug(e.getMessage());
        }

        return msg;

    }

    public String insertProducts(String barcode, String pCategory, String item_name, String description, double unitP, String qt) {
        String msg = null;
        String query = "UPDATE products set category=?,name=?,description=?,selling_price=?,qty=? where product_barcode=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pCategory);
            ps.setString(2, item_name);
            ps.setString(3, description);
            ps.setDouble(4, unitP);
            ps.setString(5, qt);
            ps.setString(6, barcode);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String insertCompany(String i, String name, String address) {
        String msg = null;
        String query = "INSERT INTO company(id_company,name,address) VALUES (?,?,?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, i);
            ps.setString(2, name);
            ps.setString(3, address);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String insertSupplier(String phone, String supplierName, String mail, String company) {
        String msg = null;
        String query = "INSERT INTO suppliers(mobile,company_id_company,name,email)VALUES(?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, phone);
            ps.setString(2, company);
            ps.setString(3, supplierName);
            ps.setString(4, mail);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String insertGrn(String id, String sName, String Company, String sMobile, Date d1, String bNo, Date d2, Date d3, boolean method, String q, double qPrice, String item, String iNO, double lExpences, double fExpences, double oExpences, double tax, double dcont, double t) {
        String msg = null;
        String query = "INSERT INTO `grn`(`id_grn`,`s_name`,`company`,`suppliers_mobile`,`date`,`bill_no`,`biil_date`,`due_date`,`method`,`qty`,`qty_price`,`item`,`invoice_no`,`loading_expences`,`freight_expences`,`other_expences`,`tax`,`discount`,`total`)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, sName);
            ps.setString(3, Company);
            ps.setString(4, sMobile);
            ps.setDate(5, new java.sql.Date(d1.getTime()));
            ps.setString(6, bNo);
            ps.setDate(7, new java.sql.Date(d2.getTime()));
            ps.setDate(8, new java.sql.Date(d3.getTime()));
            ps.setBoolean(9, method);
            ps.setString(10, q);
            ps.setDouble(11, qPrice);
            ps.setString(12, item);
            ps.setString(13, iNO);
            ps.setDouble(14, lExpences);
            ps.setDouble(15, fExpences);
            ps.setDouble(16, oExpences);
            ps.setDouble(17, tax);
            ps.setDouble(18, dcont);
            ps.setDouble(19, t);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;

    }

//    public String updateQty(String qtUpdate, String barcodeUpdate) {
//        String msg = null;
//        String query = "UPDATE lakshaapplication.grn SET qty = qty-(lakshaapplication.products.qty) WHERE product_barcode = ?";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, qtUpdate);
//            ps.setString(2, barcodeUpdate);
//            ps.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return msg;
//    }
    public void loadTable(String keyword, int categoryId, DefaultTableModel userTableModel) {
        String loadDateByAll = "SELECT * FROM customer WHERE '" + keyword + "' like ? ";
        String loadDataByMobile = "SELECT * FROM customer WHERE mobile like ? ";
        String loadDataByCity = "SELECT * FROM customer WHERE city like ? ";

        String runningQuery = null;

        if (categoryId == 0) {
            runningQuery = loadDateByAll;
        } else if (categoryId == 1) {
            runningQuery = loadDataByMobile;
        } else if (categoryId == 2) {
            runningQuery = loadDataByCity;
        }

        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            userTableModel.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("customer_barcode");
                String fn = rs.getString("fname");
                String ln = rs.getString("lname");
                String e = rs.getString("email");
                String nc = rs.getString("nic");
                String m = rs.getString("mobile");
                String a1 = rs.getString("address1");
                String a2 = rs.getString("address2");
                String c = rs.getString("city");
                String status = rs.getString("note");

                rowData = new Object[]{id, fn, ln, e, nc, m, a1, a2, c, status};
                userTableModel.addRow(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }

    }

    public String updateUser(String barcode, String first_name, String last_name, String mail, String id, String phone, String a1, String a2, String c, String note) {
        String msg = "";
        String query = "UPDATE customer SET fname=?, lname=?, email=?, nic=?, mobile=?, address1=?, address2=?, city=?, note=? WHERE customer_barcode = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ps.setString(3, mail);
            ps.setString(4, id);
            ps.setString(5, phone);
            ps.setString(6, a1);
            ps.setString(7, a2);
            ps.setString(8, c);
            ps.setString(9, note);
            ps.setString(10, barcode);
            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String updateSfatt(String barcode, String job, String first_name, String last_name, String intial, String mail, String a1, String a2, String id, String phone, double income, String status) {
        String msg = "";
        String query = "UPDATE staff SET job_role=?, fname=?, lname=?, n_initials=?, email=?, address1=?, address2=?, nic=?, mobile=?, salary=?, status=? WHERE id_staff = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, job);
            ps.setString(2, first_name);
            ps.setString(3, last_name);
            ps.setString(4, intial);
            ps.setString(5, mail);
            ps.setString(6, a1);
            ps.setString(7, a2);
            ps.setString(8, id);
            ps.setString(9, phone);
            ps.setDouble(10, income);
            ps.setString(11, status);
            ps.setString(12, barcode);
            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String updateCompany(String n, String address, String i) {
        String msg = "";
        String query = "UPDATE company SET name = ?, address = ? WHERE id_company = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, n);
            ps.setString(2, address);
            ps.setString(3, i);
            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;

    }

    public String updateSupplier(String phone, String c, String supplierName, String mail) {
        String msg = "";
        String query = "UPDATE suppliers SET company_id_company = ?, name = ?, email = ?  WHERE mobile = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, c);
            ps.setString(2, supplierName);
            ps.setString(3, mail);
            ps.setString(4, phone);
            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String updateGrn(String id, String sName, String Company, String sMobile, Date d1, String bNo, Date d2, Date d3, boolean method, String q, double qPrice, String item, String iNO, double lExpences, double fExpences, double oExpences, double tax, double dcont, double t) {
        String msg = "";
        String query = "UPDATE grn SET  s_name=?, company=?,suppliers_mobile=?, date=?, bill_no=?, biil_date=?, due_date=?, method=?, qty=?, qty_price=?, item=?, invoice_no=?, loading_expences=?, freight_expences=?, other_expences=?, tax=?, discount=?, total=?  WHERE id_grn = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, sName);
            ps.setString(2, Company);
            ps.setString(3, sMobile);
            ps.setDate(4, new java.sql.Date(d1.getTime()));
            ps.setString(5, bNo);
            ps.setDate(6, new java.sql.Date(d2.getTime()));
            ps.setDate(7, new java.sql.Date(d3.getTime()));
            ps.setBoolean(8, method);
            ps.setString(9, q);
            ps.setDouble(10, qPrice);
            ps.setString(11, item);
            ps.setString(12, iNO);
            ps.setDouble(13, lExpences);
            ps.setDouble(14, fExpences);
            ps.setDouble(15, oExpences);
            ps.setDouble(16, tax);
            ps.setDouble(17, dcont);
            ps.setDouble(18, t);
            ps.setString(19, id);
            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;

    }

    public void loadItemTable(String keyword, int categoryId, DefaultTableModel userTableModel) {
        String loadByAll = "SELECT * FROM products WHERE '" + keyword + "' like ? ";
        String loadByBarcode = "SELECT * FROM products WHERE product_barcode like ? ";
        String loadByCategory = "SELECT * FROM products WHERE category like ? ";

        String runningQuery = null;

        if (categoryId == 0) {
            runningQuery = loadByAll;
        } else if (categoryId == 1) {
            runningQuery = loadByBarcode;
        } else if (categoryId == 2) {
            runningQuery = loadByCategory;
        }

        try {
            PreparedStatement ps = conn.prepareStatement(runningQuery);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            Object[] rowData;
            userTableModel.setRowCount(0);

            while (rs.next()) {
                String id = rs.getString("product_barcode");
                String c = rs.getString("category");
                String n = rs.getString("name");
                // String d = rs.getString("description");
                String s = rs.getString("selling_price");
                String q = rs.getString("qty");

                rowData = new Object[]{id, c, n, s, q};
                userTableModel.addRow(rowData);
            }

        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }

    }

    public String insertUser(String u, String job, String password1) {
        String msg = "";
        String query = "INSERT INTO user(status, un, pw) VALUES (?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, job);
            ps.setString(2, u);
            ps.setString(3, password1);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String updateUser(String i, String u, String job, String password1) {
        String msg = "";
        String query = "UPDATE user SET status=?, un=?, pw = ? WHERE user_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, job);
            ps.setString(2, u);
            ps.setString(3, password1);
            ps.setString(4, i);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;

    }

    public String selectAttendance(Date d, String barcode) {
        String msg = "";
        String q = "SELECT * FROM reporting_to_work WHERE `date`=CURDATE() AND staff_id_staff='"+barcode+"'";
        try {
            Statement s1 = conn.createStatement();
            ResultSet rs = s1.executeQuery(q);
            while (rs.next()) {
                msg = "have";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg="no";
        }
       return msg;
    }

    public String insertUser(Date d, String barcode) {
        String msg = "";
        String query = "INSERT INTO reporting_to_work (date, on_time,off_time, status, staff_id_staff) VALUES (?,CURRENT_TIME,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(d.getTime()));
            ps.setString(2, null);
            ps.setString(3, "Absent");
            ps.setString(4, barcode);

            ps.execute();

//                Thread.sleep(2000);
            msg = "done";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "error" + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public String att_off(String barcode) {
        String msg = "";
        String qq1 = "UPDATE reporting_to_work SET off_time = CURRENT_TIME  WHERE staff_id_staff = ?";
        try {
            PreparedStatement ps1 = conn.prepareStatement(qq1);
            ps1.setString(1, barcode);
            ps1.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        String qq = "SELECT ROUND(TIMESTAMPDIFF(minute,`on_time`,`off_time`)/60,2) AS FractHours FROM reporting_to_work WHERE  staff_id_staff = '" + barcode + "' AND reporting_to_work.`date` = CURDATE()";

        try {

            PreparedStatement ps = conn.prepareStatement(qq);

            // ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Double timeDiff = Double.parseDouble(rs.getString("FractHours"));
                if (timeDiff < 4) {
                    String query = "UPDATE reporting_to_work SET status='Absent' WHERE staff_id_staff = ?";
                    try {
                        PreparedStatement psm2 = conn.prepareStatement(query);
                        psm2.setString(1, barcode);
                        psm2.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else if (timeDiff == 4) {
                    String query = "UPDATE reporting_to_work SET status='Short Leave' WHERE staff_id_staff = ?";
                    try {
                        PreparedStatement psm2 = conn.prepareStatement(query);
                        psm2.setString(1, barcode);
                        psm2.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (timeDiff >= 8) {
                    String query = "UPDATE reporting_to_work SET status='Present' WHERE staff_id_staff = ?";
                    try {
                        PreparedStatement psm2 = conn.prepareStatement(query);
                        psm2.setString(1, barcode);
                        psm2.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            msg = "Noted Successfuly! You can leave now..";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }
        return msg;
    }

//    public void loadAttendanceTable(int employe, int staus, DefaultTableModel userTableModel) {
//        String loadByAll = "SELECT id_staff FROM staff WHERE job_role = '(SELECT * FROM reporting_to_work WHERE staff_id_staff = ?)'";
//        String loadByAdmin = "SELECT id_staff FROM staff WHERE job_role = '(SELECT * FROM reporting_to_work WHERE staff_id_staff = ?)' ";
//        String loadByManager = "SELECT id_staff FROM staff WHERE job_role = '(SELECT * FROM reporting_to_work WHERE staff_id_staff = ?)' ";
//        String loadByCashier1 = "SELECT id_staff FROM staff WHERE job_role = '(SELECT * FROM reporting_to_work WHERE staff_id_staff = ?)' ";
//        String loadByCashier2 = "SELECT id_staff FROM staff WHERE job_role = '(SELECT * FROM reporting_to_work WHERE staff_id_staff = ?)' ";
//
//        String runningQuery1 = null;
//
//        if (employe == 0) {
//            runningQuery1 = loadByAll;
//        } else if (employe == 1) {
//            runningQuery1 = loadByAdmin;
//        } else if (employe == 2) {
//            runningQuery1 = loadByManager;
//        } else if (employe == 3) {
//            runningQuery1 = loadByCashier1;
//        } else if (employe == 4) {
//            runningQuery1 = loadByCashier2;
//        }
//        try {
//            PreparedStatement ps = conn.prepareStatement(runningQuery1);
//            ResultSet rs = ps.executeQuery();
//            Object[] rowData;
//            userTableModel.setRowCount(0);
//
//            while (rs.next()) {
//                String d = rs.getString("date");
//                String ot = rs.getString("on_time");
//                String ft = rs.getString("off_time");
//                // String d = rs.getString("description");
//                String s = rs.getString("status");
//                String id = rs.getString("staff_id_staff");
//
//                rowData = new Object[]{d, ot, ft, s, id};
//                userTableModel.addRow(rowData);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            log1.debug(e.getMessage());
//        }
//
//        String statusByAll = "SELECT * FROM reporting_to_work  ";
//        String statusByPresent = "SELECT * FROM reporting_to_work WHERE `status` = 'Present'";
//        String statusByAbsent = "SELECT * FROM reporting_to_work WHERE `status` = null ? ";
//
//        String runningQuery2 = null;
//
//        if (staus == 0) {
//            runningQuery2 = statusByAll;
//        } else if (staus == 1) {
//            runningQuery2 = statusByPresent;
//        } else if (staus == 2) {
//            runningQuery2 = statusByAbsent;
//        }
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(runningQuery2);
//            ResultSet rs = ps.executeQuery();
//            Object[] rowData;
//            userTableModel.setRowCount(0);
//
//            while (rs.next()) {
//                String d = rs.getString("date");
//                String ot = rs.getString("on_time");
//                String ft = rs.getString("off_time");
//                // String d = rs.getString("description");
//                String s = rs.getString("status");
//                String id = rs.getString("staff_id_staff");
//
//                rowData = new Object[]{d, ot, ft, s, id};
//                userTableModel.addRow(rowData);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            log1.debug(e.getMessage());
//        }
//
//    }
    public String insertGrn(String item1, double qPrice1, String q1, String iNO1) {
        String msg = "";
        String query = "INSERT INTO grn_item (id, name, buying_price, qty, grn_id_grn) VALUES('0',?,?,?,?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, item1);
            ps.setDouble(2, qPrice1);
            ps.setString(3, q1);
            ps.setString(4, iNO1);
            ps.execute();
            msg = "";
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        return msg;
    }

//    public String insertProducts(String pd, double buyingPrice, double sellingPrice, String qt1) {
//        
//    }
    public String insertStock(String pd, double buyingPrice, double sellingPrice, String qt1) {
        String msg = "";
        String query = "INSERT INTO stock (id_stock, products_product_barcode, `b.price`, `s.price`, qty) VALUES('0',?,?,?,?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pd);
            ps.setDouble(2, buyingPrice);
            ps.setDouble(3, sellingPrice);
            ps.setString(4, qt1);
            ps.execute();
            msg = "";
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        return msg;
    }

    public String updateItem(String barcode, String category, String n, String tArea, double u, String q) {
        String msg = "";
        String query = "UPDATE products SET category=?, name=?, description=?, selling_price=?, qty=?WHERE product_barcode = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, category);
            ps.setString(2, n);
            ps.setString(3, tArea);
            ps.setDouble(4, u);
            ps.setString(5, q);

            ps.setString(6, barcode);

            ps.execute();
            msg = "Do you want to Update that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }

        return msg;
    }

    public void loadallEployeeAttenndance(int employe, int staus, DefaultTableModel userTableModel) {
        String status = "";
        if (staus == 1) {
            status = "Present";
        } else if (staus == 2) {
            status = "Absent";
        }
        String q = "SELECT * FROM reporting_to_work WHERE reporting_to_work.status LIKE '%" + status + "%'";

        userTableModel.setRowCount(0);
        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery(q);
            while (rs.next()) {
                Vector v = new Vector();
//                v.add(rs.getString("id"));
                v.add(rs.getString("date"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));
                v.add(rs.getString("status"));
                v.add(rs.getString("staff_id_staff"));
                userTableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadallManagerAttenndance(int employe, int staus, DefaultTableModel userTableModel) {
        String status = "";
        if (staus == 1) {
            status = "Present";
        } else if (staus == 2) {
            status = "Absent";
        }
        System.out.println(status);
        String job = "";
        if (employe == 1) {
            job = "Admin";
        } else if (employe == 2) {
            job = "Manager";
        } else if (employe == 3) {
            job = "Cashier";
        } else if (employe == 4) {
            job = "Cashier";
        }
        System.out.println(job);
        String q = "SELECT * FROM reporting_to_work join staff on reporting_to_work.staff_id_staff=staff.id_staff WHERE staff.job_role = '" + job + "' AND reporting_to_work.status = '" + status + "'";

        userTableModel.setRowCount(0);
        try {
            ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery(q);
            while (rs.next()) {
                Vector v = new Vector();
//                v.add(rs.getString("id"));
                v.add(rs.getString("date"));
                v.add(rs.getString("on_time"));
                v.add(rs.getString("off_time"));
                v.add(rs.getString("status"));
                v.add(rs.getString("staff_id_staff"));
                userTableModel.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void daterange(Date d1, Date d2, DefaultTableModel userTableModel) {

        Date d11 = new java.sql.Date(d1.getTime());
        Date d22 = new java.sql.Date(d2.getTime());
        String query = "SELECT * FROM reporting_to_work join staff on reporting_to_work.staff_id_staff=staff.id_staff WHERE date BETWEEN '" + d11 + "' AND '" + d22 + "' ";

        try {
            userTableModel.setRowCount(0);
            try {
                ResultSet rs = DB.dbConnection.getConnection().createStatement().executeQuery(query);
                while (rs.next()) {
                    Vector v = new Vector();
//                v.add(rs.getString("id"));
                    v.add(rs.getString("date"));
                    v.add(rs.getString("on_time"));
                    v.add(rs.getString("off_time"));
                    v.add(rs.getString("status"));
                    v.add(rs.getString("staff_id_staff"));
                    userTableModel.addRow(v);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public String selectCustomer(String barcode) {
        String msg = "";
        String q = "SELECT * FROM customer WHERE customer_barcode='"+barcode+"'";
        try {
            Statement s1 = conn.createStatement();
            ResultSet rs = s1.executeQuery(q);
            while (rs.next()) {
                msg = "have";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg="no";
        }
       return msg;
    }
    public String selectStaff(String barcode) {
        String msg = "";
        String q = "SELECT * FROM staff WHERE id_staff='"+barcode+"'";
        try {
            Statement s1 = conn.createStatement();
            ResultSet rs = s1.executeQuery(q);
            while (rs.next()) {
                msg = "have";
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg="no";
        }
       return msg;
    }

    
    public double getAttendanceForSalary(String pId, int month, String d ) {
        System.out.println(pId +" "+month+" "+d);
//        String query = "SELECT * FROM attendance WHERE MONTH(timeIn)=? AND YEAR(timeIn)=YEAR(CURDATE()) AND pharmacist_id=?";
        String query= "SELECT rtw.`status`,s.salary salary FROM reporting_to_work rtw, staff s WHERE rtw.staff_id_staff = s.id_staff AND MONTH(`date`)= ? AND YEAR(`date`)=YEAR(CURDATE()) AND staff_id_staff=?";
        double absentDays = 0.0;
        double monthSalary = 0.0;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, month);
            ps.setString(2, pId);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String status = rs.getString("rtw.status");
                System.out.println(status);
                
                if(status.equalsIgnoreCase("Absent")){
                    absentDays = absentDays+1;
                }
                
                if(status.equalsIgnoreCase("Short Leave")){
                    absentDays = absentDays+0.5;
                }
                
                monthSalary = rs.getDouble("s.salary");
                System.out.println(monthSalary);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        
      //  double dd = Double.parseDouble(d);
        String de = String.valueOf(absentDays*850.0);
        GUI.ManagerUser.attendance.deduction.setText(de);
        
        double totalSalary = monthSalary-(absentDays*850);
        
        return totalSalary;
    }

    public String insertSalary(String barcode, String position, String n, String i, double bSalary, double salaryDEduc, double tot, String strMonth, int Year) {
    String msg="";
    String query= "INSERT INTO `payrole`(`salary_deduction`,`total`,`month`,`year`,`staff_id_staff`)VALUES(?,?,?,?,?)";
    
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setDouble(1,salaryDEduc);
            psm.setDouble(2,tot);
            psm.setString(3,strMonth);
            psm.setInt(4, Year);
            psm.setString(5, barcode);
            psm.execute();
            
            msg = "Sucessed ! ";
        } catch (Exception e) {
            e.printStackTrace();
            msg = " Error";
        }
        return msg;
    }

//    public String getQty(String barcode, String qt) {
//    String msg = "";
//    String avl_qty="";
//    String q ="select * from products where barcode ='"+barcode+"'";
//    
//        try {
//           Statement stm=conn.createStatement();
//           ResultSet rs=stm.executeQuery(q);
//            if(rs.next()){
//            avl_qty=rs.getString("qty");
//            int davl_qty=Integer.parseInt(avl_qty);
//            int dqty=Integer.parseInt(qt);
//            int totalqty=davl_qty+dqty;
//            String castedTotal=String.valueOf(totalqty);
//            msg=castedTotal;
//            
//            
//            }else{
//             String query = "INSERT INTO products(product_barcode,category,name,description,selling_price,qty)"
//                + "VALUES(?,?,?,?,?,?);";
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, barcode);
//            ps.setString(2, pCategory);
//            ps.setString(3, item_name);
//            ps.setString(4, description);
//            ps.setDouble(5, unitP);
//            ps.setString(6, qt);
//
//            ps.execute();
//            msg = "Do you want to Save that Details? !";
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
//            log1.debug(e.getMessage());
//        }
//            
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        
//        
//        return msg;
//    }

    public String getQty(String barcode, String pCategory, String item_name, String description, double unitP, String qt) {
    String msg = "";
    String avl_qty="";
    String q ="select * from products where product_barcode ='"+barcode+"'";
    
        try {
           Statement stm=conn.createStatement();
           ResultSet rs=stm.executeQuery(q);
            if(rs.next()){
            avl_qty=rs.getString("qty");
            int davl_qty=Integer.parseInt(avl_qty);
            int dqty=Integer.parseInt(qt);
            int totalqty=davl_qty+dqty;
            String castedTotal=String.valueOf(totalqty);
            msg=castedTotal;
            
            
            }else{
             String query = "INSERT INTO products(product_barcode,category,name,description,selling_price,qty)"
                + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barcode);
            ps.setString(2, pCategory);
            ps.setString(3, item_name);
            ps.setString(4, description);
            ps.setDouble(5, unitP);
            ps.setString(6, qt);

            ps.execute();
            msg = "Do you want to Save that Details? !";

        } catch (Exception e) {
            e.printStackTrace();
            msg = "Ooops !!! Something Wrong ! " + e.getMessage();
            log1.debug(e.getMessage());
        }
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return msg;
    }

    public String updateGRn(String grnid, String qt, String avl_qty) {
       String msg="";
       int intqty=Integer.parseInt(qt);
       int intavlqty=Integer.parseInt(avl_qty);
       int remainingaty=intavlqty-intqty;
       String castedremaining=String.valueOf(remainingaty);
       String query="update grn set qty=? where id_grn=?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,castedremaining);
            psm.setString(2,grnid);
            psm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        return msg;
    }

    public String selectCompanyID(String company) {
       String msg="";
       String query="select * from company where name='"+company+"'";
        try {
       Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String comID=rs.getString("id_company");
            msg=comID;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log1.debug(e.getMessage());
        }
        return msg;
    }
  
}

