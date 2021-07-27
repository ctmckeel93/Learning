<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninja Gold</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="css/main.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="container">
		<h2>Your Gold: <c:out value="${gold}"/></h2>
		
		<div class="main">
			<div class="farm text-center pt-5">
				<h3>Farm</h3>
				<p>(earns 10-20 Gold)</p>
				<form action="/find-gold" method="post">
				<input type="hidden" name="input" value="farm">
					<button class="btn btn-success">Find gold!</button>
				</form>
			
			</div>
			<div class="cave text-center pt-5">
				<h3>Cave</h3>
				<p>(earns 5-10 Gold)</p>
				<form action="/find-gold" method="post">
					<input type="hidden" name="input" value="cave">
					<button class="btn btn-dark">Find gold!</button>
				</form>
			</div>
			<div class="house text-center pt-5">
				<h3>House</h3>
				<p>(earns 2-5 Gold)</p>
				<form action="/find-gold" method="post">
					<input type="hidden" name="input" value="house">
					<button class="btn btn-primary">Find gold!</button>
				</form>
			</div>
			<div class="casino text-center pt-5">
				<h3>Casino!</h3>
				<p>(earns/takes 0-50 Gold)</p>
				<form action="/find-gold" method="post">
					<input type="hidden" name="input" value="casino">
					<button class="btn btn-danger">Find gold!</button>
				</form>
			</div>
		</div>		
		<h3>Action Log</h3>
		<div class="action-log">
			<c:forEach var="msg" items="${results}">
				<p>${msg}</p>
			</c:forEach>
		</div>
	</div>
	</body>
</html>