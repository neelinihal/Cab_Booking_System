
package cab_booking_system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener{
    
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2;
    
    Login(){
        f = new JFrame("Login Acount");
        f.setBackground(WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0, 0, 600, 350);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("cab_booking_system/icons/4893732.jpg"));
        Image i1 = img.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2 = new JLabel("LOGIN ACOUNT");
        l2.setBounds(120, 30, 500, 50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(PINK);
        l1.add(l2);
        
        l3 = new JLabel("Username :");
        l3.setBounds(80, 100, 150, 30);
        l3.setForeground(ORANGE);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l3);
        
        l4 = new JLabel("Password :");
        l4.setBounds(80, 170, 150, 30);
        l4.setForeground(ORANGE);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l4);
        
        t1 = new JTextField();
        t1.setBounds(220, 100, 150, 30);
        t1.setForeground(BLACK);
        t1.setFont(new Font("Cambria",Font.BOLD,20));
        l1.add(t1);
        
        pf1 = new JPasswordField();
        pf1.setBounds(220, 170, 150, 30);
        l1.add(pf1);
        
        b1 = new JButton("Login");
        b1.setBackground(BLACK);
        b1.setForeground(WHITE);
        b1.setBounds(70, 220, 130, 40);
        
        b2 = new JButton("SignUp");
        b2.setBackground(RED);
        b2.setForeground(WHITE);
        b2.setBounds(240, 220, 130, 40);
        
        l1.add(b1);
        l1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(500,330);
        f.setLocation(300,110);
        f.setResizable(false);
        
        
        f.add(t1);
       f.add(l1);

    }
    public void actionPerformed(ActionEvent ee){
        if(ee.getSource()==b1){
            try{
                ConnectionClass obj = new ConnectionClass();
                String username = t1.getText();
                String password = pf1.getText();
                
                String q = "Select * from signup where username= '"+username+"' and password = '"+password+"'";
                ResultSet rs = obj.stm.executeQuery(q);
                
                if(rs.next()){
                    new HomePage().setVisible(true);
                    f.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "You have entered wrong username and password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ee.getSource()==b2){
            f.setVisible(false);
            new SignUp();
        }
    }
    public static void main(String [] args){
        new Login();
    }
}
