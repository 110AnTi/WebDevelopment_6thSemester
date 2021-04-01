<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bookstore-EBOOK</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/style.css" />" rel="stylesheet"
	type="text/css">
<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"/> "></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/> "></script>
</head>
<body>
	${message }
	<div class="container-fluid">
		<header class="row">
			<h1 class="title-h1">
				<a href="index.htm">Ebooks for everyone</a>
			</h1>
		</header>
		<ul class="nav justify-content-end navbar-dark">
			<li class="nav-item searching-form">
				<form class="form-inline">
					<button class="btn btn-light" type="submit">Search</button>
					<input class="form-control mr-sm-2 w-75" type="search"
						placeholder="Search" aria-label="Search" maxlength="3">
				</form>
			</li>
			<li class="nav-item"><span style="width: 150px"></span></li>
			<li class="nav-item"><a class="navbar-brand"
				href="requestCode.htm">Reset password</a></li>
			<li class="nav-item"><a class="navbar-brand" href="register.htm">Register</a></li>
			<li class="nav-item"><a class="navbar-brand" href="login.htm">Login</a></li>
			<li class="nav-item"><a class="navbar-brand" href="#">About</a></li>
			<li class="nav-item"><span style="width: 120px"></span></li>
		</ul>
		<c:choose>
			<c:when test="${empty user }">
				<div class="row">
					<aside class="col-md-1"></aside>
					<article class="col-md-10">
						<div class="form-group form-control-lg">
							<br>
							<h3>Request verified code</h3>
							<hr>
							<form action="resetPassword.htm" method="post">
								<label for="resetPassword-code">Verified code</label>
								<div>
									<input type="text" name="code" id="resetPassword-code" />
								</div>
								<label for="resetPassword-password1">New password</label>
								<div>
									<input type="password" name="password1"
										id="resetPassword-password1" />
								</div>
								<label for="resetPassword-password2">Confirm new
									password</label>
								<div>
									<input type="password" name="password2"
										id="resetPassword-password2" />
								</div>
								<div>
									<button type="submit" class="btn btn-success">Submit</button>
								</div>
							</form>
						</div>
					</article>
					<aside class="col-md-1"></aside>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<aside class="col-md-1"></aside>
					<article class="col-md-10">
						<div>
							<br>
							<h3>Request verified code</h3>
							<hr>
							<h5>You need to log out!</h5>
						</div>
					</article>
					<aside class="col-md-1"></aside>
				</div>
			</c:otherwise>
		</c:choose>
		<footer class="row"></footer>
	</div>
</body>
</html>