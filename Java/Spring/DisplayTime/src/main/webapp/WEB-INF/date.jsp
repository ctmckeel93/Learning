<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*, java.lang.Object"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Display time</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="css/date.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/date.js"></script>
	</head>
	<body>
		
		<div class="container text-center">
		
			
				<% LocalDate now = LocalDate.now(); %>
				<h1> <%= now.getDayOfWeek() %>, the <%= now.getDayOfMonth()%> of <%= now.getMonth() %>, <%= now.getYear() %></h1>		
		</div>
	</body>
</html>