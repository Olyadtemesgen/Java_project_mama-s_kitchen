package javaapplication5;

import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javaapplication5.Home.customerid;
import static javaapplication5.Home.fullname;
import static javaapplication5.Home.phone;

public class Cafe extends JFrame implements ActionListener {
    String fullname;
    String phone;
    int customerid;

    Cafe( String fullname,String phone, int customerid ){
        
        this.customerid = customerid;
        this.fullname = fullname;
        this.phone = phone;
        
        ScrollPane scroll = new ScrollPane();
        scroll.setSize(25, 600);
        scroll.setVisible(true);

        this.setSize(1200,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        Connection con;
        ResultSet rs;
        PreparedStatement pst;
        
        
        try {        
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mamaskitchen","root","");
            
        ArrayList<JButton> cafeList = new ArrayList<JButton>();
        int i = 0;
        String query = "select * from cafes;";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while(rs.next()){
            
           
            int cafeid = rs.getInt("id");
             
            String cafeName =rs.getString("name");
            String type = rs.getString("type");
            String address = rs.getString("address");
             
            JButton button = new JButton();
            button.setBounds(300, (i)*50 +25 , 600, 40);
            button.setText(cafeName +" " + type + "   address: around" + address );
            button.setFont(new Font("Serif", Font.BOLD, 18));
            
            i++;
             
            button.addActionListener( e -> {
                Food food = new Food(cafeid, cafeName, this.customerid, this.fullname, this.phone);
                food.show();
                dispose();
            });

            cafeList.add(button);
        }
        
        for (JButton j: cafeList){
            
            this.add(j);
        }
        this.setLayout(null);
        this.add(scroll);
        JButton back = new JButton();
        back.setBounds(300, (i)* 50 + 50, 100, 40);
        back.setText("Back");
        back.addActionListener( e -> {
                Home home = new Home();
                home.show();
                dispose();});

        this.add(back);
        }catch(Exception ex){
            ex.getStackTrace();
           
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
