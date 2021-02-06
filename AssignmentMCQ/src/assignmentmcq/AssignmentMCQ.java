
package assignmentmcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class AssignmentMCQ extends JFrame implements ActionListener{
  
    JButton btnadmin,btnuser;
    Font  f  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public AssignmentMCQ(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Dashboard");
        Container c = getContentPane();
        c.setLayout(null);
        
        btnadmin=new JButton("Admin Login");
        btnuser=new JButton("User Login");
        btnadmin.setBounds(60, 200, 150, 40);
        btnuser.setBounds(250, 200, 150, 40);
        c.add(btnadmin);c.add(btnuser);
        btnuser.addActionListener(this);
        btnadmin.addActionListener(this);
        btnuser.setFont(f);btnadmin.setFont(f);
        
        
}
    
    public static void main(String[] args) {
        new AssignmentMCQ().setVisible(true);
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnuser) {
            try {
                new UserLogin().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AssignmentMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();  
        }
        
        if (e.getSource()==btnadmin) 
        {
            new AdminLogin().setVisible(true);
            dispose();  
        }
    }
}

