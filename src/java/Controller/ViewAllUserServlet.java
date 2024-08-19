
package Controller;
import DAO.AllviewDAO;
import DTO.AllviewDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewAllUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AllviewDTO allviewDTO = new AllviewDTO();
        AllviewDAO allviewDAO = new AllviewDAO();
        allviewDAO.getset(allviewDTO);
        
        HttpSession session = request.getSession();
        session.setAttribute("allview", allviewDTO);
        
        response.sendRedirect("Emp.jsp");
    }
}
