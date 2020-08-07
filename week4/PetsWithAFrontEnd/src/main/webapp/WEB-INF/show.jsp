<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Pets dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h1>Welcome to Pets dot Com</h1>
<hr>
<div class="wrapper">
<h3>Showing Details For <c:out value="${pet.name}" /></h3>
<c:forEach items="${error}" var="err">
<p>${err}</p>
</c:forEach>

<h2>Name:</h2>
<p>${pet.name}</p>
<h2>Species:</h2>
<p>${pet.species}</p>
<c:if test="${pet.toys != null}">
<h2>Toys:</h2>
<ol>
<c:forEach items="${pet.toys}" var="toy">
	<li>${toy.name} (${toy.price})</li>
</c:forEach>
</ol>
</c:if>
<c:choose>
<c:when test="${pet.tag != null}">
<h2>City</h2>
<p>${pet.tag.city}</p>
<h2>State</h2>
<p>${pet.tag.state}</p>
</c:when>
<c:otherwise>
<form:form method="POST" action="/tag" modelAttribute="tag">
	<form:hidden path="pet" value="${pet.id}" />
    <div class="form-group"><p>
    <form:label path="city">City
    <form:errors path="city"/>
    <form:input path="city"/></form:label>
    </p>
    <p>
    <form:label path="state">State
    <form:errors path="state"/>
    <form:textarea path="state"/></form:label>
  	</p>
    <button>Add Tag</button>
    </div>
</form:form>

</c:otherwise>
</c:choose>

<hr>
<form:form method="POST" action="/${pet.id}" modelAttribute="pet">
	<input type="hidden" name="_method" value="put">
    <p>
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    </p>
    <p>
    <form:label path="species">Species
    <form:errors path="species"/>
    <form:textarea path="species"/></form:label>
    </p>
    <p>
    <form:label path="age">Age
    <form:errors path="age"/>
    <form:input path="age"/></form:label>
    </p>
    <button>Edit Pet Details</button>
</form:form>
</div>

</body>

</html>

