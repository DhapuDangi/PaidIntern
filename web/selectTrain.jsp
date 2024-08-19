<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Select Train</title>
    <link rel="stylesheet" type="text/css" href="select train.css"> 
</head>
<body> 

    <h2>Select a Train</h2>
    <form action="displayTrainStatus.jsp" method="get">
        <label for="train">Choose a train:</label>
        <select id="train" name="train_id">
            <option value="1">Train 1</option>
            <option value="2">Train 2</option>
            <option value="3">Train 3</option>    
        </select>
        <br><br>
        <input type="submit" value="View Status">
    </form>
</body>
</html>
