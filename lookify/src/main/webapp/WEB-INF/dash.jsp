<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Lookify</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<a href="/songs/new">Add New</a> | <a href="/songs/top">Top Songs</a> 
		<form action="/search" method="post">
			<input type="search" name="artist" placeholder="artist">
			<input type="submit" value="Search Artists">
		</form>
		<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${songs}" var="song">
    			<tr>    
   				<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
    				<td><c:out value="${song.rating}"/></td>
    				<td><a href="/songs/delete/${song.id}">Delete</a></td>
    			</tr>
			</c:forEach>
		</tbody>
		</table>
		</div>
	</body>
</html>