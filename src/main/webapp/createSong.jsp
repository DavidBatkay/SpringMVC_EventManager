<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form method="post"
	action="${pageContext.request.contextPath}/songs/saveNewSong"
	modelAttribute="cantecNou">
	
	<label for="titlu">Titlu</label>
	<form:input path="titlu"/><br/><br>
	
	<label for="autor">Autor</label>
	<form:input path="autor"/><br/><br>
	
	<label for="linkPartitura">Link partitura</label>
	<form:input path="linkPartitura"/><br/><br>
	
	<label for="versuri">Versuri</label>
	<form:input path="versuri"/><br/><br>
	
	<label for="nrVoturi">NR Voturi</label>
	<form:input path="nrVoturi"/><br/><br>
	
	<input type="submit" value="Salveaza" /><br/><br>
 	
	
	
	</form:form>
</body>
</html>