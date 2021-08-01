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
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" class="form-control"/>
				<form:errors path="firstName" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="text-danger"/>
			</div>
			<div class="form-group d-flex">
				<form:label path="city">Location</form:label>
				<form:input path="city" class="form-control"/>
				<form:errors path="city" class="text-danger"/>
				
				
				<form:select path="state" class="form-control">
					<c:forEach items="${states}" var="state">
						<form:option value="${state}" path="state">${state}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="lastName" class="text-danger"/>
			</div>
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

