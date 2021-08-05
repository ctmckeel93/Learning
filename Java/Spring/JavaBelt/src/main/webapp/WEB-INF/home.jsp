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
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/logout">Logout</a>
   <div class="container">
   		<h1>Welcome, ${logged_in.firstName}</h1>
   		
   		<h3>Your current package:       ${logged_in.userPackage.name} </h3>
   		<h3>Cost:       ${logged_in.userPackage.convertCurrency()} </h3>
   		
   		<form:form action="/users/packages/${logged_in.id }" method="post" modelAttribute="user">
   			<input type="hidden" name="_method" value="put"/>
   			<form:select path="userPackage" class="form-control">
	   			<c:forEach items="${packages}" var="p">   			
		   			<c:choose>
		   				<c:when test="${!p.customers.contains(logged_in)}">		   					
			   				<option value="${p.id}">${p.name}</option>
		   				</c:when>
		   			</c:choose>
	   			</c:forEach>
		   	</form:select>
		   	<input type="submit" class="btn btn-dark" value="Change Package"/>
   		</form:form>
   </div>
</body>
<html>