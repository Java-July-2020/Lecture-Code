<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Pets dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<h1>Welcome to Pets dot Com</h1>
<hr>
<h3>Give your buddy a new toy</h3>


<form:form method="POST" action="/toys" modelAttribute="toy">
	<div class="form-group">
	<form:label path="pet">Gift This Toy To:</form:label>
	<form:errors path="pet"/>
	<form:select path="pet">
	<c:forEach items="${pets}" var="pet">
		<option value="${pet.id}">${pet.name}</option>
	</c:forEach>
	</form:select>
	
	</div>
    <div class="form-group">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name"/></form:label>
	</div>
	<div class="form-group">
    <form:label path="price">Price
    <form:errors path="price"/>
    <form:input type="decimal" path="price"/></form:label>
    </div>
	<div class="form-group">
    <form:label path="description">Description
    <form:errors path="description"/>
    <form:input path="description"/></form:label>
	</div>
    <button>Give Toy</button>
</form:form>


</body>

</html>