<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Train Status</title>
    <link rel="stylesheet" type="text/css" href="displayTrainStatus.css"> 
<body>
       <div id="btn"><a href="index.jsp">Cancel</a></div>
    <h2>Train Status</h2>
    <%
        String trainId = request.getParameter("train_id"); 
        if (trainId == null) {
            out.println("<p>No train selected.</p>");
        } else {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                // Database connection
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrainAllocationSystem", "root", "root");

                String query = "SELECT boogie_number, COUNT(seat_number) AS occupied_seats, "
                             + "(MAX(seat_number) - COUNT(seat_number)) AS available_seats "
                             + "FROM TrainAllocation WHERE train_id = ? GROUP BY boogie_number ORDER BY boogie_number;";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, Integer.parseInt(trainId));
                rs = stmt.executeQuery();

                out.println("<table>");
                out.println("<tr><th>Boogie Number</th><th>Occupied Seats</th><th>Available Seats</th></tr>");
                while (rs.next()) {
                    int boogieNumber = rs.getInt("boogie_number");
                    int occupiedSeats = rs.getInt("occupied_seats");
                    int availableSeats = rs.getInt("available_seats");

                    out.println("<tr>");
                    out.println("<td>" + boogieNumber + "</td>");
                    out.println("<td>" + occupiedSeats + "</td>");
                    out.println("<td>" + availableSeats + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p>Error: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                if (stmt != null) try { stmt.close(); } catch (SQLException ignored) {}
                if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
            }
        }
    %>
    
</body>
</html>
