<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All the Dojos</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div class="container"> 
    <h1>All the Dojos</h1>
    
    <table>
    	<tbody>
    		<tr>
    			<th>Name:</th>
    			<th>Location:</th>
    			<th>Actions</th>
  
    		</tr>
    		<c:forEach var= "i" items= "${dojo}">
    		<tr>
    			<td> <a href="/dojos/${i.id}"> ${i.name}</a></td>
    			<td><i><c:out value="${i.location}"></c:out></i></td>
    		
    			<td><a href="/dojos/${i.id}/edit">Edit</a></td>
    			<td><a href="/dojos/${i.id}">View</a></td>
    			
    		</tr>
    		</c:forEach>
    	</tbody>
    </table>
   
       <button><a href="/dojos/new">Add a New Dojo</a></button>
		<button><a href="/newNinja">Add a Ninja</a></button>
    </div> 
</body>
</html>