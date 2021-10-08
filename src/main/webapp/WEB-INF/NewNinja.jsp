<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library --> 
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a New Ninja</title>
</head>
<body>
	<form:form action="/createNinja" method="post" modelAttribute="ninja">
    <p>
        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
       <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
        <p>
        <form:label path="beltColor">beltColor</form:label>
        <form:errors path="beltColor"/>
        <form:textarea path="beltColor"/>
    </p>
    
    <form:select path = "dojo">
  
    		<c:forEach var = "i" items = "${dojo}">
    		<option value = "${i.id}"><c:out value="${i.name}"></c:out></option>
    		</c:forEach>
  
    </form:select>
   
    <a href="http://localhost:8080/dojos">Nevermind</a>
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>