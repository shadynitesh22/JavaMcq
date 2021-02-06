
package assignmentmcq;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AddQuestions extends JFrame implements ActionListener {
   JLabel lblhead,lblsub,lblques,opt1,opt2,opt3,opt4,correctans;
   JTextField txtques,txtopt1,txtopt2,txtopt3,txtopt4,txtcorrectans;
   JButton btnadd,btnclear;
   JComboBox com;
   Font  f  = new Font(Font.DIALOG,  Font.BOLD, 20);
   Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 15);
   
   public AddQuestions()
   {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setTitle("Add Questions");
        Container c = getContentPane();
        c.setLayout(null);
         
       lblhead=new JLabel("Add Questions");
       lblsub=new JLabel("Choose Subject");
       lblques=new JLabel("Question");
       opt1=new JLabel("Option 1");
       opt2=new JLabel("Option 2");
       opt3=new JLabel("Option 3");
       opt4=new JLabel("Option 4");
       correctans=new JLabel("Correct Answer");
       
       txtques=new JTextField();
       txtopt1=new JTextField();
       txtopt2=new JTextField();
       txtopt3=new JTextField();
       txtopt4=new JTextField();
       txtcorrectans=new JTextField();
       btnadd=new JButton("Add");
       btnclear=new JButton("Clear");
       
       com = new JComboBox();
       com.addItem("Biology");
       com.addItem("Chemistry");
       com.addItem("Physics");
       
       lblhead.setFont(f);lblques.setFont(f2);lblsub.setFont(f2);btnadd.setFont(f2);btnclear.setFont(f2);txtques.setFont(f2);
       txtopt1.setFont(f2);txtopt2.setFont(f2);txtopt3.setFont(f2);txtopt4.setFont(f2);txtcorrectans.setFont(f2);
       opt1.setFont(f2);opt2.setFont(f2);opt3.setFont(f2);opt4.setFont(f2);correctans.setFont(f2);
       
       lblhead.setBounds(20, 20, 150, 40);
       lblsub.setBounds(20, 80, 150, 30);
       com.setBounds(150, 80, 100, 30);
       txtques.setBounds(150, 140, 400, 30);
       txtopt1.setBounds(150, 200, 150, 30);
       txtopt2.setBounds(150, 260, 150, 30);
       txtopt3.setBounds(150, 320, 150, 30);
       txtopt4.setBounds(150, 380, 150, 30);
       txtcorrectans.setBounds(150, 440, 150, 30);
       
       lblques.setBounds(20, 140, 150, 30);
       opt1.setBounds(20, 200, 150, 30);
       opt2.setBounds(20, 260, 150, 30);
       opt3.setBounds(20, 320, 150, 30);
       opt4.setBounds(20, 380, 150, 30);
       correctans.setBounds(20, 440, 150, 30);
      
       btnadd.setBounds(100, 500, 100, 30);
       btnclear.setBounds(250, 500, 100, 30);
       
       c.add(lblhead);c.add(lblques);c.add(lblsub);c.add(opt1);c.add(opt2);c.add(opt3);c.add(opt4);c.add(correctans);
       c.add(com);c.add(btnadd);c.add(btnclear);c.add(txtques);c.add(txtopt1);c.add(txtopt2);c.add(txtopt3);c.add(txtopt4);c.add(txtcorrectans);
       
       btnadd.addActionListener(this);btnclear.addActionListener(this);
       com.addActionListener(this);
       
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(btnadd))
        {
            try{
   
            DBconnection db=new DBconnection();
            int result;

                if(com.getSelectedItem().equals("Chemistry"))
                {
                    result=db.addchem(txtques.getText(),txtopt1.getText(),txtopt2.getText(),txtopt3.getText(),txtopt4.getText(),txtcorrectans.getText());
                    if(result>0)
                    {
                        JOptionPane.showMessageDialog(null,"Question added in Chemistry");
                        return;
                    }
                }
            
                  if(com.getSelectedItem().equals("Physics"))
                {
                    result=db.addphysics(txtques.getText(),txtopt1.getText(),txtopt2.getText(),txtopt3.getText(),txtopt4.getText(),txtcorrectans.getText());
                    if(result>0)
                    {
                        JOptionPane.showMessageDialog(null,"Question added in Physics");
                        return;
                    }
                }
    
                 if(com.getSelectedItem().equals("Biology"))
                {
                    result=db.addbio(txtques.getText(),txtopt1.getText(),txtopt2.getText(),txtopt3.getText(),txtopt4.getText(),txtcorrectans.getText());
                    if(result>0)
                    {
                        JOptionPane.showMessageDialog(null,"Question added in Biology");
                        return;
                    }
                }
              
        }
            catch (Exception ex) 
            {
                System.out.println("Error: "+ex);
            }
    }
        
        if(e.getSource().equals(btnclear))
        {
            txtques.setText("");txtcorrectans.setText("");txtopt1.setText("");txtopt2.setText("");txtopt3.setText("");txtopt4.setText("");
        }
}
    
}
    

