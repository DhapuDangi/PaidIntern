package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration page </title>\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("    <!-- Add icon library -->\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n");
      out.write("    />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\t\n");
      out.write("<div class=\"container\">\n");
      out.write("      <h2>Enter your Profile: </h2>\n");
      out.write("      \n");
      out.write("      <form action=\"RegistrationChecker\" Method=\"Post\">\n");
      out.write("     \n");
      out.write("      <div class=\"form-container\">\n");
      out.write("\n");
      out.write("  <div class=\"input-name\">\n");
      out.write("    <i class=\"fa fa-user lock\"></i>\n");
      out.write("    <input type=\"text\" placeholder=\"Enter Username\" class=\"text-name\" id=\"username\" name=\"username\"/>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("  <div class=\"input-name\">\n");
      out.write("    <i class=\"fa fa-user lock\"></i>\n");
      out.write("    <input type=\"text\" placeholder=\"Enter Your Age\" class=\"text-name\" id=\"age\" name=\"age\" />\n");
      out.write("  </div>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("  <div class=\"input-name\">\n");
      out.write("    <Button type=\"submit\" class=\"button\" value=\"submit\" id=\"submitbutton\">Submit</Button>\n");
      out.write("  </div>\n");
      out.write("          \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("          \n");
      out.write(" </form>\n");
      out.write("\t\n");
      out.write("\t");

		if(request.getMethod().equals("POST")){
			String username = request.getParameter("username");
			int age = Integer.parseInt(request.getParameter("age"));
			// Add data to database or perform any other operation
			out.println("<p>Data added successfully!</p>");
		}
	
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
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
