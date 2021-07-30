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
	<meta charset="UTF-8"/>
    <title>Form</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form action="/licenses" method="post" modelAttribute="license">
			<div class="form-group">
				<form:label path="person">Person:</form:label>
				<form:select path="person" class="form-control">
					<c:forEach items="${persons}" var="p">
						<form:option value="${p.id}">${p.firstName } ${p.lastName}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="person" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="state">State:</form:label>
				<form:input path="state" class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="expirationDate">Expiration Date:</form:label>
				<form:input type="date" path="expirationDate" class="form-control"/>
				<form:errors path="expirationDate" class="text-danger"/>
			</div>
			
			<input type="submit" value="" class="btn btn-primary"/>
		</form:form>
	</div>
   	
</body>
</html>

