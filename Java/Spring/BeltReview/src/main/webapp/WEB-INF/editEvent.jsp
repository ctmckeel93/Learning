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
<title>Form</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form action="/events/${event.id}" method="post"
			modelAttribute="event">
			<form:input path="host" type="hidden" value="${user.id}" />
			<input type="hidden" name="_method" value="put" />
			<div>
				<form:label path="name">Name</form:label>
				<form:input value="${event.name}" path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</div>
			<div>
				<form:label path="date">Date</form:label>
				<form:input type="date" path="date" class="form-control" />
				<form:errors path="date" class="text-danger" />
			</div>
			<div>
				<form:label path="city">Location</form:label>
				<form:input path="city" class="form-control" />
				<form:errors path="city" class="text-danger" />
			</div>
			<div>
				<form:label path="state">State</form:label>
				<form:select path="state" class="form-control">
					<c:forEach items="${states}" var="state">
						<c:choose>
							<c:when test="${state.equals(event.state) }">
								<option selected value="${state}">${state}</option>
							</c:when>
							<c:otherwise>
								<form:option value="${state}">${state}</form:option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:select>
			</div>

			<input class="btn btn-dark" type="submit" value="Edit" />
		</form:form>
	</div>
	   
</body>
<html>