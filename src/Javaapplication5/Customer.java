/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javaapplication5.Home.customerid;
import static javaapplication5.Home.fullname;
import static javaapplication5.Home.phone;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Customer {
    
    public void customerLogin(){
                Register frame2 = new Register();
        frame2.show();
        dispose();
    }                                                    

    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        
        String password = passwordfield.getText();
        String username = usernamefild.getText();
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        
        
        try {        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mamaskitchen","root","");
            pst = con.prepareStatement("Select * from customer where username = '" + username + "'");
            rs = pst.executeQuery();
            while (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    
                fullname = rs.getString("fullname");
                phone = rs.getString("phone");
                customerid = rs.getInt("customerid");
            //JOptionPane.showMessageDialog(null, "Login succesful!");
            Cafe frame4 = new Cafe(fullname,phone,customerid);
            frame4.show();
            dispose();
            }
            else {
                    Incorrect_password.setText("Check username or password and try again!");
                
        
            }
                
            }
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
        }
        
        
    }
    
}
