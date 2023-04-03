
package cab_booking_system;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class View_BookedCab extends JFrame{
    
    Font f;
    JTable t1;
    String[] x = {"booking ID","username","Driver Name","Car","Source","Destination","Price"};
    String[][] y = new String[100][10];
    int i=0,j=0;
    
    View_BookedCab(){
        super ("All Booked cab records");
        setSize(1300,400);
        setLocation(0,10);
        f = new Font("MS UI Gothic",Font.BOLD,17);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "select * from intracitycab";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
               y[i][j++] = rest.getString("bid");
               y[i][j++] = rest.getString("username");
               y[i][j++] = rest.getString("DName");
               y[i][j++] = rest.getString("Car");
               y[i][j++] = rest.getString("DFrom");
               y[i][j++] = rest.getString("FTo");
               y[i][j++] = rest.getString("Price");  
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
        new View_BookedCab().setVisible(true);
    }
}
