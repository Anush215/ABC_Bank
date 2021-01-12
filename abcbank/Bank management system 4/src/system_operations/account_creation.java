/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KNOX
 */
public class account_creation {
    
    Connection con;
     int result;
    public account_creation(){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abcbank", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public int addManager(String name,String pass,String dob,String gender,String address,String nic,String mobile,String position){
        try{
            
            String sql ="insert into admin (name,password,birth_day,gender,address,nic,mobile,position) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, pass);
            psmt.setString(3, dob);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);
            psmt.setString(8, position);
            
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    
    public int addCashier(String name,String pass,String dob,String gender,String address,String nic,String mobile,String position){
        try{
            
            String sql ="insert into cashier (name,password,birth_day,gender,address,nic,mobile,position) values (?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, pass);
            psmt.setString(3, dob);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);
            psmt.setString(8, position);
            
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    
    public int addCustomer(String name,String acc_type,String date_of_birth,String gender,String address,String nic,String mobile,double initial_pay){
       
   
        try{
            
            String sql ="insert into customer_acc (name,acc_type,date_of_birth,gender,address,nic,mobile,initial_pay,curr_bal) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement psmt = con.prepareStatement(sql);
           
            
            psmt.setString(1, name);
            psmt.setString(2, acc_type);
            psmt.setString(3, date_of_birth);
            psmt.setString(4, gender);
            psmt.setString(5, address);
            psmt.setString(6, nic);
            psmt.setString(7, mobile);  
            psmt.setDouble(8, initial_pay);
            psmt.setDouble(9, initial_pay);
            
            psmt.executeUpdate();
            result=1;
        }catch(Exception e){
            System.out.println(e);
            result=0;
        }
        return result;
    }
    
}
