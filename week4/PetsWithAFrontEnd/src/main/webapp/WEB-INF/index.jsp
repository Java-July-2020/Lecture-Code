<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Pets dot Com</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Pets dot Com</h1>
<h4>Greetings <c:out value="${user.firstName}"/></h4>
<hr>
<a href="/new">Create a new pet for our database</a> | 
<a href="/toys/new">Give a toy an existing pet</a> |
<a href="/logout">Logout</a>
<hr>
<h3>All The Pets</h3>

<table class="table table-dark">
<thead>
<tr>
<td>Action</td>
<td>Name</td>
<td>Species</td>
<td>Age</td>
<td># of Likes</td>
<td>Registered?</td>

</tr>
</thead>
<tbody>
<c:forEach items="${pets}" var="pet">
<tr>
<c:choose>
<c:when test="${pet.likers.contains(user)}">
<td><p>Liked!</p></td>
</c:when>
<c:otherwise>
<td><a href="/like/${pet.id}">Like</a></td>
</c:otherwise>
</c:choose>
<td><a href="/${pet.id}">${pet.name}</a></td>
<td>${pet.species}</td>
<td>${pet.age}</td>
<td>${pet.likers.size()}</td>
<c:choose>
<c:when test="${pet.tag != null}">
<td>${pet.tag.city}, ${pet.tag.state}</td>
</c:when>
<c:otherwise>
<td><font color="red">Not Registered</font></td>
</c:otherwise>
</c:choose>

</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>