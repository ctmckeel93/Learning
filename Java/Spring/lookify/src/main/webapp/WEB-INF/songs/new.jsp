<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<form:form action="/songs" method="POST" modelAttribute="song">
				<div class="form-group">
					<form:label path="title">Title</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="artist">Artist</form:label>
					<form:input path="artist" class="form-control"/>
					<form:errors path="artist" class="text-danger"/>
				</div>
				<div class="form-group">
					<form:label path="rating">Rating</form:label>
					<form:input type="number" path="rating" class="form-control"/>
					<form:errors path="rating" class="text-danger"/>
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
			</form:form>
		</div>
	</body>
</html>