<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="navigationServlet">
	<table>
		<c:forEach items="${requestScope.allReptiles}" var = "currentreptile">
		<tr>
			<td><input type="radio" name="id" value="${currentreptile.id}"></td>
			<td>${currentreptile.breeder}</td>
			<td>${currentreptile.species}</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToReptile">
	<input type="submit" value="delete" name="doThisToReptile">
	<input type="submit" value="add" name="doThisToReptile">
	</form>
</body>
</html>