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
		<h1><u>Submitted Info</u></h1>
		<p>Name: <c:out value="${Name}"/></p>
		<p>Location: <c:out value="${Location}"/></p>
		<p>Language: <c:out value="${Language}"/></p>
		<p>Comment: <c:out value="${Comment}"/></p>
	</body>
</html>