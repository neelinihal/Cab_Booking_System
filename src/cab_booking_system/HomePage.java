
package cab_booking_system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class HomePage extends JFrame implements ActionListener{
    
    JLabel l1;
    Font f,f1,f2;
    JPanel p1,p2;
       
    HomePage(){
       super("Cab Booking Home page");
       setLocation(0,0);
       setSize(1550,800);
       
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("cab_booking_system/icons/781966.jpg"));
        Image img = ic.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon  ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1);
        
        Font f = new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);
        
        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Customer profiles");
        JMenuItem menI1 = new JMenuItem("Add Customer profiles");
        JMenuItem menI2 = new JMenuItem("View Customer Profiles");
        
        JMenu men2 = new JMenu("Manage Customer");
        JMenuItem menI3 = new JMenuItem("Update Customer Details");
        
        JMenu men3 = new JMenu("Book Cab");
        JMenuItem menI5 = new JMenuItem("Book Cab");
        JMenuItem menI6 = new JMenuItem("View Booked Cab");
        
        JMenu men4 = new JMenu("Book InterCity Cab");
        JMenuItem menI7 = new JMenuItem("Book InterCity Cab");
        JMenuItem menI8 = new JMenuItem("View InterCity Booked Cab");
        
        
        JMenu men5 = new JMenu("Transport");
        JMenuItem menI9 = new JMenuItem("Book Package");
        JMenuItem menI10 = new JMenuItem("View Booked Package");
        
        JMenu men6 = new JMenu("Bill");
        JMenuItem menI11 = new JMenuItem("Check Bill");
        
        JMenu men7 = new JMenu("Delete");
        JMenuItem menI12 = new JMenuItem("Delete Customer");
        
        JMenu men8 = new JMenu("About");
        JMenuItem menI13 = new JMenuItem("About");
        JMenuItem menI14 = new JMenuItem("Exit");
        
        men1.add(menI1);
        menI1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Add_Customer().setVisible(true);
                }catch(Exception e ){}
            }
	});
        
        men1.add(menI2);
        menI2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new View_Customer_profiles().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men2.add(menI3);
        menI3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Update_Customer().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men3.add(menI5);
        menI5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Book_Cab().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men3.add(menI6);
        menI6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new View_BookedCab().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men4.add(menI7);
        menI7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Book_Cab().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men4.add(menI8);
        menI8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new View_BookedCab().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men5.add(menI9);
        menI9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Book_Package().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men5.add(menI10);
        menI10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new View_Booked_Package().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men6.add(menI11);
        menI11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new CheckBill().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men7.add(menI12);
        menI12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new Delete_Customer().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men8.add(menI13);
        menI1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    new About().setVisible(true);
                }catch(Exception e ){}
            }
	});
        men8.add(menI14);
        menI14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    System.exit(0);
                }
                catch(Exception e ){}
            }
	});
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        m1.add(men8);
        
        m1.setBackground(BLACK);
        men1.setForeground(YELLOW);
        //men1.setFont(new Font("Arial",Font.BOLD,20));
        men2.setForeground(YELLOW);
        men3.setForeground(YELLOW);
        men4.setForeground(YELLOW);
        men5.setForeground(YELLOW);
        men6.setForeground(YELLOW);
        men7.setForeground(YELLOW);
        men8.setForeground(RED);
        
        menI1.setBackground(BLACK);
        menI2.setBackground(BLACK);
        menI3.setBackground(BLACK);
        menI5.setBackground(BLACK);
        menI6.setBackground(BLACK);
        menI7.setBackground(BLACK);
        menI8.setBackground(BLACK);
        menI9.setBackground(BLACK);
        menI10.setBackground(BLACK);
        menI11.setBackground(BLACK);
        menI12.setBackground(BLACK);
        menI13.setBackground(BLACK);
        menI14.setBackground(BLACK);
        
        menI1.setForeground(WHITE);
        menI2.setForeground(WHITE);
        menI3.setForeground(WHITE);
        menI5.setForeground(WHITE);
        menI6.setForeground(WHITE);
        menI7.setForeground(WHITE);
        menI8.setForeground(WHITE);
        menI9.setForeground(WHITE);
        menI10.setForeground(WHITE);
        menI11.setForeground(WHITE);
        menI12.setForeground(WHITE);
        menI13.setForeground(BLUE);
        menI14.setForeground(RED);
        
        setJMenuBar(m1);
        add(l1);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
//        String comd =e.getActionCommand();
//        if(comd.equals("Add Customer profiles")){
//            new Add_Customer().setVisible(true);
//        }else if(comd.equals("View Customer Profiles")){
//            new View_Customer_profiles().setVisible(true);
//        }
//        else if(comd.equals("Update Customer Details")){
//            new Update_Customer().setVisible(true);
//        }else if(comd.equals("Book Cab")){
//            new Book_Cab().setVisible(true);
//        }else if(comd.equals("View Booked Cab")){
//            new View_BookedCab().setVisible(true);
//        }else if(comd.equals("Book Package")){
//            new Book_Package().setVisible(true);
//        }else if(comd.equals("View Booked Package")){
//            new View_Booked_Package().setVisible(true);
//        }else if(comd.equals("Check Bill")){
//            new CheckBill().setVisible(true);
//        }else if(comd.equals("Delete Customer")){
//            new Delete_Customer().setVisible(true);
//        }else if(comd.equals("About")){
//            new About().setVisible(true);
//        }else if(comd.equals("Exit")){
//            System.exit(0);
//        }
    }
    public static void main(String [] args){
        new HomePage().setVisible(true);
    }
}
