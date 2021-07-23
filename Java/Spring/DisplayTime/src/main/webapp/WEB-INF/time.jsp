<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*, java.time.format.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="css/time.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/time.js"></script>
	</head>
	<body>
		<div class="container text-center">
			<% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a"); %>
			<h1><%= LocalTime.now().format(formatter) %></h1>
		</div>
	</body>
</html>