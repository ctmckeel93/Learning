<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojo Survey</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="/css/main.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<form action="/process" method="post">
			<div class="form-group col-sm-6">
				<label>Your Name</label>
				<input type="text" class="form-control" name="name">
			</div>
			<div class="form-group col-sm-6">
				<label>Dojo Location</label>
				<select class="form-control" name="location">
					<option selected>San Jose</option>
					<option>Burbank</option>
					<option>Seattle</option>
				</select>
			</div>
			<div class="form-group col-sm-6">
				<label>Favorite Language</label>
				<select class="form-control" name="language">
					<option>Python</option>
					<option>C-Sharp</option>
					<option>Java</option>
				</select>
			</div>
			<div class="form-group col-sm-6">
				<label>Comment (optional)</label>
				<div>
					<textarea name="comment"></textarea>
				</div>
			</div>
			<button class="btn btn-primary">Submit</button>
		
		</form>
	</body>
</html>