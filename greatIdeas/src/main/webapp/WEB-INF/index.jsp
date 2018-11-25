<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
	
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<h1>Login</h1>
		
		<c:if test="${errorMsg != null}">
			<div class="alert alert-danger alert-dismissable fade in">
	    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    		<c:out value="${errorMsg}"/>
	    	</div>
		</c:if>
	
		<form action="/login" method="POST">
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="text" id="email" name="email" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" id="password" name="password" class="form-control"/>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="Login" class="btn btn-default"/>
		</form>
		
		<h1>Register</h1>
		
		<form:errors path="user.*" class="red"/>
	
		<form:form action="/registration" method="POST" modelAttribute="user">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:input path="name" type="text" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="email">Email:</form:label>
				<form:input path="email" type="email" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password:</form:label>
				<form:password path="password" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="passwordConfirmation">Password Confirmation:</form:label>
				<form:password path="passwordConfirmation" class="form-control"/>
			</div>
			<input type="submit" value="Register" class="btn btn-default"/>
		</form:form>
	</div> <!-- container -->
</body>
</html>