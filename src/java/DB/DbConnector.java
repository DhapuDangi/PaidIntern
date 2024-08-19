
package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnector {
    
    private static Connection con=null;
    private static Statement st=null;
    static{
        try{
              Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainAllocationSystem","root","root");
                     System.out.println("Connected");
                     st=con.createStatement();
                            
        }
     
        catch (ClassNotFoundException ex) {
                        System.out.println(ex);
        }
                        catch (SQLException ex) {
                        System.out.println(ex);

        }
    }
         
    public static Connection getConnection()
    {
        return con;
    }
     public static java.sql.Statement getStatement()
    {
        return st;
    }
    
          
    
}
