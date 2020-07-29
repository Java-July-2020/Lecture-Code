<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold!</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<div class="wrapper">
<div class="row">
Your Gold: <c:out value="${totalGold}"/>
</div>

<div class="box">
<h5>Farm</h5>
<p>(earns 10-20 gold)</p>
<form method="POST" action="/activity">
<input type="hidden" name="building" value="farm">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>Cave</h5>
<p>(earns 5-10 gold)</p>
<form method="POST" action="/activity">
<input type="hidden" name="building" value="cave">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>House</h5>
<p>(earns 2-5 gold)</p>
<form method="POST" action="/activity">
<input type="hidden" name="building" value="house">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>Casino</h5>
<p>(earns/takes 0-50 gold)</p>
<form method="POST" action="/activity">
<input type="hidden" name="building" value="casino">
<input type="submit" value="Find Gold!">
</form>
</div>
<div class="box">
<h5>Spa</h5>
<p>(takes 5-20 gold)</p>
<form method="POST" action="/activity">
<input type="hidden" name="building" value="spa">
<input type="submit" value="Relax!">
</form>
</div>


<div class="row">
<p>Activities:</p>
<div class="activities">
<c:forEach var="activity" items="${activityLog}">
    <p class='${activity.contains("Ouch")? "error":"gain"}'><c:out value="${activity}"/></p>
</c:forEach>
</div>

</div>


</div>
</body>
</html>