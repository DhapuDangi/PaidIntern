package Model;

import DAO.UserDAO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddUser extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDTO s1 = new UserDTO();
            s1.setUsername(req.getParameter("username"));
            s1.setAge(req.getParameter("age"));

            UserDAO d1 = new UserDAO();
            boolean f = d1.addUser(s1);

            if (f) {
                resp.sendRedirect("admin.jsp");
            } else {
                resp.sendRedirect("addUser.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            // You can also redirect to an error page or show an error message
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding user");
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Your code here
        
        resp.getWriter().append("hello get");
    }
}