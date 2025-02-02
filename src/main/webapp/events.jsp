<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Events</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        .event-table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .event-table th, .event-table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        .event-table th {
            background-color: #007bff;
            color: white;
        }

        .event-table tr:hover {
            background-color: #f1f1f1;
        }

        .event-table a {
            text-decoration: none;
            padding: 5px 10px;
            color: white;
            border-radius: 4px;
            font-size: 13px;
        }

        .details-link { background-color: #007bff; }
        .edit-link { background-color: #ffc107; }
        .delete-link { background-color: #dc3545; }
        
        .details-link:hover { background-color: #0056b3; }
        .edit-link:hover { background-color: #d39e00; }
        .delete-link:hover { background-color: #a71d2a; }

        .add-event {
            display: inline-block;
            margin: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .add-event:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1>All Events</h1>
    <a href="<c:url value='/createEvent'/>" class="add-event">Add a new event</a>
    <table class="event-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Date</th>
                <th>Location</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="event" items="${all}">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.date}</td>
                    <td>${event.location}</td>
                    <td>
                        <a href="<c:url value='/event?id=${event.id}'/>" class="details-link">Details</a>
                        <a href="<c:url value='/event/update?id=${event.id}'/>" class="edit-link">Edit</a>
                        <a href="<c:url value='/event/delete?id=${event.id}'/>" class="delete-link">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
