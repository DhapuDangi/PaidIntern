
<%@page import="java.util.Vector"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DTO.AllviewDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        AllviewDTO u1 = (AllviewDTO) session.getAttribute("allview");
                        if (u1 != null) {
                            Vector<UserDTO> v = u1.getArr();
                            if (v != null && !v.isEmpty()) {
                                for (int i = 0; i < v.size(); i++) {
                    %>
                    <tr>
                        <td><h3><%= v.get(i).getUser_login_id() %></h3></td>
                        <td><h3><%= v.get(i).getUsername() %></h3></td> 
                        <td><h3><%= v.get(i).getAge() %></h3></td> 
                        <td><h3><%= v.get(i).getTrain_id() %></h3></td>
                        <td><h3><%= v.get(i).getBoogie_number() %></h3></td>
                        <td><h3><%= v.get(i).getSeat_number() %></h3></td>                 
                    </tr>
                    <% 
                                }
                            } else {
                    %>
                    <tr>
                        <td colspan="6"><h3>No users found.</h3></td>
                    </tr>
                    <% 
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="6"><h3>No data available in session.</h3></td>
                    </tr>
                    <% 
                        }
                    %>
                </table>    
            </div>
        </div>
    </body>
</html>
