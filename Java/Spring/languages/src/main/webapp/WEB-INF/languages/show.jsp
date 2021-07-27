<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="/css/main.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h1>${language.name}</h1>
			<p>Creator: ${language.creator}</p>
			<p>Version Number: ${language.versionNumber}</p>
			<a class="btn btn-warning" href="/languages/${language.id}/edit">Edit</a>
			<form action="/languages/${language.id}" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input class="btn btn-danger mt-1" type="submit" value="Delete">
			</form>
			
		</div>
	</body>
</html>