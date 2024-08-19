<%@ page import="java.util.Vector"%>
<%@ page import="DTO.UserDTO"%>
<%@ page import="DTO.AllviewDTO"%>
<%@ page import="DAO.AllviewDAO"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
// Initialize the AllviewDTO object and call the DAO to populate it
AllviewDTO allviewDTO = new AllviewDTO();
AllviewDAO dao = new AllviewDAO();
dao.getset(allviewDTO);

// Store the allviewDTO in the session for use in the JSP
session.setAttribute("allview", allviewDTO);
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View All Users</title>
    <link rel="stylesheet" href="viewallcss.css">
</head>
<body>
    <div class="nav">
        <div id="navlist">
            <div id="btn"><a href="index.jsp">Close</a></div>
        </div>
        <div id="personal">
            <table>
                <tr style="color:white">
                    <td><h3>ID</h3></td> 
                    <td><h3>Username</h3></td>
                    <td><h3>Age</h3></td>
                    <td><h3>Train Name</h3></td> 
                    <td><h3>Boogie Number</h3></td> 
                    <td><h3>Seat Number</h3></td> 
                </tr>
                <% 
                    if (allviewDTO != null && allviewDTO.getArr() != null && !allviewDTO.getArr().isEmpty()) {
                        Vector<UserDTO> users = allviewDTO.getArr();
                        for (UserDTO user : users) {
                %>
                <tr>
                    <td><h3><%= user.getUser_login_id() %></h3></td>
                    <td><h3><%= user.getUsername() %></h3></td> 
                    <td><h3><%= user.getAge() %></h3></td> 
                    <td><h3><%= user.getTrain_id() %></h3></td>
                    <td><h3><%= user.getBoogie_number() %></h3></td>
                    <td><h3><%= user.getSeat_number() %></h3></td>                 
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6"><h3>No users found.</h3></td>
                </tr>
                <% } %>
            </table>    
        </div>
    </div>
</body>
</html>
