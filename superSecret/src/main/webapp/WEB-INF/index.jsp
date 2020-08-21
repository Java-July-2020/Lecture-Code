<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Wedding Planner</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Pets dot Com</h1>
<div class="row">
<div class="col">
<h4>Login</h4>
			<p>${ loginError }</p>
			<form method="POST" action="/login">
				<div class="form-group">
			    	<label>Email:</label>
			    	<input class="form-control" type="email" name="email">
			    </div>
			    <div class="form-group">
			    	<label>Password:</label>
			    	<input class="form-control" type="password" name="password">
			    </div>
			    <button class="btn btn-danger">Login</button>
			</form>
</div>
<div class="col">
<h4>Register</h4>
			<form:form action="/register" method="post" modelAttribute="user">
			    <div class="form-group">
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group">
			        <form:label path="passwordConfirmation">Confirm Password</form:label>
			        <form:errors path="passwordConfirmation"/>
			       <form:input type="passwordConfirmation" class="form-control" path="passwordConfirmation"/>
			    </div>
			    <input class="btn btn-danger" type="submit" value="Submit"/>
			</form:form>


</div>
</div>


</div>
</body>
</html>