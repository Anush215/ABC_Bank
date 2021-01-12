/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_operations;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KNOX
 */
public class system_login {
    
    Connection con;
    
    public system_login(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcbank", "root", "");
        } catch (Exception e) {
            System.out.println(e);
       
    }
    
    }
    
    public String admin_login(String user,String pass){
       String result = null;
        try{


                Statement stmt=con.createStatement();
                String sql="select * from admin where nic='"+user+"' and password='"+pass+"'";
                ResultSet rs =stmt.executeQuery(sql);


                if(rs.next()){
                result= rs.getString(1);


        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return result;
    }
    
    public String cashier_login(String user,String pass){
       String result = null;
    try{

    
    Statement stmt=con.createStatement();
    String sql="select * from cashier where nic='"+user+"' and password='"+pass+"'";
    ResultSet rs =stmt.executeQuery(sql);


    if(rs.next()){
    result= rs.getString(1);


    }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    return result;
    }
    
}
