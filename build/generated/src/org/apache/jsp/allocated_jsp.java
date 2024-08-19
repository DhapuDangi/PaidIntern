package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class allocated_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Seat Allocation Result</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n");
      out.write("    />\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"light gray\">\n");

    String userLoginId = request.getParameter("userLoginId");
    int trainChoice = Integer.parseInt(request.getParameter("trainChoice"));

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainallocationsystem", "root", "root");

        // Check if the user_login_id exists in the userprofile table
        String userCheckQuery = "SELECT COUNT(*) FROM userprofile WHERE user_login_id = ?";
        pstmt = conn.prepareStatement(userCheckQuery);
        pstmt.setString(1, userLoginId);
        rs = pstmt.executeQuery();

        rs.next();
        int userExists = rs.getInt(1);

        if (userExists == 0) {
            out.println("<h2>Error: The user_login_id " + userLoginId + " does not exist.</h2>");
        } else {
            // Proceed with seat allocation since the user_login_id exists
            String seatQuery = "SELECT boogie_number, seat_number FROM trainallocation " +
                                "WHERE train_id = ? ORDER BY boogie_number, seat_number DESC LIMIT 1";
            pstmt = conn.prepareStatement(seatQuery);
            pstmt.setInt(1, trainChoice);
            rs = pstmt.executeQuery();

            int nextBoogie = 1;
            int nextSeat = 1;

            if (rs.next()) {
                int lastBoogie = rs.getInt("boogie_number");
                int lastSeat = rs.getInt("seat_number");

                // Determine next boogie and seat
                if (lastSeat == 2) {
                    nextBoogie = lastBoogie + 1;
                    nextSeat = 1;
                } else {
                    nextBoogie = lastBoogie;
                    nextSeat = lastSeat + 1;
                }
            }

            // Check if the allocation exceeds the number of boogies
            if (nextBoogie > 3) {
                out.println("<h2>Sorry, no available seats in Train " + trainChoice + ".</h2>");
            } else {
                // Insert seat allocation
                String insertSQL = "INSERT INTO trainallocation (train_id, boogie_number, seat_number, user_login_id) " +
                                   "VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(insertSQL);
                pstmt.setInt(1, trainChoice);
                pstmt.setInt(2, nextBoogie);
                pstmt.setInt(3, nextSeat);
                pstmt.setString(4, userLoginId);
                pstmt.executeUpdate();

                out.println("<h2>Seat successfully allocated:</h2>");
                out.println("<p>Train: " + trainChoice + "</p>");
                out.println("<p>Boogie: " + nextBoogie + "</p>");
                out.println("<p>Seat: " + nextSeat + "</p>");
            }
        }
    } catch (SQLException e) {
        out.println("<h2>Error: " + e.getMessage() + "</h2>");
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
