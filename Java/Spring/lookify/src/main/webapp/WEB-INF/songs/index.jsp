<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All songs</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>All songs</h1>
		<table>
			<thead>
				<tr>
					<td>Rating</td>
					<td>Title</td>
					<td>Artist</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="s">
					<tr>
						<td>${s.rating}</td>
						<td><a href="/songs/${s.id}">${s.title}</a></td>
						<td>${s.artist}</td>
						<td>
							<form:form action="/songs/${s.id}" method="post">
								<input type="hidden" name="_method" value="delete" />
								<input type="submit" class="btn btn-danger" value="Delete" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/songs/new">New Song</a>
	</div>
</body>
</html>