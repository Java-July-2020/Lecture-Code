<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Pets dot Com</title>
</head>
<body>
	<div class="container">
	<h1>Welcome to Pets dot Com</h1>
	<nav>
		<a href="/pets">View All Pets</a> |
		<a href="/new">Create New Pet</a>
		<a href="/toys/new">Give a Pet a toy</a> |
		<a href="/logout">Logout</a>
	</nav>
	<hr />
	<jsp:doBody/>
	</div>
</body>
</html>