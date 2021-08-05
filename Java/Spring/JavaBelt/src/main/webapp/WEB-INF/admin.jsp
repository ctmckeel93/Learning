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
	
		<h1>Admin Dashboard</h1>
		
		<table class="table table-dark">
			<thead>
				<tr>
					<td>Name</td>
					<td>Next due date</td>
					<td>Amount due</td>
					<td>Package Type</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers }" var="user">
					<%-- <c:choose>
						<c:when test="${user.roles.contains()}"> --%>						
							<tr>
								<td>${user.firstName } ${user.lastName }</td>
								<td>${user.subscriptionEnd != null ? user.subscriptionEnd : ""}</td> 
								<td>${user.userPackage.convertCurrency()}</td>
								<td>${user.userPackage.name}</td>
							</tr>
						<%-- </c:when>
					</c:choose> --%>
				</c:forEach>
			</tbody>
		</table>
		
		<h3>Packages</h3>
		<table class="table table-dark">
			<thead>
				<tr>
					<td>Name</td>
					<td>Cost</td>
					<td>Available</td>
					<td>Users</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${packages }" var="p">					
							<tr>
								<td>${p.name }</td>
								<td>${p.convertCurrency()}</td>
								<td>Available</td>
								<td>${p.customers.size()}</td>
								<td><a href="/admin/packages/${p.id }/edit">Edit</a></td>
							</tr>
				</c:forEach>
			</tbody>
		</table>
		<form:form action="/packages" method="post" modelAttribute="package">
			<div class="form-group">
				<form:label path="name">Package Name</form:label>
				<form:input path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="price">Cost</form:label>
				<form:input path="price" class="form-control"/>
				<form:errors path="price" class="text-danger"/>
			</div>
			<input type="submit" value="Create Package" class="btn btn-primary"/>
		</form:form>
	</div>
   	
</body>
<html>

