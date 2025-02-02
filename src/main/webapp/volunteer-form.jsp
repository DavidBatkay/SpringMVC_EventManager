<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Volunteer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
            padding: 20px;
        }

        .form-container {
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
            margin: auto;
            padding: 20px;
            text-align: left;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-size: 16px;
            color: #555;
            display: block;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 15px;
        }

        button:hover {
            background-color: #0056b3;
        }

        .exit-btn {
            display: inline-block;
            margin:auto;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #6c757d;
            color: white;
            border-radius: 5px;
            font-size: 14px;
            text-align: center;
            display: block;
        }

        .exit-btn:hover {
            background-color: #495057;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Volunteer</h2>
        <form:form method="post" action="${pageContext.request.contextPath}/event/${eventId}/volunteer/save" modelAttribute="volunteer">
            <input type="hidden" name="eventId" value="${eventId}" />

            <label for="name">Volunteer Name:</label>
            <input type="text" name="name" required />

            <label for="amount">Contact Info:</label>
            <input type="text" name="contactInfo" required />

            <button type="submit">Save Volunteer</button>
        </form:form>

        
    <a href="${pageContext.request.contextPath}/event?id=${eventId}" class="exit-btn">Cancel</a>

    </div>
</body>
</html>
