
package cab_booking_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static java.awt.Color.*;
import java.awt.event.*;

public class Update_Customer extends JFrame implements ActionListener  {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton b1,b2;
    Font f,f1;
    Choice ch;
    
      Update_Customer(){
          super("Update Customer");
          setSize(740,700);
          setLocation(50,50);
          
          f = new Font("Monospaced",Font.BOLD,25);
          f1 = new Font("Arial",Font.BOLD,18);
          
          ch = new Choice();
          try{
             ConnectionClass obj = new ConnectionClass();
             String q = "Select username from customer";
             ResultSet rest = obj.stm.executeQuery(q);
             while(rest.next()){
                 ch.add(rest.getString("username"));
                 
             }
          }
          catch(Exception e){
              e.printStackTrace();
          }
          
          l1 = new JLabel("UPDATE CUSTOMER");
          l1.setHorizontalAlignment(JLabel.CENTER);
          l1.setForeground(black);
          l2 = new JLabel("Username");
          l3 = new JLabel("Name");
          l4 = new JLabel("Age");
          l5 = new JLabel("date of Birth");
          l6 = new JLabel("Address");
          l7 = new JLabel("Phone");
          l8 = new JLabel("Email");
          l9 = new JLabel("Country");
          l10 = new JLabel("Gender");
          l11 = new JLabel("Aadhar");
          
          t1 = new JTextField();
          t2 = new JTextField();
          t3 = new JTextField();
          t4 = new JTextField();
          t5 = new JTextField();
          t6 = new JTextField();
          t7 = new JTextField();
          t8 = new JTextField();
          t9 = new JTextField();
          
          b1 = new JButton("Update");
          b2 = new JButton("Back");
          
          b1.addActionListener(this);
          b2.addActionListener(this);
          
          l1.setFont(f);
          l2.setFont(f1);
          l3.setFont(f1);
          l4.setFont(f1);
          l5.setFont(f1);
          l6.setFont(f1);
          l7.setFont(f1);
          l8.setFont(f1);
          l9.setFont(f1);
          l10.setFont(f1);
          l11.setFont(f1);
          
          t1.setFont(f1);
          t2.setFont(f1);
          t3.setFont(f1);
          t4.setFont(f1);
          t5.setFont(f1);
          t6.setFont(f1);
          t7.setFont(f1);
          t8.setFont(f1);
          t9.setFont(f1);
          ch.setFont(f1);
           
          b1.setBackground(black);
          b2.setBackground(red);
          
          b1.setForeground(white);
          b2.setForeground(white);
          
           ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("cab_booking_system/icons/update.png"));
           Image img = ic.getImage().getScaledInstance(250, 620,Image.SCALE_DEFAULT);
           ImageIcon  ic2 = new ImageIcon(img);
           l12 = new JLabel(ic2);
          
          p1 = new JPanel();
          p1.setLayout(new GridLayout(1,1,10,10));
          p1.add(l1);
          
          p2 = new JPanel();
          p2.setLayout(new GridLayout(1,1,10,10));
          p2.add(l12);
          
          p3 = new JPanel();
          p3.setLayout(new GridLayout(11,2,10,10));
          p3.add(l2);
          p3.add(ch);
          p3.add(l3);
          p3.add(t1);
          p3.add(l4);
          p3.add(t2);
          p3.add(l5);
          p3.add(t3);
          p3.add(l6);
          p3.add(t4);
          p3.add(l7);
          p3.add(t5);
          p3.add(l8);
          p3.add(t6);
          p3.add(l9);
          p3.add(t7);
          p3.add(l10);
          p3.add(t8);
          p3.add(l11); 
          p3.add(t9);
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
              String username = ch.getSelectedItem();
              String q1 = "select * from customer where username = '"+username+"'";
              ResultSet rest1 = obj2.stm.executeQuery(q1);
              while(rest1.next()){
                  t1.setText(rest1.getString("name"));
                  t2.setText(rest1.getString("age"));
                  t3.setText(rest1.getString("dob"));
                  t4.setText(rest1.getString("address"));
                  t5.setText(rest1.getString("phone"));
                  t6.setText(rest1.getString("email"));
                  t7.setText(rest1.getString("country"));
                  t8.setText(rest1.getString("gender"));
                  t9.setText(rest1.getString("aadhar"));
              }
          }
          catch(Exception exx){
              exx.printStackTrace();
            }
        }
    });
}
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String username = ch.getSelectedItem();
            String name = t1.getText();
            String age = t2.getText();
            String dob = t3.getText();
            String address = t4.getText();
            String phone = t5.getText();
            String email = t6.getText();
            String country = t7.getText();
            String gender = t8.getText();
            String aadhar = t9.getText();
            try{
                ConnectionClass obj3 = new ConnectionClass();
                String q1 = "update customer set name = '"+name+"',age='"+age+"',dob='"+dob+"',address='"+address+"',phone='"+phone+"',email='"+email+"',country='"+country+"',gender='"+gender+"',aadhar='"+aadhar+"' where username='"+username+"'";
                int aa = obj3.stm.executeUpdate(q1);
                if(aa==1){
                    JOptionPane.showConfirmDialog(null, "your data Sucessfully updated");
                    this.setVisible(false);
                    new View_Customer_profiles().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
                }
            }
            catch(Exception eee){
                eee.printStackTrace();
            }
        if(e.getSource()==b2){
            //new Update_Customer().setVisible(false);
            new HomePage().setVisible(true);
        }    
        }
    }
      public static void main(String [] args){
          new Update_Customer().setVisible(true);
      }
}
