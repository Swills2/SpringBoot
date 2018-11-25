<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
<style>
	body{
		display: flex;
		flex-direction: column;
		align-items: center;
		margin: 100px;
	}
	form{
		display: flex;
		flex-direction: column;
		width: 200px;
		margin-top: 10px;
	}
	
	input[type="submit"]{
		width: 100px;
		margin-top: 10px;
	}
</style>
</head>
<body>

<table>
<caption>Languages</caption>
<tr>
<th>Name</th>
<th>Creator</th>
<th>Version</th>
<th colspan="2">action</th>
</tr>
<c:forEach items="${languages}" var="lang" varStatus="loop">
<tr>
<td><a href="/languages/<c:out value="${lang.id}"/>"><c:out value="${lang.name}"/></a></td>
<td><c:out value="${lang.creator}"/></td>
<td><c:out value="${lang.version}"/></td>
<td><a href="/languages/delete/${lang.id}">delete</a></td> 
<td><a href="/languages/edit/${lang.id}">edit</a></td>
</tr>
</c:forEach>
</table>
<form:form action="/languages/add" method="POST" modelAttribute="language">

<form:label path="name">Name
<form:errors path="name"/>
<form:input path="name"/>
</form:label>

<form:label path="creator">Creator
<form:errors path="creator"/>
<form:input path="creator"/>
</form:label>


<form:label path="version">Version
<form:errors path="version"/>
<form:input path="version"/>
</form:label>

<input type="submit" value="Submit"/>
</form:form>
<p><c:out value="${errors}"/></p>
</body>
</html>