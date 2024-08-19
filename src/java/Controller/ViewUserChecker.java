

package Controller;

import DAO.UserDAO;
import DTO.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewUserChecker extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HttpSession session = req.getSession(true);

        UserDAO userDao = new UserDAO();          
        UserDTO user = new UserDTO();
        user.setUser_login_id(id);

        boolean success = userDao.getSetData(user);

        if (success) {
            session.setAttribute("viewobj", user);
        } else {
            session.setAttribute("error", "User not found.");
        }
        resp.sendRedirect("viewoneUser.jsp");
    }
}
