<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit An Existing List</title>
</head>
<body>
<form action="editListDetailsServlet" method="post">
	<input type ="hidden" name ="id" value="${listToEdit.id}">
	List Name: <input type ="text" name ="listName" value="${listToEdit.listName}"><br />
	Breeder Name: <input type ="text" name ="breederName" value="${listToEdit.breeder.breederName}"><br />
	Available Reptiles:<br />
	<select name="allReptilesToAdd" multiple size="6">
	<c:forEach items="${requestScope.allReptiles}" var="currentreptile">
	<option value ="${currentreptile.id}">${currentreptile.breeder} |${currentreptile.species}</option>
	</c:forEach>
	</select>
	<br />
	<input type ="submit" value="Edit List and AddReptiles">
</form>
<a href ="index.html">Go add new Reptiles instead.</a>
</body>
</html>