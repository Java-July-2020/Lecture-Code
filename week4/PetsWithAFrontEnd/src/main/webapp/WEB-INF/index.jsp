<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<html>
<head>
<title>Pets dot Com</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<t:wrapper>

<h3>Greetings <c:out value="${user.firstName}"/></h3>
<h4>All The Pets</h4>

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
<td>
<c:choose>
<c:when test="${ !pet.likers.contains(user) }">
	<a href="like/${ pet.id }">Like</a>
</c:when>
<c:otherwise>
	<a href="unlike/${ pet.id }">Un-Like</a>
</c:otherwise>
</c:choose>
</td>
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
</t:wrapper>
</body>
</html>