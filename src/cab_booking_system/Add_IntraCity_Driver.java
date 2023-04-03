
package cab_booking_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static java.awt.Color.*;
import java.awt.event.*;

public class Add_IntraCity_Driver extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Font f,f1;
    
    Add_IntraCity_Driver(){
        super("Add IntraCity Driver");
          setSize(440,400);
          setLocation(450,50);
          
          f = new Font("Monospaced",Font.BOLD,22);
          f1 = new Font("Arial",Font.BOLD,18);
          
          l1 = new JLabel("ADD INTRACITY DRIVER");
          l1.setHorizontalAlignment(JLabel.CENTER);
          l1.setForeground(black);
          l2 = new JLabel("Driver Name");
          l3 = new JLabel("Source");
          l4 = new JLabel("Destination");
          l5 = new JLabel("Car");
          l6 = new JLabel("Price");
          
          t1 = new JTextField();
          t2 = new JTextField();
          t3 = new JTextField();
          t4 = new JTextField();
          t5 = new JTextField();
          
          b1 = new JButton("Add IntraCity Driver");
          b2 = new JButton("Back");
          
          b1.addActionListener(this);
          b2.addActionListener(this);
          
          l1.setFont(f);
          l2.setFont(f1);
          l3.setFont(f1);
          l4.setFont(f1);
          l5.setFont(f1);
          l6.setFont(f1);
          
          t1.setFont(f1);
          t2.setFont(f1);
          t3.setFont(f1);
          t4.setFont(f1);
          t5.setFont(f1);
          
          p1 = new JPanel();
          p1.setLayout(new GridLayout(1,1,10,10));
          p1.add(l1);
          p1.setBackground(pink);
          
          p3 = new JPanel();
          p3.setLayout(new GridLayout(6,2,10,10));
          
          p3.add(l2);
          p3.add(t1);
          p3.add(l3);
          p3.add(t2);
          p3.add(l4);
          p3.add(t3);
          p3.add(l5);
          p3.add(t4);
          p3.add(l6);
          p3.add(t5);
          p3.add(b1);
          p3.add(b2);
          
          setLayout(new BorderLayout(10,10));
          add(p1,"North");
          add(p3,"Center");
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            String Drivername = t1.getText();
            String source = t2.getText();
            String Destination = t3.getText();
            String Car = t4.getText();
            String price = t5.getText();
            
            try{
                ConnectionClass obj = new ConnectionClass();
                String q1 = "insert into intracity_driver values ('"+Drivername+"','"+source+"','"+Destination+"','"+Car+"','"+price+"')";
                int aa = obj.stm.executeUpdate(q1);
                if(aa==1){
                    JOptionPane.showConfirmDialog(null, "Your data sucessfully Inserted");
                    this.setVisible(false);
                }else{
                    JOptionPane.showConfirmDialog(null, "Please, Fill all details carefully");
                }
            }
            catch(Exception ee){
                ee.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            this.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }
    public static void main(String [] args){
        new Add_IntraCity_Driver().setVisible(true);
    }
}
