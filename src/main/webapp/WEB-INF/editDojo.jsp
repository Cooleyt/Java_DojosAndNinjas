<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Dojo</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>Edit Dojo</h1>
	<form:form action="/dojos/${dojo.id}/edit" method="post" modelAttribute="dojo">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="location">Location</form:label>
	        <form:errors path="location"/>
	        <form:textarea path="location"/>
	    </p>
   
	    <a href="http://localhost:8080/dojos">Nevermind</a>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>