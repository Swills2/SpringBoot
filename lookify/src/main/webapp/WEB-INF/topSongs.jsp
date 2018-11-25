<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Lookify</title>
	</head>
	<body>
		<h1>Top Ten Songs</h1>
		<a href="/dashboard">Dashboard</a> 
		<ul>
			<c:forEach items="${songs}" var="song">
				<li>
					<c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>