<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<c:url var="url" value="/createStudent" />
	<form:form action="${url}" method="POST" modelAttribute="student">
			Id :
			<form:input path="id" />
		<br>
		<br> Name:
			<form:input path="name" />
		<br>
		<br> Postal Code : <form:input name="" path="postalCode" />
		<br>
		<br> Email : <form:input name="" path="email" />
		<br>
		<br>

		<input type="submit" value="Add Student" />
	</form:form>
	<hr>
	<ul>
		<c:forEach var="e" items="${errorList}">
			<li>${e}</li>
		</c:forEach>
	</ul>
</body>
</html>