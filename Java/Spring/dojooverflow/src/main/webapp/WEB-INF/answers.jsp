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
    <title>Question</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
   		<h1>${question.txt}</h1> 
   		<span class="d-flex">   		
	   		<h3>Tags:</h3>
	   		<c:forEach items="${question.tags }" var="tag">   		
		   		<span class="btn btn-light">${tag.subject}</span>
	   		</c:forEach>
   		</span>
   		<div class="bg bg-dark w-50 mt-2  p-4" style="height: 300px;">
   			<h4 class="text-success text-center">Answers</h4>
   			<c:forEach items="${question.answers}" var="answer">
   				<p class="bg bg-danger p-2">${answer.txt}</p>
   			</c:forEach>
   		</div>
   		
   		<form:form class="w-50" action="/addAnswer" method="post" modelAttribute="answer">
   		
   			<form:input path="question" type="hidden" name="q" value="${question.id}"/>
   			<form:label path="txt">Submit an answer</form:label>
   			<form:input path="txt" class="form-control"/>
   			<form:errors path="txt" class="text-danger"/>
   			
   			<input type="submit" class="btn btn-dark"/>
   		</form:form>
   </div>
</body>
<html>