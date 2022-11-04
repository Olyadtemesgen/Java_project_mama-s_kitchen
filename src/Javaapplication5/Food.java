/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Fikre
 */

public class Food extends JFrame implements ActionListener {
    ScrollPane scroll2 = new ScrollPane();
    
    int cafeId ;
    String cafeName ;
    int customerid;
    String fullname;
    String phone;

    Food(int cafeId, String cafeName, int customerid, String fullname, String phone){
        this.cafeId = cafeId;
        this.cafeName = cafeName;
        this.customerid = customerid;
        this.fullname = fullname;
        this.phone = phone;

        scroll2.setSize(25, 600);
        scroll2.setVisible(true);

        this.setSize(1200,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        ArrayList<JLabel> foodList = new ArrayList<JLabel>();
        ArrayList<JButton> order = new ArrayList<JButton>();
        ArrayList<JButton> deliver = new ArrayList<JButton>();
        
        Connection con;
        ResultSet result;
        Statement insert;
        
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mamaskitchen","root","");
            
            insert = con.createStatement();
            result = insert.executeQuery("select * from food where cafeid = "+this.cafeId+"");
            int i = -1;
          
            while(result.next()){
                String name = result.getString("name");
                i += 1;
                JLabel food = new JLabel();
                food.setText( result.getString("name") + "   type: " + result.getString("type")+""
                        + "   price: " + result.getFloat("price") + "Birr");
                food.setBounds(25, i*50 + 15, 300, 75);
                food.setFont(new Font("Serif", Font.BOLD, 15));
                foodList.add(food);

                JButton button = new JButton();
                button.setBounds(425, i*50 + 25, 200, 40);
                button.setText("Order" );
                
                button.addActionListener( e -> {
                    try{
                        //Class.forName("com.mysql.jdbc.Driver");
                        
          
                        
                        String query = "insert into orderlist (fullname,phone, customerid,food, cafeid) values(?,?,?,?,?)";
                        PreparedStatement insertto;
                        
                        insertto  = con.prepareStatement(query);
                       
                        
                        insertto.setString(1, this.fullname);
                        insertto.setString(2, this.phone);
                        insertto.setInt(3, this.customerid);
                         
                        insertto.setString(4, name);
                         
                        insertto.setInt(5, this.cafeId);
                        insertto.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Order Successful");
                    }catch(Exception ex){
                        ex.getStackTrace();
                    }
                 });
                order.add(button);

                JButton button2 = new JButton();
                button2.setBounds(650, i*50 +25, 200, 40);
                button2.setText("Deliver" );
                button2.addActionListener(e -> {
                    try{
                        //Class.forName("com.mysql.jdbc.Driver");
                       
                        //String query = "insert into orderlist (fullname,phone, customerid,food, cafeid) values(?,?,?,?,?)";
                        PreparedStatement insert2;
                        
                        //insert2  = con.prepareStatement(query);
                        
                        String query2 = "insert into delivery(cafeid,phone, customerid,food, address) values(?,?,?,?,?)";
                        insert2 = con.prepareStatement(query2);
                        String address = JOptionPane.showInputDialog("Enter Your address.");
                        insert2.setInt(1, this.cafeId);
                        insert2.setString(2, this.phone);
                        insert2.setInt(3, this.customerid);
                        insert2.setString(4,name );
                        insert2.setString(5, address);
                        insert2.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Your delivery is being processed");
                    }catch(Exception ex){
                        ex.getStackTrace();
                    }
                    });

                deliver.add(button2);

                
        }
            for (JLabel l: foodList){
                    this.add(l);
            }
            for (JButton b: order){
                 this.add(b);
            }
            for (JButton b2: deliver){
                    this.add(b2);
            }
            
            
            JButton back = new JButton();
                back.setBounds(600, (i+2)*50 +25, 100, 40);
                back.setText("Back" );
                back.addActionListener(e -> { 
                    Cafe cafe = new Cafe(fullname, phone, customerid);
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

