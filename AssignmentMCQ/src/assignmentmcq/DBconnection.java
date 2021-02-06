
package assignmentmcq;

import java.sql.*;

public class DBconnection {
    public Connection conn;
    PreparedStatement pst,pst2;
    
    
    public DBconnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_mcq", "root", "");
            ResultSet rs=null;
            
        } catch (Exception ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    
    
    public  int save(String first_name, String last_name, String username, String address, String email, String password)
    {
        int result=0;
        try {
            pst=conn.prepareStatement("insert into tbl_users values(null,?,?,?,?,?,?)");
            pst.setString(1,first_name);
            pst.setString(2,last_name);
            pst.setString(3,username);
            pst.setString(4,address);
            pst.setString(5,email);
            pst.setString(6,password);
            result=pst.executeUpdate();
        } 
        catch (Exception ex) {
            System.out.println("Error: "+ex);
        }
            return result;
    }
    
    public int addbio(String question,String opt1,String opt2,String opt3,String opt4,String correctans)
    {
        int result=0;
        try {
            pst=conn.prepareStatement("INSERT INTO tbl_bio VALUES (null,?,?,?,?,?,?)");
            pst.setString(1,question);
            pst.setString(2,opt1);
            pst.setString(3,opt2);
            pst.setString(4,opt3);
            pst.setString(5,opt4);
            pst.setString(6,correctans);
            result=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
            return result;
    }
    
    public int addphysics(String question,String opt1,String opt2,String opt3,String opt4,String correctans)
    {
        int result=0;
        try {
            pst=conn.prepareStatement("INSERT INTO tbl_physics VALUES (null,?,?,?,?,?,?)");
            pst.setString(1,question);
            pst.setString(2,opt1);
            pst.setString(3,opt2);
            pst.setString(4,opt3);
            pst.setString(5,opt4);
            pst.setString(6,correctans);
            result=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
            return result;
    }
    
    public int addchem(String question,String opt1,String opt2,String opt3,String opt4,String correctans)
    {
        int result=0;
        try {
            pst=conn.prepareStatement("INSERT INTO tbl_chem VALUES (null,?,?,?,?,?,?)");
            pst.setString(1,question);
            pst.setString(2,opt1);
            pst.setString(3,opt2);
            pst.setString(4,opt3);
            pst.setString(5,opt4);
            pst.setString(6,correctans);
            result=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
            return result;
    }
    
    public int updateviaemail(String first_name,String last_name,String username,String address,String email,String password)
    {
        int result=0;
        try {
            pst=conn.prepareStatement("update tbl_users set first_name=?, last_name=?, username=?, address=?, password=? where email=?");
            pst.setString(1,first_name);
            pst.setString(2,last_name);
            pst.setString(3,username);
            pst.setString(4,address);
            pst.setString(5,password);
            pst.setString(6,email);
            
            result=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
    public int updateviausername(String first_name,String last_name,String username,String address,String email,String password)
    {
        int result2=0;
        try {
            pst2=conn.prepareStatement("update tbl_users set first_name=?, last_name=?, address=?, email=?, password=? where username=?");
            pst2.setString(1,first_name);
            pst2.setString(2,last_name);
            pst2.setString(3,address);
            pst2.setString(4,email);
            pst2.setString(5,password);
            pst2.setString(6,username);
            
            
            result2=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result2;
        
    }
}
