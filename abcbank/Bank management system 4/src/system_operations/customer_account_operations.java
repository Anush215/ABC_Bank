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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KNOX
 */
public class customer_account_operations {
    Connection connection;
     int result;
     
      public customer_account_operations(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcbank", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
     public void customerList (JTable customerTable){
        
        
        try{
            String sql = "select * from customer_acc";
        
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        customerTable.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        } 
        
     }
     
     public void CustomerByAcc(JTable table1,String accno){
        

            try{
                
            String sql = "select * from customer_acc where account_no='"+accno+"'";

            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs =psmt.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs)); 
            }catch(Exception e){
                System.out.println(e);
        }
    }
     
     public void CustomerByName(JTable customer_table,String name){
        
        
        String ch="%";
        String search =name +""+ch;
        
        try{
            
        String sql = "select * from customer_acc WHERE name LIKE '"+search+ "'";
        
        PreparedStatement psmt = connection.prepareStatement(sql);
        ResultSet rs =psmt.executeQuery();
        customer_table.setModel(DbUtils.resultSetToTableModel(rs)); 
        }catch(Exception e){
            System.out.println(e);
        }
     }
     
     public void checkBalance(int acc_no,JTextField name,JTextField acc_type,JTextField cur_bal){
        try{
          
            
            String sql ="select name,acc_type,curr_bal from customer_acc where account_no=?";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,acc_no );
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                name.setText(rs.getString("name"));
                acc_type.setText(rs.getString("acc_type"));
                cur_bal.setText(rs.getString("curr_bal"));
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
     
     public void deposit(int acc_no,double cur_bal,double amount){
        
        
        try{
            
            
            String sql ="update customer_acc set curr_bal = ? where account_no=?";
            
            
            
            
            if(amount > 0) {
                
                cur_bal = cur_bal+amount;
                
            PreparedStatement pstmt = connection.prepareStatement(sql);
           
            pstmt.setDouble(1, cur_bal);
            pstmt.setInt(2,acc_no);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "'"+amount+"' deposited successfully");
            
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "error occured you cannot deposit below 0");
            }
           
            
        }catch(Exception e){
            System.out.println(e);
        }
        
       
    }
     
     public void withdraw(int acc_no,double cur_bal,double amount){
        
        
        try{
            
                       String sql ="update customer_acc set curr_bal = ? where account_no=?";
            
            
            
            
            if(amount < cur_bal) {
                
                cur_bal = cur_bal-amount;
                
            PreparedStatement pstmt = connection.prepareStatement(sql);
           
            pstmt.setDouble(1, cur_bal);
            pstmt.setInt(2, acc_no);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "'"+amount+"' withdrawed successfully");
            
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "insufficent balance");
            }
           
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
}
