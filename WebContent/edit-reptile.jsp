<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit a reptile</title>
</head>
<body>
	<form action="editReptileServlet" method="post">
	Breeder: <input type="text" name="breeder" value="${reptileToEdit.breeder}">
	Species: <input type="text" name="species" value="${reptileToEdit.species}">
	<input type="hidden" name="id" value="${reptileToEdit.id}">
	<input type="submit" value="Save Edited Reptile">
	</form>
</body>
</html>