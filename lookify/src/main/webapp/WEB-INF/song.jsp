<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Lookify</title>
	</head>
	<body>
		<a href="/dashboard">Dashboard</a> 
		<p>Title: <c:out value="${song.title}"/></p>
		<p>Artist: <c:out value="${song.artist}"/></p>
		<p>Rating (1-10): <c:out value="${song.rating}"/></p>
		<p><a href="/songs/delete/${song.id}">Delete</a></p>
	</body>
</html>