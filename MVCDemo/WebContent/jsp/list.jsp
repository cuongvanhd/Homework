<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List User</title>
</head>
<body>

	<h2>List User</h2>

	<table border="1" cellpadding="5" cellspacing="5">
		<thead>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>Password</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ls" items="${list}">
				<tr>
					<td>${ls.id}</td>
					<td>${ls.username}</td>
					<td>${ls.password}</td>
					<td>${ls.name}</td>
				</tr>

			</c:forEach>
		</tbody>

	</table>

</body>
</html>