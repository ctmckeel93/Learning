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
    <title>${song.title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container">
   		<h1>${song.title}</h1>
   		<p>Artist: ${song.artist}</p>
   		<p>Rating: ${song.rating}/10</p>
   		<a href="/songs/${song.id}/edit" class="btn btn-warning">Edit</a>
   		<form:form action="/songs/${song.id}" method="post">
   			<input type="hidden" name="_method" value="delete"/>
   			<input type="submit" class="btn btn-danger" value="Delete"/>
   		</form:form>
   </div>
</body>
<html>