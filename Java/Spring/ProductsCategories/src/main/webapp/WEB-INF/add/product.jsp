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
    <title>Add to Products</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
   		<h1>${product.name}</h1>
   		
   		<div>
	   		<h2>Categories</h2>
	   		<c:forEach var="rel" items="${relevants}">
	   			<p>${rel.name}</p>
	   		</c:forEach>
   		</div>
   		
   		<div>
   			<form action="/add" method="post">
   				<input type="hidden" name="product" value="${product.id }" />
				<label>Add Category</label>
				<select name="category">
					<c:forEach items="${irrelevants}" var="i">
						<option value="${i.id }">${i.name}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Add" class="btn btn-dark"/>   			
   			</form>
   		</div>
   </div>
   
</body>
<html>