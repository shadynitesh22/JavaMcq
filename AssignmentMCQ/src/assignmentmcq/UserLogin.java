
package assignmentmcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class UserLogin extends JFrame implements ActionListener{
   JLabel lblusername,lblpassword,lbltoken;
   JTextField txtusername;
   JPasswordField txtpass;
   JButton btnlogin,btnregister,btnhome;
   Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 15);
   
   public UserLogin() throws SQLException
   {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("User Login");
        Container c = getContentPane();
        c.setLayout(null);
       
       lblusername=new JLabel("Username");
       lblpassword=new JLabel("Password");
       lbltoken=new JLabel();
       
       lblusername.setBounds(10, 20, 150, 30);
       lblpassword.setBounds(10, 60, 150, 30);
       lbltoken.setBounds(200, 60, 150, 30);
       lblusername.setFont(f2);
       lblpassword.setFont(f2);
       
       c.add(lblusername);c.add(lblpassword);c.add(lbltoken);
       
       txtusername=new JTextField();
       txtusername.setBounds(100, 20, 150, 30);
       add(txtusername);
       
       txtpass=new JPasswordField(); 
       txtpass.setBounds(100, 60, 150, 30);
       c.add(txtpass);
       
       btnlogin= new JButton("Login");
       btnlogin.setBounds(100, 120, 100, 30);
       c.add(btnlogin);
       
       btnregister= new JButton("Register");
       btnregister.setBounds(100, 200, 100, 30);
       c.add(btnregister);
       btnlogin.addActionListener(this);
       btnregister.addActionListener(this);
       
       btnlogin.setBackground(Color.CYAN);
       btnregister.setBackground(Color.lightGray);
       btnlogin.setFont(f2);
       btnregister.setFont(f2);
       
       btnhome=new JButton("Home");
       btnhome.setBounds(350, 15, 100, 30);
       btnhome.setFont(f2);
       c.add(btnhome); btnhome.addActionListener(this);
       
       JLabel lbl=new JLabel("Don't have account?");
       lbl.setBounds(100, 170, 200, 30);
       c.add(lbl);
       
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnlogin)
        {
            try {
                    if(txtusername.getText().equals("") || String.valueOf(txtpass.getPassword()).equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"One or more fields are empty");
                        return;
                    }
            }
            catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
                try {
                        DBconnection db=new DBconnection();
                        String sql="select * from tbl_users where username=? and password=?";
                        PreparedStatement pst= db.conn.prepareStatement(sql);
                        pst.setString(1, txtusername.getText());
                        pst.setString(2, txtpass.getText());
                        ResultSet rs=pst.executeQuery();

                        if(rs.next())
                        {
                            JOptionPane.showMessageDialog(null,"Login Success");
                            new UserDashboard(txtusername.getText()).setVisible(true);
                            dispose();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Incorrect username or password");
                            txtusername.setText("");
                            txtpass.setText("");
                        }
                    } 
                catch (Exception ex) {
                    System.out.println("Error: "+ex);
                }

        }
        
        if (e.getSource()==btnregister)
        {
            new UserRegister().setVisible(true);
            dispose();
            
        }
    }
}
