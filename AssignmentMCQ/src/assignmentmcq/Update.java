
package assignmentmcq;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Update extends JFrame implements ActionListener{
    JLabel lblusername,lblfirstname,lbllastname,lblpassword,lbladdress,lblemail;
    
    JTextField txtfirstname,txtlastname,txtusername,txtaddress,txtemail;
    JPasswordField passfield;
    JButton btnupdate,btnback;
    Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public Update()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Update Profile");
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
       
       btnupdate= new JButton("Update");
       btnback= new JButton("Back");
       btnback.setFont(f3);btnupdate.setFont(f3);
       
       btnupdate.setBounds(150, 320, 100, 30);
       btnback.setBounds(350, 10, 90, 30);
       c.add(btnupdate);c.add(btnback);
       
       //JLabel lbl=new JLabel("Already have an account?");
       //lbl.setBounds(150, 358, 200, 30);
       //c.add(lbl);
       
       btnupdate.addActionListener(this);
       btnback.addActionListener(this);
       btnupdate.setBackground(Color.cyan);
       //btnback.setBackground(Color.lightGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnupdate)
        {
            try {
                DBconnection db=new DBconnection();              
                int result=db.updateviaemail(txtfirstname.getText(),txtlastname.getText(),txtusername.getText(),txtaddress.getText(),txtemail.getText(),passfield.getText());
                if(result>0)
                {
                    JOptionPane.showMessageDialog(null,"Your profile is updated successfully");
                    txtaddress.setText("");txtemail.setText("");txtfirstname.setText("");
                    txtlastname.setText("");txtusername.setText("");passfield.setText("");   
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Unable to update. Please enter correct Email");
                   // txtaddress.setText("");txtemail.setText("");txtfirstname.setText("");
                   // txtlastname.setText("");txtusername.setText("");passfield.setText("");
                }   
        }
            catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
    }
        if(e.getSource()==btnback)
        {
            new UserDashboard(null).setVisible(true);
            dispose();
        }
    
}
}
