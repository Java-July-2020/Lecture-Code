<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html>
<html>
<head>
<title>Pets dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<t:wrapper>
<div class="row">
<div class="col">
<c:forEach items="${error}" var="err">
<p>${err}</p>
</c:forEach>

<h1><c:out value="${pet.name}"/> the <c:out value="${pet.species}"/></h1>
<hr>
<p>Owner: <a href="/user/${pet.owner.id}">${pet.owner.firstName}</a></p>
<hr>
<p>Name: ${pet.name}</p>
<p>Species: ${pet.species}</p>
<p>Age: ${pet.age}</p>
<hr>
<h3>Liked By:</h3>
<ol>
<c:forEach items="${pet.likers}" var="user">
<li>${user.firstName} ${user.lastName}</li>
</c:forEach>

</ol>
</div>
<div class="col">
<h2>Toys:</h2>
<c:choose>
<c:when test="${pet.toys.size() != 0}">
<ol>
<c:forEach items="${pet.toys}" var="toy">
	<li>${toy.name} (${toy.price})</li>
</c:forEach>
</ol>
</c:when>
<c:otherwise>
<p>This pet has no toys, gift them one!</p>
</c:otherwise>
</c:choose>
<hr>
<c:choose>
<c:when test="${pet.tag != null}">
<h4>Registered</h4>

<p>City: ${pet.tag.city}</p>
<p>State: ${pet.tag.state}</p>
</c:when>
<c:otherwise>
<form:form method="POST" action="/tag" modelAttribute="tag">
	<form:hidden path="pet" value="${pet.id}" />
    <div class="form-group">
    <form:label path="city">City
    <form:errors path="city"/>
    <form:input path="city"/></form:label>
	</div>
	<div class="form-group">
    <form:label path="state">State
    <form:errors path="state"/>
    <form:textarea path="state"/></form:label>
  	</div>
    <button>Add Tag</button>
    </div>
</form:form>

</c:otherwise>
</c:choose>
</div></div>
<hr>
<c:if test="${pet.owner.id == userId}">
<form:form method="POST" action="/${pet.id}" modelAttribute="pet">
	<input type="hidden" name="_method" value="put">
    <div class="form-group">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
    </div>
    <div class="form-group">
    <form:label path="species">Species
    <form:errors path="species"/>
    <form:input path="species"/></form:label>
    </div>
    <div class="form-group">
    <form:label path="age">Age
    <form:errors path="age"/>
    <form:input path="age"/></form:label>
    </div>
    <button>Edit Pet Details</button>
</form:form>
	<form action="/${pet.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input class="btn btn-danger" type="submit" value="Delete">
</form>
</c:if>
</t:wrapper>

</body>

</html>

