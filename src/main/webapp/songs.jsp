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
	
	<a href="<c:url value="/songs/createSong"/>">Create new song</a>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Titlu</th>
			<th>Autor</th>
			<th>Detalii</th>
			<th>Editeaza</th>
			<th>Sterge</th>
		</tr>		
		<c:forEach var="song" items="${all}">
			<tr>
				<td><c:out value="${song.id}"/></td>
				<td><c:out value="${song.titlu}"/></td>
				<td><c:out value="${song.autor}"/></td>
				<td><a href="<c:url value='/song?id=${song.id}' />">Detalii</a></td>
				<td><a href="<c:url value='/songs/edit/${song.id}' />">Editeaza</a></td>
				<td><a href="<c:url value='/songs/delete/${song.id}' />">Sterge</a></td>
			</tr>
		</c:forEach>
	
	</table>

</body>
</html>