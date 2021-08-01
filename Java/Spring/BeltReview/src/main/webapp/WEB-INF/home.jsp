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
	   <div class="container">
		   <nav class="navbar-nav bg-dark p-2">
		   		<a class="navbar-text btn btn-default btn-outline-success text-success w-25" href="/logout">Logout</a>
		   </nav>
		   		<h6>All the events in your Area</h6>
		   		
		   		<table class="table table-dark">
		   			<thead>
		   				<tr>
		   					<td>Name</td>
		   					<td>Date</td>
		   					<td>Location</td>
		   					<td>Host</td>
		   					<td>Actions</td>
		   				</tr>
		   			</thead>
		   			<tbody>
		   				<c:forEach items="${eventsInState}" var="local">
		   					<tr>
		   						<td><a href="/events/${local.id }">${local.name}</a></td>
		   						<td>${local.date}</td>
		   						<td>${local.city}</td>
		   						<td>${local.host.firstName} ${local.host.lastName}</td>
		   						<td>
		   							<c:choose>
		   								<c:when test="${local.host != user && !user.events.contains(local) }">
			   								<a href="/events/${local.id }/join">Join</a>
		   								</c:when>
		   								
		   								<c:when test="${local.host == user }">

		   								</c:when>
		   								<c:otherwise>
		   									<p>Joining</p>
		   								</c:otherwise>
		   							</c:choose>
		   							
		   							<c:choose>
		   								<c:when test="${local.host == user }">		   								
				   							<a href="events/${local.id }/edit">Edit</a>
				   							<form action="/events/${local.id }/delete" method="post">
				   								<input type="hidden" name="_method" value="delete"/>
				   								<input class="btn btn-danger" type="submit" value="Cancel">
				   							</form>
		   								</c:when>
		   							</c:choose>
		   						</td>
		   					</tr>
		   				</c:forEach>
		   			</tbody>
		   		</table>
		   		
		   		<h6>Events in other states</h6>
		   		<table class="table table-dark">
		   			<thead>
		   				<tr>
		   					<td>Name</td>
		   					<td>Date</td>
		   					<td>Location</td>
		   					<td>Host</td>
		   					<td>Actions</td>
		   				</tr>
		   			</thead>
		   			<tbody>
		   				<c:forEach items="${eventsNotInState}" var="notLocal">
		   					<c:choose>
		   					<c:when test="${notLocal.host != user }">
		   					<tr>
		   						<td><a href="/events/${notLocal.id}">${notLocal.name}</a></td>
		   						<td>${notLocal.date}</td>
		   						<td>${notLocal.state}</td>
		   						<td>${notLocal.host.firstName} ${notLocal.host.lastName}</td>
		   						<td>
		   							<c:choose>
		   								<c:when test="${!notLocal.guests.contains(user) }">
			   								<a href="/events/${notLocal.id }/join">Join</a>
		   								</c:when>
		   								<c:otherwise>
		   									<p>Joining</p>
		   								</c:otherwise>
		   								
		   							</c:choose>
		   						</td>
		   					</tr>
		   					</c:when>
		   					</c:choose>
		   				</c:forEach>
		   			</tbody>
		   		</table>
		   		
		   		<form:form action="/events" method="post" modelAttribute="event">
		   			<form:input path="host" type="hidden" value="${user.id}" />
		   			<div>
		   				<form:label path="name">Name</form:label>
		   				<form:input path="name" class="form-control"/>
		   				<form:errors path="name" class="text-danger"/>
		   			</div>
		   			<div>
		   				<form:label path="date">Date</form:label>
		   				<form:input type="date" path="date" class="form-control"/>
		   				<form:errors path="date" class="text-danger" />
		   			</div>
		   			<div>
		   				<form:label path="city">Location</form:label>
		   				<form:input path="city" class="form-control" />
		   				<form:errors path="city" class="text-danger"  />
		   			</div>
		   			<div>
		   				<form:label path="state">State</form:label>
		   				<form:select path="state" class="form-control">
		   					<c:forEach items="${states}" var="state">		   					
			   					<form:option value="${state}">${state}</form:option>
		   					</c:forEach>
		   				</form:select>
		   				<form:errors/>
		   			</div>
		   			
		   			<input class="btn btn-dark" type="submit" value="Create"/>
		   		</form:form>
		</div>
	</body>
</html>