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
		<div>
			<h1>${event.name}</h1>
			
			<p>${event.host.firstName} ${event.host.lastName}</p>
			<p>${event.date}</p>
			<p>${event.city}, ${event.state}</p>
			<p> People attending this event: ${event.guests.size()}</p>
			
			<table class="table table-dark">
		   			<thead>
		   				<tr>
		   					<td>Name</td>
		   					<td>Location</td>
		 
		   				</tr>
		   			</thead>
		   			<tbody>
		   				<c:forEach items="${event.guests }" var="guest">
		   					<tr>
		   						<td>${guest.firstName} ${guest.lastName}</td>
		   						<td>${guest.city}</td>
		   					</tr>
		   				</c:forEach>
		   			</tbody>
		   		</table>
		</div>
		<form:form action="/messages" method="post" modelAttribute="message">
			<div class="form-group">
				<form:input type="hidden" path="event" value="${event.id}"/>
				<form:input path="commenter" type="hidden" value="${user.id }"/>
				
				<form:label path="comment">Comment</form:label>
				<form:input path="comment" class="form-control"/>
				<form:errors path="comment" class="text-danger"/>
			</div>
			<input type="submit" value="Send" class="btn btn-dark"/>
		</form:form>
		
		<div>
			<h3>Chat</h3>
			
			<h4>${event.host.firstName} says Hello, everyone!</h4>
			<c:forEach items="${event.message}" var="message">
				<p> ${message.commenter.firstName} : ${message.comment}</p>
			</c:forEach>
		</div>
	</div>
   	
</body>
<html>

