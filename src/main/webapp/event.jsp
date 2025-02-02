<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
            padding: 20px;
        }

        .event-details {
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: auto;
            padding: 20px;
        }

        .event-details p {
            font-size: 16px;
            color: #333;
            margin: 10px 0;
        }

        .exit-btn {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            font-size: 14px;
            transition: background-color 0.2s ease-in-out;
        }

        .exit-btn:hover {
            background-color: #0056b3;
        }

        table {
            width: 60%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        .th-volunteers {
            background-color: #007bff;
            color: white;
        }
        
		.th-sponsors {
            background-color: #28a745;
            color: white;
        }
        .delete-link {
            color: white;
            background-color: #dc3545;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
        }

        .delete-link:hover {
            background-color: #a71d2a;
        }

        .add-sponsor {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #28a745;
            color: white;
            border-radius: 5px;
            font-size: 14px;
        }

        .add-sponsor:hover {
            background-color: #218838;
        }
        
        .add-volunteer {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            font-size: 14px;
        }

        .add-volunteer:hover {
             background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="event-details">
        <h2>Event Details</h2>
        <p><strong>Name:</strong> ${event.name}</p>
        <p><strong>Date:</strong> ${event.date}</p>
        <p><strong>Location:</strong> ${event.location}</p>
        <a href='<c:url value="/events"/>' class="exit-btn">Exit</a>
    </div>
    <a href="${pageContext.request.contextPath}/event/${event.id}/volunteer-form" class="add-volunteer">Add Volunteer</a>
    <a href="${pageContext.request.contextPath}/event/${event.id}/sponsor-form" class="add-sponsor">Add Sponsor</a>
    <h3>Volunteers</h3>
    <table >
        <tr class="th-volunteers">
            <th>Name</th>
            <th>Contact Info</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="volunteer" items="${volunteers}">
            <tr>
                <td>${volunteer.name}</td>
                <td>${volunteer.contactInfo}</td>
                <td><a href="${pageContext.request.contextPath}/event/${event.id}/volunteer/delete?id=${volunteer.id}" class="delete-link">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <h3>Sponsors</h3>
    <table >
        <tr class="th-sponsors">
            <th>Name</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="sponsor" items="${sponsors}">
            <tr>
                <td>${sponsor.name}</td>
                <td>${sponsor.amount}</td>
                <td><a href="${pageContext.request.contextPath}/event/${event.id}/sponsor/delete?id=${sponsor.id}" class="delete-link">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    
    
    
</body>
</html>
