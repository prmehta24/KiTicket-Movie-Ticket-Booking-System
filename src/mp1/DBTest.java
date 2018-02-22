/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iis
 */
public class DBTest {
  

    public DBTest() {
       
    }
    public static void main(String args[])
    {
        
  String host = "jdbc:derby://localhost:1527/Users";


String uName = "username";
String uPass= "password";
    
     try {
            Connection con;
      con = DriverManager.getConnection( host,uName,uPass);
      Statement stmt = con.createStatement( );
      String SQL = "SELECT * FROM Users";
        } catch (SQLException ex) {
            Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
