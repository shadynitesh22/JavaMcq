
package assignmentmcq;

import java.util.*;
import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*;
import java.sql.*;


public class PhysicsQuiz extends JFrame implements ActionListener{
    JLabel lbl;  
    JRadioButton[] rdbtn=new JRadioButton[5]; //for options of the question  
    JButton btnnext;  
    ButtonGroup btngrp;  
    int count=0,current=-1; 
    //long StartTime, EndTime,seconds,minutes,flag=0;; 
    int a;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public PhysicsQuiz()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setTitle("Quiz");
        Container c = getContentPane();
        c.setLayout(null);
        
        lbl=new JLabel();  
        add(lbl);  
        btngrp=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            rdbtn[i]=new JRadioButton();     
            add(rdbtn[i]);  
            btngrp.add(rdbtn[i]);  
        }
        
        btnnext=new JButton("Next"); 
       
        btnnext.addActionListener(this); 
        
        add(btnnext);
        
        lbl.setBounds(30,40,450,20);  //labels question area
     
        btnnext.setBounds(270,240,100,30);  
      
          
    }
void setnext() //function to set next question 
    {  
        rdbtn[4].setSelected(true);  
        
        try
        {
            DBconnection db=new DBconnection();
         
          pst=db.conn.prepareStatement("select * from tbl_physics");
            if(current==0)  
            {    
                String sql="select * from tbl_physics where Q_No=1"; 
                pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(sql); 
                if(rs.next()){  
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
              
                lbl.setText("Q.1 "+s1); 
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);}
                
               
            }  
            if(current==1)  
            {  
                String sql="select * from tbl_physics where Q_No=2";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(sql);
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.2 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);
                }
            }  
            if(current==2)  
            {  
                String sql="select * from tbl_physics where Q_No=3";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.3 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);  
                
            }  
            if(current==3)  
            {  
                String sql="select * from tbl_physics where Q_No=4";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.4 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);
                }
            }  
            if(current==4)  
            {  
                String sql="select * from tbl_physics where Q_No=5";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.5 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5); 
                }
            }  
            if(current==5)  
            {  
                String sql="select * from tbl_physics where Q_No=6";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.6 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);  
                }
            }  
            if(current==6)  
            {  
                String sql="select * from tbl_physics where Q_No=7";
                pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.7 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5); 
                }
            }  
            if(current==7)  
            {  
                String sql="select * from tbl_physics where Q_No=8";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.8 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);  
                }
            }  
            if(current==8)  
            {  
                String sql="select * from tbl_physics where Q_No=9";
                 pst=db.conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.9 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5); 
                }
            }  
            if(current==9)  
            {  
                String sql="select * from tbl_physics where Q_No=10";
                pst=db.conn.prepareStatement(sql);
                rs = pst.executeQuery();
                if(rs.next()){
                String s1 =rs.getString("question");
                String s2 =rs.getString("opt1"); 
                String s3 =rs.getString("opt2"); 
                String s4 =rs.getString("opt3");
                String s5 =rs.getString("opt4");
                lbl.setText("Q.10 "+s1);  
                rdbtn[0].setText(s2);rdbtn[1].setText(s3);rdbtn[2].setText(s4);rdbtn[3].setText(s5);
                }
            }  
            lbl.setBounds(30,40,450,20);  
            for(int i=0,j=0;i<=90;i+=30,j++)  
                rdbtn[j].setBounds(50,80+i,200,20);  
        }   
        catch(Exception e)
        {
            System.out.println("setnext\n"+e);
        }
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnnext)
    {  current++;
            setnext();
           
    }
    }
}
