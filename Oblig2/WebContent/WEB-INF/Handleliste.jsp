<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handleliste</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="HandlelisteServlet" method="post">
		<p>
			<input type="submit" value="Legg til" /><input type="text"
				name="nyVare" />
		</p>
	</form>

	<form action="HandlelisteServlet" method="post">
		<c:forEach items ="${liste.liste}" var="v">
			<button type="submit" name="skalSlette" value="Slett"></button> ${v.navn} <br />
		</c:forEach>
			
	</form>


</body>
</html>