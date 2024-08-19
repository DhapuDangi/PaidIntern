
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<html>
<head>
    <title>Seat Allocation</title>
    <link rel="stylesheet" href="styles.css">
    
</head>
<body>
    <div class="container">
        <h1>Train Seat Allocation</h1>
        <form action="allocated.jsp" method="post">
            <label for="userLoginId">Enter Login ID:</label>
            <input type="text" id="userLoginId" name="userLoginId" required>

            <label for="trainChoice">Choose Train:</label>
            <select id="trainChoice" name="trainChoice" required>
                <option value="1">Train 1</option>
                <option value="2">Train 2</option>
                <option value="3">Train 3</option>
            </select>

            <button type="submit">Allocate Seat</button>
        </form>
    </div>
</body>
</html>

