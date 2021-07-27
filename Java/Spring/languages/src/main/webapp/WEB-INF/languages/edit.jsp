<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  
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
			<form:form action="/languages/${lang.id}" method="POST" modelAttribute="lang">
				<input type="hidden" name="_method" value="put">
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name"/>
					<form:errors path="name"/>
				</div>
				
				<div class="form-group">
					<form:label path="creator">Creator</form:label>
					<form:input path="creator"/>
					<form:errors path="creator"/>
				</div>
				
				<div class="form-group">
					<form:label path="versionNumber">Version Number</form:label>
					<form:input path="versionNumber"/>
					<form:errors path="versionNumber"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Submit"/>
			</form:form>
		</div>
	</body>
</html>