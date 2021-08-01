<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form action="/register" method="post" modelAttribute="user">
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" class="form-control"/>
				<form:errors path="password" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="confirm">Confirm Password</form:label>
				<form:input path="confirm" class="form-control"/>
				<form:errors path="confirm" class="text-danger"/>
			</div>
			<input type="submit" value="Register" class="btn btn-primary"/>
			<a href="/login">Already have an account?</a>
		</form:form>
		
	</div>
   	
</body>
<html>

