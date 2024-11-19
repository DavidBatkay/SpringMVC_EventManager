<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Single song page</h1>
	
	<h3>Id -- <c:out value="${s.id}"/></h3>
	<h3>Titlu -- <c:out value="${s.titlu}"/></h3>
	<h3>Autor -- <c:out value="${s.autor}"/></h3>
	<h3>Link Partitura -- <c:out value="${s.linkPartitura}"/></h3>
	<h3>Versuri -- <c:out value="${s.versuri}"/></h3>
	<h3>Nr Voturi -- <c:out value="${s.nrVoturi}"/></h3>
	
</body>
