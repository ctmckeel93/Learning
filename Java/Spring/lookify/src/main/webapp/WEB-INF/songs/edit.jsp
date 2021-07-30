<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit song</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form action="/songs/${song.id}" method="post" modelAttribute="song">
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group">
				<form:label path="title">Title</form:label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="artist">Artist</form:label>
				<form:input path="artist" class="form-control" />
				<form:errors path="artist" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="rating">Rating</form:label>
				<form:input type="number" path="rating" class="form-control" />
				<form:errors path="rating" class="text-danger" />
			</div>
			<input type="submit" class="btn btn-primary" value="Update">
		</form:form>
	</div>
</body>
<html>