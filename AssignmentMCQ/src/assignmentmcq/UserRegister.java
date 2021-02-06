
package assignmentmcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UserRegister extends JFrame implements ActionListener{
    JLabel lblusername,lblfirstname,lbllastname,lblpassword,lbladdress,lblemail;
    
    JTextField txtfirstname,txtlastname,txtusername,txtaddress,txtemail;
    JPasswordField passfield;
    JButton btnreg,btnlogin,btnhome;
    Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public  UserRegister()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("User Registration");
        Container c = getContentPane();
        c.setLayout(null);
       
       lblfirstname=new JLabel("First Name");
       lbllastname=new JLabel("Last Name");
       lblusername=new JLabel("Username");
       lbladdress=new JLabel("Address");
       lblemail=new JLabel("Email");
       lblpassword=new JLabel("Password");
       
       
       lblfirstname.setBounds(10, 10, 150, 30);
       lbllastname.setBounds(10, 60, 150, 30);
       lblusername.setBounds(10, 110, 150, 30);
       lbladdress.setBounds(10, 160, 150, 30);
       lblemail.setBounds(10, 210, 150, 30);
       lblpassword.setBounds(10, 260, 150, 30);
       
       lblfirstname.setFont(f3);lbllastname.setFont(f3);lblusername.setFont(f3);
       lbladdress.setFont(f3);lblemail.setFont(f3);lblpassword.setFont(f3);
       
       c.add(lblfirstname);c.add(lbllastname);c.add(lblusername);
       c.add(lbladdress);c.add(lblemail);c.add(lblpassword);
     
       txtfirstname=new JTextField();
       txtlastname=new JTextField();
       txtusername=new JTextField();
       txtaddress=new JTextField();
       txtemail=new JTextField();
       passfield=new JPasswordField();
 
       txtfirstname.setBounds(150, 10, 150, 30);
       txtlastname.setBounds(150, 60, 150, 30);
       txtusername.setBounds(150, 110, 150, 30);
       txtaddress.setBounds(150, 160, 150, 30);
       txtemail.setBounds(150, 210, 150, 30);
       passfield.setBounds(150, 260, 150, 30);
       
       c.add(txtfirstname);c.add(txtlastname);c.add(txtusername);
       c.add(txtaddress);c.add(txtemail);c.add(passfield);
       
       btnreg= new JButton("Register");
       btnlogin= new JButton("Login");
       btnlogin.setFont(f3);btnreg.setFont(f3);
       
       btnreg.setBounds(150, 320, 100, 30);
       btnlogin.setBounds(150, 385, 100, 30);
       c.add(btnreg);c.add(btnlogin);
       
       JLabel lbl=new JLabel("Already have an account?");
       lbl.setBounds(150, 358, 200, 30);
       c.add(lbl);
       
       btnhome=new JButton("Home");
       btnhome.setBounds(350, 10, 100, 30);
       btnhome.setFont(f3);
       c.add(btnhome); btnhome.addActionListener(this);
       
       btnreg.addActionListener(this);
       btnlogin.addActionListener(this);
       btnreg.setBackground(Color.cyan);
       btnlogin.setBackground(Color.lightGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnreg)
        {
            try {
                
                
                DBconnection db=new DBconnection();
                String sql="select * from tbl_users where username=?";
                PreparedStatement pst= db.conn.prepareStatement(sql);
                pst.setString(1, txtusername.getText());
                ResultSet rs=pst.executeQuery();
                
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"Username already exists. Please try again with another Username");
                    return;
                }
                
                
                int result=db.save(txtfirstname.getText(),txtlastname.getText(),txtusername.getText(),txtaddress.getText(),txtemail.getText(),passfield.getText());
                if(result>0)
                {
                    JOptionPane.showMessageDialog(null,"Saved in Database");
                    txtaddress.setText("");txtemail.setText("");txtfirstname.setText("");
                    txtlastname.setText("");txtusername.setText("");passfield.setText("");   
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null,"Unable to save in Database");
                    //txtaddress.setText("");txtemail.setText("");txtfirstname.setText("");
                    //txtlastname.setText("");txtusername.setText("");passfield.setText("");
                }   
            } 
            catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
        }
        
        if(e.getSource()==btnlogin)
        {
            try {
                new UserLogin().setVisible(true);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource()==btnhome)
            {
               new AssignmentMCQ().setVisible(true);
               dispose();
            }
    }
}
