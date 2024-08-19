package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import DTO.UserDTO;
import DTO.AllviewDTO;
import DAO.AllviewDAO;

public final class Emp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

// Initialize the AllviewDTO object and call the DAO to populate it
AllviewDTO allviewDTO = new AllviewDTO();
AllviewDAO dao = new AllviewDAO();
dao.getset(allviewDTO);

// Store the allviewDTO in the session for use in the JSP
session.setAttribute("allview", allviewDTO);

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>View All Users</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"viewallcss.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"nav\">\n");
      out.write("        <div id=\"navlist\">\n");
      out.write("            <div id=\"btn\"><a href=\"index.jsp\">Close</a></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"personal\">\n");
      out.write("            <table>\n");
      out.write("                <tr style=\"color:white\">\n");
      out.write("                    <td><h3>ID</h3></td> \n");
      out.write("                    <td><h3>Username</h3></td>\n");
      out.write("                    <td><h3>Age</h3></td>\n");
      out.write("                    <td><h3>Train Name</h3></td> \n");
      out.write("                    <td><h3>Boogie Number</h3></td> \n");
      out.write("                    <td><h3>Seat Number</h3></td> \n");
      out.write("                </tr>\n");
      out.write("                ");
 
                    if (allviewDTO != null && allviewDTO.getArr() != null && !allviewDTO.getArr().isEmpty()) {
                        Vector<UserDTO> users = allviewDTO.getArr();
                        for (UserDTO user : users) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td><h3>");
      out.print( user.getUser_login_id() );
      out.write("</h3></td>\n");
      out.write("                    <td><h3>");
      out.print( user.getUsername() );
      out.write("</h3></td> \n");
      out.write("                    <td><h3>");
      out.print( user.getAge() );
      out.write("</h3></td> \n");
      out.write("                    <td><h3>");
      out.print( user.getTrain_id() );
      out.write("</h3></td>\n");
      out.write("                    <td><h3>");
      out.print( user.getBoogie_number() );
      out.write("</h3></td>\n");
      out.write("                    <td><h3>");
      out.print( user.getSeat_number() );
      out.write("</h3></td>                 \n");
      out.write("                </tr>\n");
      out.write("                ");
 
                        }
                    } else {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"6\"><h3>No users found.</h3></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </table>    \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
