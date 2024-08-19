
package Model;

import DB.DbConnector;
import DTO.UserDTO;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrationAuthenticator {

    public boolean isRegistration(UserDTO emp) {
    
     String username=emp.getUsername();
     String age=emp.getAge();
        
     try
     {
         Statement st=DbConnector.getStatement();
         
   String query="insert into userprofile(username,age) values('"+username+"','"+age+"')";

           
           System.out.println("Query = "+query);

         
          
          st.executeUpdate(query);
         
      }
     catch(SQLException e)
       {
         System.out.println(e);
       }
     
      if(username != null && age != null)
      { 
          return true;
      } 
        
      return false;
 }
    
}
