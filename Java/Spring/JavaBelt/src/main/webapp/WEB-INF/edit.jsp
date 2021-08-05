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
		<h1>Edit package</h1>
		<form:form action="/packages/${pkg.id}/edit" method="post" modelAttribute="package">
			<input type ="hidden" value="${pkg.name }"/>
			<input type="hidden" name="_method" value="put"/>
			<div class="form-group">
				<form:label path="price">Cost</form:label>
				<form:input value="${pkg.price}" type="number" step="0.01" path="price" class="form-control"/>
				<form:errors path="price" class="text-danger"/>
			</div>
			<input type="submit" value="Edit" class="btn btn-primary"/>
		</form:form>
		<c:choose>
			<c:when test="${pkg.customers.size() == 0 }">			
				<form:form action="/packages/${pkg.id }/delete">
					<input type="hidden" name="_method" value="delete"/>
					<input class="mt-2 btn btn-danger" type="submit" value="Delete"/>
				</form:form>
			</c:when>
		</c:choose>
	</div>
   	
</body>
<html>

