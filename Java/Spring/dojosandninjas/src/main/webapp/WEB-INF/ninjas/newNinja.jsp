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
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
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
			<div class="form-group">
				<form:label path="dojo">Dojo</form:label>
				<form:select path="dojo" class="form-control">
					<c:forEach items="${dojos}" var="dojo">					
						<form:option value="${dojo}">${dojo.location}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="dojo" class="text-danger"/>
			</div>
			<input type="submit" value="Join" class="btn btn-primary"/>
		</form:form>
	</div>
   	
</body>
<html>

