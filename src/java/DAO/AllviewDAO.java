package DAO;
import DB.DbConnector;
import DTO.AllviewDTO;
import DTO.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class AllviewDAO {

    public void getset(AllviewDTO user) {
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = DbConnector.getStatement();

            String query = "SELECT u.user_login_id, u.username, u.age, " +
               "t.train_id, t.boogie_number, t.seat_number " +
               "FROM userprofile u " +
               "LEFT JOIN trainallocation t ON u.user_login_id = t.user_login_id";

            rs = st.executeQuery(query);
            
            Vector<UserDTO> arr = new Vector<UserDTO>();
            
            while (rs.next()) {
                UserDTO s1 = new UserDTO();
                s1.setUser_login_id(rs.getString(1));
                s1.setUsername(rs.getString(2));
                s1.setAge(rs.getString(3));
                s1.setTrain_id(rs.getString(4));
                s1.setBoogie_number(rs.getString(5));
                s1.setSeat_number(rs.getString(6));
                arr.add(s1);
            }
            
            user.setArr(arr);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
