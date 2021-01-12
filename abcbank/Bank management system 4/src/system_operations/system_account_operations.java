/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KNOX
 */
public class system_account_operations {
    Connection con;
    
    public system_account_operations(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcbank", "root", "");
        } catch (Exception e) {
           System.out.println(e);
        } 
    }
    
    public void managerView (JTable table1){
        
        JTable jtable=table1;
        try{
            String sql = "select * from admin";
        
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        jtable.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        } 
        
    }
    
    public void cashierView (JTable table1){
        
        JTable jtable=table1;
        try{
            String sql = "select * from cashier";
        
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        jtable.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        } 
        
    }
}
