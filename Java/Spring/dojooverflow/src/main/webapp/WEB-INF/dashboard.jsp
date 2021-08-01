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
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
   		<table class="table table-dark">
   			<thead>
   				<tr>
   					<td>Question</td>
   					<td>Tags</td>
   				</tr>
   			</thead>
   			<tbody>
   				<c:forEach items="${questions}" var="question">
   					<tr>
   						<td><a href="/questions/${question.id }">${question.txt}</a></td>
   						<td>   						
	   						<c:forEach items="${question.tags}" var="tag">  							
		   							${tag.subject},
	   						</c:forEach>
   						</td> 
   					</tr>
   				</c:forEach>
   			</tbody>
   		</table>
   		<a href="/questions/new">Submit a question</a>
   </div>
</body>
<html>