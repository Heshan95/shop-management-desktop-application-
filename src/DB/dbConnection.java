/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author kulas
 */
public class dbConnection {    
    private static Connection conn;    
    public static Connection getConnection (){        
        if(conn==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/lakshaapplication?useSSL=false", "root", "Tc@19720228");
            } catch (Exception ex) {
                ex.printStackTrace();
            }            
        }
        return conn;
    }
    public static void main(String[] args) {
        try {
            System.out.println(getConnection().getCatalog());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
