
package assignmentmcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminLogin extends JFrame implements ActionListener {
   JLabel lblusername,lblpassword;
   JTextField txtusername;
   JPasswordField txtpass;
   JButton btnlogin,btnhome;
   Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public AdminLogin()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Admin Login");
        Container c = getContentPane();
        c.setLayout(null);
        
        lblusername=new JLabel("Username");
       lblpassword=new JLabel("Password");
       
       lblusername.setBounds(10, 20, 150, 30);
       lblpassword.setBounds(10, 60, 150, 30);
       lblusername.setFont(f2);
       lblpassword.setFont(f2);
       
       c.add(lblusername);c.add(lblpassword);
       
       txtusername=new JTextField();
       txtusername.setBounds(100, 20, 150, 30);
       add(txtusername);
       
       txtpass=new JPasswordField(); 
       txtpass.setBounds(100, 60, 150, 30);
       c.add(txtpass);
       
       btnlogin= new JButton("Login");
       btnlogin.setBounds(100, 120, 100, 30);
       c.add(btnlogin);
       
       btnhome=new JButton("Back");
       btnhome.setBounds(350, 15, 100, 30);
       c.add(btnhome);btnhome.setFont(f2);

       btnlogin.setBackground(Color.CYAN);
       btnlogin.setFont(f2);
       
       btnlogin.addActionListener(this);
       btnhome.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String a=txtusername.getText();
            String b=txtpass.getText();

            String username="sagun";
            String password="abcd";
        
            try
            {
                if(e.getSource()==btnlogin)
            {
               
                if(username.equals(a)&& password.equals(b))
                { 
                    new AddQuestions().setVisible(true);
                    dispose();
                }
            }
        }
            catch (Exception ex) 
            {
                System.out.println("Error: "+ex);
            }
            
            if(e.getSource()==btnhome)
            {
               new AssignmentMCQ().setVisible(true);
               dispose();
            }
    }            
   
}
