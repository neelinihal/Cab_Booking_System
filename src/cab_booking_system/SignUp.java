
package cab_booking_system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignUp extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3;
    JPasswordField p1;
    JButton b1,b2;
    
    SignUp(){
       f = new JFrame("Create new Acount");
       f.setBackground(BLACK);
       f.setLayout(null);
       
       l1 = new JLabel("UserName");
       l1.setBounds(40, 20, 100, 30);
       f.add(l1);
       
       l2 = new JLabel("Name");
       l2.setBounds(40, 70, 100, 30);
       f.add(l2);
       
       l3 = new JLabel("Password");
       l3.setBounds(40, 120, 100, 30);
       f.add(l3);
       
       l4 = new JLabel("Phone No");
       l4.setBounds(40,170, 100, 30);
       f.add(l4);
       
       t1=new JTextField();
       t1.setBounds(150,20,150,30);
       f.add(t1);
       
       t2=new JTextField();
       t2.setBounds(150,70,150,30);
       f.add(t2);
       
       t3=new JTextField();
       t3.setBounds(150,170,150,30);
       f.add(t3);
       
       p1=new JPasswordField();
       p1.setBounds(150,120,150,30);
       f.add(p1);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("cab_booking_system/icons/signup.png"));
       Image i2 =i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l5 = new JLabel(i3);
       l5.setBounds(350,70,150,150);
       f.add(l5);
       
       b1=new JButton("SignUp");
       b1.setBackground(BLACK);
       b1.setForeground(WHITE);
       b1.setBounds(40,240,120,30 );
       
       b2=new JButton("Back");
       b2.setBackground(BLACK);
       b2.setForeground(WHITE);
       b2.setBounds(180,240,120,30 );
       
       b1.addActionListener(this);
       b2.addActionListener(this);

       f.add(b1);
       f.add(b2);
       
       f.getContentPane();
       
       f.setVisible(true);
       f.setSize(550,340);
       f.setLocation(400,300);
    }
    
    /**
     *
     * @param ee
     */
    @Override
   public void actionPerformed(ActionEvent ee){
       try{
           ConnectionClass con = new ConnectionClass();
           if(ee.getSource()==b1){
               String username = t1.getText();
               String name = t2.getText();
               String phone_number = t3.getText();
               String password = p1.getText();
               
                String sql = "insert into signup values('"+username+"', '"+name+"', '"+password+"', '"+phone_number+"')";
		int aa = con.stm.executeUpdate(sql);
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully ");
                    new Login();
                    this.f.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
                    this.f.setVisible(false);
                    this.f.setVisible(true);
                }
                }
            if(ee.getSource() == b2){              
                new Login();
                this.f.setVisible(false);
            }
       }catch(Exception e){
                System.out.println(e);
        }
       
   }
   public static void main(String [] args){
        new SignUp();
   }
}
