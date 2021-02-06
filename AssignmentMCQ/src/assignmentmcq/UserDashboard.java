
package assignmentmcq;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UserDashboard extends JFrame implements ActionListener{
    JButton btnupdate,btnquiz,btnback;
    JLabel lbl1,lbl2;
    JTextField txt1,txt2;
    Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public UserDashboard(String u)
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("User Dashboard");
        Container c = getContentPane();
        c.setLayout(null);
        
        btnback=new JButton("Back");
        btnupdate=new JButton("Update Profile");
        btnquiz=new JButton("Take Quiz");
        lbl1=new JLabel("Token");
        lbl2=new JLabel("Enter your token");
        txt1=new JTextField(u+"563");
        txt2=new JTextField();
        
        lbl1.setBounds(20, 50, 150, 30);
        lbl2.setBounds(20, 110, 150, 30);
        txt1.setBounds(150, 50, 150, 30);
        txt2.setBounds(150, 110, 150, 30);
        
        
        
        btnupdate.setBounds(150, 150, 150, 40);
        btnquiz.setBounds(150, 210, 150, 40);
        btnback.setBounds(350, 20, 100, 40);
        
        btnback.setFont(f2);btnquiz.setFont(f2);btnupdate.setFont(f2);
        c.add(btnback);c.add(btnquiz);c.add(btnupdate);c.add(lbl1);c.add(lbl2);
        c.add(txt1);c.add(txt2);
        
        btnback.addActionListener(this);
        btnquiz.addActionListener(this);
        btnupdate.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnupdate)
        {
            new Update().setVisible(true);
            dispose();
        }
        
        if(e.getSource()==btnquiz)
        {
            if(txt2.getText().equals(txt1.getText())){
            new QuizSubjects().setVisible(true);
            dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Incorrect Token!!");
            }
        }
        
        if(e.getSource()==btnback)
        {
            try {
                new UserLogin().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(UserDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
        
    }
    
}
