<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color: rgb(0,0,0,0.2);
}
	table{
		width: 40%;
		justify-content: center;
		text-align: center;
		align-items: center;
		margin-left: 30%;
		margin-top: 10%;
		font-family: serif;
	}
	th{
		background-color: black;
		color: white;
	}
	td{
		background-color: rgb(0,1,0,0.1);
		padding: 6px;
	}
	.c{
		border: 1px;
		border-radius: 15px 25px 5px;
		background-color: green;
		transition:background-color 0.4s;
		text-decoration: none;
		color: white;
		padding: 2px;
	}
	.c:hover {
	background-color: red;
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
	<table border="2" >
		<tr>
			<th>Name</th>
			<th>Balance</th>
			<th>delete</th>
		</tr>
		<c:forEach var="b" items="${bank}">
			<tr>
				<td>${b.accountHolderName}</td>
				<td>${b.balance}</td>
				<td><a href="d/${b.acountId}" class="c" onclick="alert('Are sure to delete this user.?');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>