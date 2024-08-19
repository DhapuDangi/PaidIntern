

package DAO;

import DB.DbConnector;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    // Method to add a new user
    public boolean addUser(UserDTO s1) throws SQLException {
        Statement st = DbConnector.getStatement();
        try {
            String query = "INSERT INTO userprofile VALUES('" + s1.getUsername() + "','" + s1.getAge() + "')";
            System.out.println(query);
            boolean rs = st.execute(query);
            System.out.println(rs);
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }

    // Method to get and set data for a specific user
    public boolean getSetData(UserDTO user) {
        Connection con = DbConnector.getConnection();
        String id = user.getUser_login_id();
        try {
            // Using PreparedStatement to safely execute the query
            String query = "SELECT u.user_login_id, u.username, u.age, t.train_id, t.boogie_number, t.seat_number " +
                           "FROM userprofile u " +
                           "LEFT JOIN trainallocation t ON u.user_login_id = t.user_login_id " +
                           "WHERE u.user_login_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                user.setUser_login_id(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setAge(rs.getString(3));
                user.setTrain_id(rs.getString(4));
                user.setBoogie_number(rs.getString(5));
                user.setSeat_number(rs.getString(6));
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return false;
    }
}
