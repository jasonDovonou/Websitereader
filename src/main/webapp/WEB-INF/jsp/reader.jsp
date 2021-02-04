<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Page Reader</title>
<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet">
<link href="css/global.css" rel="stylesheet">
<%@page import="org.springframework.context.annotation.Import"%>
<%@ page import="com.reader.bean.Header"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a class="navbar-brand text-light" href="reader">Web Page Reader</a>
	</nav>

	<form action="${pageContext.request.contextPath}/getHierachy" method="get">
		<div class="row justify-content-center align-items-center p-5">
			<div class="col-lg-8 text-center">
				<div class="scei-form-input row align-items-center">
					<div class="col-lg-4 text-left">Enter Website URL</div>
					<div class="col-lg-6 text-center">
						<input type="url" placeholder="https://example.com" pattern="https://.*" class="form-control" name="url" />
					</div>
					<div class="col-lg-2 text-center">
						<button type="submit" class="btn btn-primary">Launch</button>
					</div>
				</div>
			</div>
		</div>
	</form>

	<c:if test="${not empty headers}">
		<div class="row justify-content-center align-items-center">
			<div class="col-lg-12 text-center">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Tag</th>
							<th scope="col">Text</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${headers}" var="h">
							<tr>
								<td>${h.tag}</td>
								<td>${h.text}</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</c:if>
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>