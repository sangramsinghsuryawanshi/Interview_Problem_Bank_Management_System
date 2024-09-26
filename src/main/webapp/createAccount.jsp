<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color: rgb(0,0,0,0.2);
}
	h2{
		justify-content: center;
		text-align: center;
		align-items: center;
		text-shadow: 12px 20px 12px;
		color: black;
	}
	form{
		justify-content: center;
		text-align: center;
		align-items: center;
		box-shadow: 12px 20px 12px rgb(0,0,0,0.5);
		border: 2px solid black;
		margin-top: 10%;
		width: 30%;
		margin-left: 35%;
		padding: 30px;
		background-color: orange;
		border-radius: 50px;
	}
	input {
	padding: 5px;
	border-radius: 20px;
	border-color: white;
}
button {
	padding: 10px;
	border-radius: 20px;
	background-color: green;
	transition:background-color 0.4s;
	color: white;
}
button:hover {
	background-color: blue;
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
	<form action="/insert" method="post">
		<h1>Create Account</h1>
		<label>Name: </label>
		<input type="text" name="accountHolderName" placeholder="Enter your name.." required="required"><br><br>
		<label>Enter Balance: </label>
		<input type="number" name="balance" placeholder="Enter your balance.." required="required"><br><br>
		<button type="submit">submit</button>
	</form>
	<h2>${msg}</h2>
</body>
</html>