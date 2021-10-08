<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="static/CSS"></script>
<head>
<meta charset="ISO-8859-1">
<title>Show Dojos</title>
</head>
<body>
	<div>
		<h1>Dojo Name: <c:out value="${dojo.name}"/></h1>
		<p>Location: <c:out value="${dojo.location}"/></p>
<table>	
	<tbody>
 		<tr>
 			<th>First Name:</th>
 			<th>Last Name:</th>
 			<th>Age:</th>
 			<th>Belt Color:</th>
 		</tr>
		<c:forEach var = "ninja" items ="${dojo.ninjas}">
		<tr>
			<td><c:out value="${ninja.firstName}"/></td>
			<td><c:out value="${ninja.lastName}"/></td>
			<td><c:out value="${ninja.age}"/></td>
			<td><c:out value="${ninja.beltColor}"/></td>
			<form action="/dojos/${ninja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			  <td><input type="submit" value="Remove Ninja"></td>
			</form>
			</tr>
		</c:forEach>
	</tbody>
</table>	
	</div>
	<a href="http://localhost:8080/dojos">Dojo Page</a>
	
</body>
</html>