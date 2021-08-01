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
		<form:form action="/questions" method="post" modelAttribute="question">
			<p class="text-success">*Tags must be separated by commas for a maximum of 3</p>
			<div class="form-group" >
				<form:label path="txt"> Submit a Question</form:label>
				<form:input path="txt" class="form-control"/>
				<form:errors path="txt" class="text-danger"/>
			</div>
			<div class="form-group" >
				<label name="tags"> Tags</label>
				<input name="tags" class="form-control"/>
			</div>
			
			
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
   	
</body>
<html>

