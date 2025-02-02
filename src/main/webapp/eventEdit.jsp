<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Event</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
            padding: 20px;
        }

        .form-container {
            background: white;
            width: 350px;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            margin-bottom: 15px;
            color: #333;
        }

        .form-container label {
            display: block;
            font-weight: bold;
            margin: 10px 0 5px;
            text-align: left;
        }

        .form-container input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            margin-bottom: 15px;
        }

        .button-group {
            display: flex;
            justify-content: space-between;
            margin-top: 15px;
        }

        .btn {
            flex: 1;
            padding: 10px;
            text-align: center;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            text-decoration: none;
        }

        .update-btn {
            background-color: #28a745;
            color: white;
            margin-right: 5px;
        }

        .update-btn:hover {
            background-color: #218838;
        }

        .cancel-btn {
            background-color: #dc3545;
            color: white;
            margin-left: 5px;
        }

        .cancel-btn:hover {
            background-color: #a71d2a;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Event</h2>
        <form:form method="post" 
                   action="${pageContext.request.contextPath}/event/update" 
                   modelAttribute="event">
    
            <input type="hidden" name="id" value="${event.id}">

            <label for="name">Event Name:</label>
            <input type="text" name="name" value="${event.name}" required>

            <label for="date">Event Date:</label>
            <input type="date" name="date" value="${event.date}" required>

            <label for="location">Event Location:</label>
            <input type="text" name="location" value="${event.location}" required>

            <div class="button-group">
                <button type="submit" class="btn update-btn">Update Event</button>
                <a href="<c:url value='/events'/>" class="btn cancel-btn">Cancel</a>
            </div>
        </form:form>
    </div>
</body>
</html>
