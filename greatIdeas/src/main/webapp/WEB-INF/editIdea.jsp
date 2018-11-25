<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> <!-- c:out tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> <!-- form -->
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> <!-- date -->
<%@ page isErrorPage="true" %> <!-- errors -->

<!DOCTYPE html>
<html>
<head>
	<title>Edit <c:out value="${course.id}"></c:out></title>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		.red{color: #a94442;}
		#btn1, #btn2{
			margin: 5px; 0; 5px;
			float: right;
		}
		#btn3, #btn4{
			margin: 5px; 0; 5px;
			float: left;
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

		<h1>Edit: ${editIdea.name}</h1>
		
		<c:if test="${errorMsg != null}">
			<div class="alert alert-danger alert-dismissable fade in">
	    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    		<c:out value="${errorMsg}"/>
	    	</div>
		</c:if>
		
		<form:errors path="editIdea.*" class="red"/>
	    
	    <form:form action="/ideas/${editIdea.id}/edit" method="PUT" modelAttribute="editIdea">
			<div class="form-group">
				<form:label path="name">Content:</form:label>
				<form:input path="name" type="text" value="${idea.name}" class="form-control"/>
			</div>
			
			<input type="submit" value="Update" class="btn btn-info" id="btn3">
		</form:form>
		
		<a href="/delete/<c:out value="${editIdea.id}"/>" class="btn btn-info" id="btn4">Delete</a>
		
	</div>
</body>
</html>