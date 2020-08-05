<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<html>
<head>
<title>Pets dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h1>Welcome to Pets dot Com</h1>
<hr>
<a href="/new">Create a new pet for our database</a>

<table class="table table-dark">
<thead>
<tr>
<td>ID</td>
<td>Name</td>
<td>Specices</td>
<td>Age</td>
</tr>
</thead>
<tbody>
<c:forEach items="${pets}" var="pet">
<tr>
<td>${pet.id}</td>
<td><a href="/${pet.id}">${pet.name}</a></td>
<td>${pet.species}</td>
<td>${pet.age}</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>