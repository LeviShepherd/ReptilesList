<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
List Name: <input type="text" name="listName"><br />
Breeder Name: <input type="text" name="breederName"><br />
Available Reptiles:<br />
<select name="allReptilesToAdd" multiple size="6">
<c:forEach items="${requestScope.allReptiles}" var="currentreptile">
<option value ="${currentreptile.id}">${currentreptile.breeder} |${currentreptile.species}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Create List and Add Reptiles">
</form>
<a href ="index.html">Go add new reptiles instead.</a>
</body>
</html>