<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Event</title>
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

        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
        }

        .submit-btn:hover {
            background-color: #218838;
        }

        .back-link {
            display: block;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
            font-size: 14px;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Edit Event</h2>
        <form:form method="post" action="${pageContext.request.contextPath}/event/save" modelAttribute="event">

    
            <input type="hidden" name="id" value="${event.id}">

            <label for="name">Event Name:</label>
            <input type="text" name="name" value="${event.name}" required>

            <label for="date">Event Date:</label>
            <input type="date" name="date" value="${event.date}" required>

            <label for="location">Event Location:</label>
            <input type="text" name="location" value="${event.location}" required>

            <button type="submit" class="submit-btn">Create Event</button>
        </form:form>

        <a href="<c:url value='/events'/>" class="back-link">Cancel</a>
    </div>
</body>
</html>
