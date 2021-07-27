<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<!-- YOUR own local CSS -->
		<link rel="stylesheet" href="/css/main.css"/>
		<!-- For any Bootstrap that uses JS or jQuery-->
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container">
			<h1>All Books</h1>
			<table>
			    <thead>
			        <tr>
			            <th>Title</th>
			            <th>Description</th>
			            <th>Language</th>
			            <th>Number of Pages</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${books}" var="book">
			        <tr>
			            <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
			            <td><c:out value="${book.description}"/></td>
			            <td><c:out value="${book.language}"/></td>
			            <td><c:out value="${book.numberOfPages}"/></td>
			        </tr>
			        </c:forEach>
			    </tbody>
		</table>
		
		<a href="/books/new">New Book</a>
		
		</div>
	</body>
</html>