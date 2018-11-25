<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- c:out tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- form -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <!-- date -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		#btn1, #btn2{
			margin: 5px; 0; 5px;
			float: right;
		}
	</style>
</head>

<body>
	<div class="container">
		<form action="/logout" method="POST">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" class="btn btn-info" id="btn1"/>
	    </form>

    	<a href="/ideas" class="btn btn-info" id="btn2">Dashboard</a>
    
		<h1><c:out value="${idea.name}"></c:out></h1>
		
		<h4>Created By: ${user.name}</h4>
		
		<a href="/ideas/${idea.id}/edit" class="btn btn-info" id="btn3">Edit</a>	
	</div>
</body>
</html>