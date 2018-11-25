<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- c:out tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- form -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <!-- date -->
<%@ page isErrorPage="true" %> <!-- errors -->

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

		<form action="/logout" method="POST">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Logout" class="btn btn-info" id="btn1"/>
	    </form>

    	<a href="/ideas" class="btn btn-info" id="btn2">Dashboard</a>

		<h1>Create a New Idea</h1>
				
		<c:if test="${errorMsg != null}">
			<div class="alert alert-danger alert-dismissable fade in">
	    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    		<c:out value="${errorMsg}"/>
	    	</div>
		</c:if>
		<form:errors path="idea.*" class="red"/>
	    
	    <form:form action="/ideas/new" method="POST" modelAttribute="idea">
			<div class="form-group">
				<form:label path="name">Content:</form:label>
				<form:input path="name" type="textbox" class="form-control"/>
			</div>
			
			<input type="submit" value="Create" class="btn btn-default">
		</form:form>
					
	</div> <!--container-->
</body>
</html>