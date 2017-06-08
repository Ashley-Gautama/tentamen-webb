<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Gameoverzicht</title>
</head>
<body>
	<h2>Jeu de Boules Club gameoverzicht</h2>
	<h3>${message}</h3>

	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong>id</strong></td>
			<td><strong>clubnightnr</strong></td>
			<td><strong>Team A</strong></td>
			<td><strong>Team B</strong></td>
			<td><strong>Winnaar</strong></td>
		</tr>
		<c:forEach var="game" items="${games}">
			<tr>
				<td>${game.id}</td>
				<td>${game.clubnight }</td>
				<td>${game.teamA.name}</td>
				<td>${game.teamB.name }</td>
				<td>${game.winner.name }</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/game/add">Maak nieuwe
			game aan</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/menu">Terug naar het
			menu</a>
	</p>
</body>
</html>
