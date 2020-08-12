<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to pets dot com</title>
</head>
<body>
<h1>Welcome to Pets dot Com</h1>
<h4>Please Login</h4>
<form method="post" action="/login">
<select name="users">
<c:forEach items="${users}" var="user">
<option value="${user.id}">${user.firstName} ${user.lastName}</option>
</c:forEach>
</select>

<button>Login</button>
</form>
</body>
</html>