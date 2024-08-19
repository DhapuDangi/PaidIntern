
package Controller;

import DTO.UserDTO;
import Model.RegistrationAuthenticator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationChecker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addUser.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieving parameters from the request
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        // Debugging: Check if parameters are null
        if (username == null || age == null) {
            response.sendRedirect("addUser.jsp");
            return;
        }

        // Creating a UserDTO object to hold the user data
        UserDTO emp = new UserDTO();
        emp.setUsername(username);
        emp.setAge(age);

        // Debugging: Check if UserDTO object is correctly populated
        System.out.println("UserDTO - Username: " + emp.getUsername() + ", Age: " + emp.getAge());

        // Using RegistrationAuthenticator to check if registration is valid
        RegistrationAuthenticator authenticator = new RegistrationAuthenticator();
        boolean registration = authenticator.isRegistration(emp);

        // Debugging: Check the result of the registration check
        System.out.println("Registration status: " + registration);

        // Handling the result of the registration check
        if (registration) {
            // Creating a session and setting attributes
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("age", age);
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("addUser.jsp");
        }
    }
}

