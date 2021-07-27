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
			<table>
				<thead>
					<tr>
						<td>Name</td>
						<td>Creator</td>
						<td>Version Number</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${languages}" var="lang">
					<tr>
						<td><a href="/languages/${lang.id}">${lang.name}</a></td>
						<td>${lang.creator}</td>
						<td>${lang.versionNumber}</td>				
					</tr>				
				</c:forEach>
				</tbody>
			</table>
			<a href="/languages/new">Add Language</a>
		
		</div>
	</body>
</html>