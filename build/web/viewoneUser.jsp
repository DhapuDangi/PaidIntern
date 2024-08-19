

<%@page import="DTO.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View User Information</title>
        <link rel="stylesheet" href="oneuser.css"/>
        <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    </head>
    <body>
        <div id="btn"><a href="index.jsp">Cancel</a></div>
        <div class="nav"></div>
        <div class="from">
            <h2>View Individual User</h2>

            <%
                UserDTO user = (UserDTO) session.getAttribute("viewobj");
                String error = (String) session.getAttribute("error");
                if (user != null) {
            %>
            <table>
                <tr>
                    <td><strong>User ID:</strong></td>
                    <td><%= user.getUser_login_id() %></td>
                </tr>
                <tr>
                    <td><strong>Username:</strong></td>
                    <td><%= user.getUsername() %></td>
                </tr>
                <tr>
                    <td><strong>Age:</strong></td>
                    <td><%= user.getAge() %></td>
                </tr>
                <tr>
                    <td><strong>Train Name:</strong></td>
                    <td><%= user.getTrain_id() %></td>
                </tr>
                <tr>
                    <td><strong>Boogie Number:</strong></td>
                    <td><%= user.getBoogie_number() %></td>
                </tr>
                <tr>
                    <td><strong>Seat Number:</strong></td>
                    <td><%= user.getSeat_number() %></td>
                </tr>
            </table>
            <% 
                } else if (error != null) {
                    out.println("<p style='color:red'>" + error + "</p>");
                } else {
                    out.println("<p>No data available.</p>");
                }
            %>
        </div>
    </body>
</html>
