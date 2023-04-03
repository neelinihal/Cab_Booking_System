
package cab_booking_system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Book_Cab extends JFrame implements ActionListener{
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Font f,f1;
    Choice ch,ch1,ch2;
    
    Book_Cab(){
         super("BOOK INTRACITY CAB");
          setSize(1100,700);
          setLocation(50,50);
          
          f = new Font("Monospaced",Font.BOLD,25);
          f1 = new Font("Arial",Font.BOLD,18);
          
          
          ch = new Choice();
          try{
             ConnectionClass obj = new ConnectionClass();
             String q1 = "Select source from intracity_driver";
             ResultSet rest = obj.stm.executeQuery(q1);
             while(rest.next()){
                 ch.add(rest.getString("source"));
                 
             }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          ch1 = new Choice();
          try{
             ConnectionClass obj = new ConnectionClass();
             String q2 = "Select Destination from intracity_driver";
             ResultSet rest1 = obj.stm.executeQuery(q2);
             while(rest1.next()){
                 ch1.add(rest1.getString("Destination"));
                 
             }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          ch2 = new Choice();
          try{
             ConnectionClass obj = new ConnectionClass();
             String q = "Select username from customer";
             ResultSet rest2 = obj.stm.executeQuery(q);
             while(rest2.next()){
                 ch2.add(rest2.getString("username"));
                 
             }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          l0 = new JLabel("BOOK INTRACITY CAB");
          l0.setHorizontalAlignment(JLabel.CENTER);
          l0.setForeground(black);
          l0.setFont(f);
          l1 = new JLabel("Book ID");
          l2 = new JLabel("Source");
          l3 = new JLabel("Destination");
          l4 = new JLabel("Username");
          l5 = new JLabel("Name");
          l6 = new JLabel("Driver Name");
          l7 = new JLabel("Car");
          l8 = new JLabel("Destination from");
          l9 = new JLabel("Destination to");
          l10 = new JLabel("Price");
          
          t1 = new JTextField();
          t2 = new JTextField();
          t3 = new JTextField();
          t4 = new JTextField();
          t5 = new JTextField();
          t6 = new JTextField();
          t7 = new JTextField();
          
          t1.setEditable(false);
          t2.setEditable(false);
          t3.setEditable(false);
          t4.setEditable(false);
          t5.setEditable(false);
          t6.setEditable(false);
          t7.setEditable(false);
         
          
          b1 = new JButton("Book Cab");
          b2 = new JButton("Back");
          
          b1.addActionListener(this);
          b2.addActionListener(this);
          
          l1.setFont(f1);
          l2.setFont(f1);
          l3.setFont(f1);
          l4.setFont(f1);
          l5.setFont(f1);
          l6.setFont(f1);
          l7.setFont(f1);
          l8.setFont(f1);
          l9.setFont(f1);
          l10.setFont(f1);
          
          t1.setFont(f1);
          t2.setFont(f1);
          t3.setFont(f1);
          t4.setFont(f1);
          t5.setFont(f1);
          t6.setFont(f1);
          t7.setFont(f1);
           
          b1.setBackground(yellow);
          b2.setBackground(red);
          
          b1.setForeground(black);
          b2.setForeground(white);
          
          Random rm = new Random();
          t1.setText(""+Math.abs(rm.nextInt()%100000));
          t1.setForeground(red);
          
           ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("cab_booking_system/icons/cab7.png"));
           Image img = ic.getImage().getScaledInstance(800, 820,Image.SCALE_DEFAULT);
           ImageIcon  ic2 = new ImageIcon(img);
           l11 = new JLabel(ic2);
          
          p1 = new JPanel();
          p1.setLayout(new GridLayout(1,1,10,10));
          p1.add(l0);
          
          p2 = new JPanel();
          p2.setLayout(new GridLayout(1,1,10,10));
          p2.add(l11);
          
          p3 = new JPanel();
          p3.setLayout(new GridLayout(11,2,10,10));
          p3.add(l1);
          p3.add(t1);
          p3.add(l2);
          p3.add(ch);
          p3.add(l3);
          p3.add(ch1);
          p3.add(l4);
          p3.add(ch2);
          p3.add(l5);
          p3.add(t2);
          p3.add(l6);
          p3.add(t3);
          p3.add(l7);
          p3.add(t4);
          p3.add(l8);
          p3.add(t5);
          p3.add(l9);
          p3.add(t6);
          p3.add(l10); 
          p3.add(t7);
          p3.add(b1);
          p3.add(b2);
          
          setLayout(new BorderLayout(10,10));
          add(p1,"North");
          add(p2,"West");
          add(p3,"Center");
          
         
          ch.addMouseListener(new MouseAdapter()
          {
          
          public void mouseClicked(MouseEvent arg0){
          try{
              ConnectionClass obj2 = new ConnectionClass();
              String source = ch.getSelectedItem();
              String Destination = ch1.getSelectedItem();
              String q1 = "select * from intracity_driver where source = '"+source+"' and Destination = '"+Destination+"'";
              ResultSet rest1 = obj2.stm.executeQuery(q1);
              while(rest1.next()){
                  t3.setText(rest1.getString("Drivername"));
                  t4.setText(rest1.getString("Car"));
                  t5.setText(rest1.getString("source"));
                  t6.setText(rest1.getString("Destination"));
                  t7.setText(rest1.getString("price"));
              }
          }
          catch(Exception exx){
              exx.printStackTrace();
            }
        }
    });
          ch2.addMouseListener(new MouseAdapter()
          {
          
          public void mouseClicked(MouseEvent arg0){
          try{
              ConnectionClass obj2 = new ConnectionClass();
              String username = ch2.getSelectedItem();
              String q1 = "select * from customer where username = '"+username+"'";
              ResultSet rest1 = obj2.stm.executeQuery(q1);
              while(rest1.next()){
                  t2.setText(rest1.getString("name"));
              }
          }
          catch(Exception exx){
              exx.printStackTrace();
            }
        }
    });
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            String bid = t1.getText();
            String username = ch2.getSelectedItem();
            String DName = t3.getText();
            String Car = t4.getText();
            String DFrom = t5.getText();
            String FTo = t6.getText();
            String Price = t7.getText(); 
            try{
                if(e.getSource()==b1){
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into intracitycab values ('"+bid+"','"+username+"','"+DName+"','"+Car+"','"+DFrom+"','"+FTo+"','"+Price+"')";
                int aa = obj.stm.executeUpdate(q);
                if(aa==1){
                    JOptionPane.showConfirmDialog(null, "Details sucessfully Inserted");
                    this.setVisible(false);
                    new Update_Customer();
                    }
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Cab Booked Successfully");
                }
            }
            catch(Exception ee){
                ee.printStackTrace();
            }          
        }
        if(e.getSource()==b2){
                   this.setVisible(false);
                   new HomePage().setVisible(true);
                }
    }
    public static void main(String [] args){
        new Book_Cab().setVisible(true);
    }
}
