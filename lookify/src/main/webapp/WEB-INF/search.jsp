<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Lookify</title>
	</head>
	<body>
		<h1>Songs by artist: <c:out value="${artist}"/></h1>
		<a href="/dashboard">Dashboard</a> 
		<form action="/search" method="post">
			<input type="search" name="artist" placeholder="artist">
			<input type="submit" value="Search Artists">
		</form>
		<table>
			<tr>
				<th>Title</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${songs}" var="song">
    			<tr>    
   				<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
    				<td><c:out value="${song.rating}"/></td>
    				<td><a href="/songs/delete/${song.artist}/${song.id}">Delete</a></td>
    			</tr>
			</c:forEach>
		</table>
	</body>
</html>