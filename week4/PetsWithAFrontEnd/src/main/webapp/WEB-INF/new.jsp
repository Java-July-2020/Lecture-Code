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
<h3>Add a New Pet</h3>

<c:forEach items="${error}" var="err">
<p>${err}</p>
</c:forEach>

<form:form method="POST" action="/" modelAttribute="pet">
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
    <button>Add Pet To Database!</button>
</form:form>


</body>

</html>