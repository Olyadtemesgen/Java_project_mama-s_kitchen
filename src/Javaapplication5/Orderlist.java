/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Orderlist extends JFrame implements ActionListener{
    int cafeid = Integer.parseInt(JOptionPane.showInputDialog("Enter Your Cafe Id"));


/**
 *
 * @author Fikre
*/
    Orderlist(){
        
        this.setSize(600, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        ArrayList<JLabel> foodList = new ArrayList<JLabel>();
        ArrayList<JButton> finished = new ArrayList<JButton>();
       
        
        Connection con;
        ResultSet result;
        Statement insert;
        
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mamaskitchen","root","");
            
            insert = con.createStatement();
            result = insert.executeQuery("select * from orderlist");
            int i = -1;
            
            while(result.next()){
                
                if (this.cafeid == result.getInt("cafeid")){
                    
                String name = result.getString("fullname");
                String phone = result.getString("phone");
                String food = result.getString("food");
                String date = result.getString("date");
                String orderid = result.getString("orderid");
                i += 1;
                JLabel orderlist = new JLabel();
                
                
                orderlist.setText(name +"  "+ phone +"  "+ food +"  "+ date);
                orderlist.setBounds(25, i*50 + 15, 300, 35);
                orderlist.setFont(new Font("Serif", Font.BOLD, 15));
                foodList.add(orderlist);
                JButton buttons = new JButton("Finished");
                buttons.setBounds(375, i*50 + 15, 100, 35);
                buttons.addActionListener(e ->{
                    try{
                    String querys = "DELETE FROM orderlist WHERE orderid ="+orderid+"";
                    PreparedStatement prep = con.prepareStatement(querys);
                    prep.executeUpdate();
                    JOptionPane.showMessageDialog(null, "current order removed successfully");
                    }catch(Exception exx){
                        exx.getStackTrace();
                    }
                });
                finished.add(buttons);
                }}
                for (JLabel order: foodList){
                    this.add(order);
                }
                for(JButton button: finished){
                    this.add(button);
                }
            
            JButton back = new JButton();
            back.setBounds(600, (i+6)*50 +25, 100, 40);
            back.setText("Back" );
            back.addActionListener(e -> { 
                CafeOwner cafe = new CafeOwner();
                cafe.show();
                dispose();
                    

                });
                this.add(back);
            
        }catch(Exception e){
            e.getStackTrace();
            
}}
    @Override
    public void actionPerformed(ActionEvent e){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


    

