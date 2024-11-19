<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song Page</title>
</head>
<body>
	<h1>Songs Page</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Titlu</th>
			<th>Autor</th>
			<th>Detalii</th>
		</tr>		
		<c:forEach var="song" items="${all}">
			<tr>
				<th><c:out value="${song.id}"/></th>
				<th><c:out value="${song.titlu}"/></th>
				<th><c:out value="${song.autor}"/></th>
				<th><a href="<c:url value='/song?id=${song.id}' />">Detalii</a></th>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>