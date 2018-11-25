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
    
		<h1>Welcome, <c:out value="${user.name}"></c:out>!</h1>
		
		<h2>Idea's</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Idea</th>
					<th scope="col">Created By</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${idea}" var="s">
					<tr>
						<td><a href="/ideas/${s.id}"><c:out value="${s.name}"/></a></td>
						<td><c:out value="${user.name}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="/ideas/new">Add an Idea</a>

	</div>
</body>
</html>