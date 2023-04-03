
package cab_booking_system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import static java.awt.Color.*;
import java.awt.event.*;


public class View_Customer_profiles extends JFrame{
 
    Font f;
    JTable t1;
    String[] x = {"Username","Name","Age","Date of Birth","Address","Phone","Email","Country","Gender","Aadhar"};
    String[][] y = new String[100][10];
    int i=0,j=0;
    
    View_Customer_profiles(){
        super ("All Customer Details");
        setSize(1300,400);
        setLocation(0,10);
        f = new Font("MS UI Gothic",Font.BOLD,17);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from customer";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
               y[i][j++] = rest.getString("username");
               y[i][j++] = rest.getString("name");
               y[i][j++] = rest.getString("age");
               y[i][j++] = rest.getString("dob");
               y[i][j++] = rest.getString("address");
               y[i][j++] = rest.getString("phone");
               y[i][j++] = rest.getString("email");
               y[i][j++] = rest.getString("country");
               y[i][j++] = rest.getString("gender");
               y[i][j++] = rest.getString("aadhar");   
               i++;
               j=0;
            }
            t1 = new JTable(y,x);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        t1.setFont(f);
        t1.setBackground(black);
        t1.setForeground(white);
        
        JScrollPane js = new JScrollPane(t1);
        add(js);
    }
    public static void main(String [] args){
        
        new View_Customer_profiles().setVisible(true);
    }
}
