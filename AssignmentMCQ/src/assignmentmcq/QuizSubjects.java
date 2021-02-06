/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentmcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class QuizSubjects extends JFrame implements ActionListener{
    JLabel lblselect;
    JRadioButton rbtn1,rbtn2,rbtn3;
    JButton btnstart,btnhome,btnback;
    Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 20);
    Font  f2  = new Font(Font.DIALOG,  Font.BOLD, 15);
    
    public QuizSubjects()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("User Login");
        Container c = getContentPane();
        c.setLayout(null);
        
        lblselect=new JLabel("Select One Subject");
        rbtn1=new JRadioButton("Physics");
        rbtn2=new JRadioButton("Biology");
        rbtn3=new JRadioButton("Chemistry");
        btnstart=new JButton("Start Quiz");
        btnhome=new JButton("Home");
        btnback=new JButton("Back");
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbtn1);
        bg.add(rbtn2);
        bg.add(rbtn3);
        
        lblselect.setFont(f1);rbtn1.setFont(f2);rbtn2.setFont(f2);rbtn3.setFont(f2);
        btnstart.setFont(f2);btnhome.setFont(f2);btnback.setFont(f2);
        
        lblselect.setBounds(50, 20, 200, 40);
        rbtn1.setBounds(50, 100, 100, 30);
        rbtn2.setBounds(50, 140, 100, 30);
        rbtn3.setBounds(50, 180, 100, 30);
        btnstart.setBounds(50, 240, 150, 30);
        btnhome.setBounds(300, 20, 90, 30);
        btnback.setBounds(300, 60, 90, 30);
        
        c.add(lblselect);c.add(rbtn1);c.add(rbtn2);c.add(rbtn3);
        c.add(btnstart);c.add(btnhome);c.add(btnback);
        
        btnhome.addActionListener(this);
        btnback.addActionListener(this);
        btnstart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnstart)
        {
            try
            {
                if(rbtn1.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Your quiz of "+rbtn1.getText()+" will start now!");
                    new PhysicsQuiz().setVisible(true);
                    dispose();
                }
                else if(rbtn2.isSelected())
                {
                    JOptionPane.showMessageDialog(null,"Your quiz of "+rbtn2.getText()+" will start now!");
                    new AssignmentMCQ().setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Your quiz of "+rbtn3.getText()+" will start now!");
                    new AssignmentMCQ().setVisible(true);
                    dispose();
                }
                
            }
            catch (Exception ex) {
                System.out.println("Error: "+ex);
            }
            
        }
        
        if(e.getSource()==btnhome)
        {
            try
            {
                new AssignmentMCQ().setVisible(true);
                dispose();
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
