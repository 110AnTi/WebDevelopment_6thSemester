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
		<c:choose>
			<c:when test="${not empty user }">
				<ul class="nav justify-content-end navbar-dark">
					<li class="nav-item searching-form">
						<form class="form-inline">
							<button class="btn btn-light" type="submit">Search</button>
							<input class="form-control mr-sm-2 w-75" type="search"
								placeholder="Search" aria-label="Search" maxlength="3">
						</form>
					</li>
					<li class="nav-item"><span style="width: 225px"></span></li>
					<li class="nav-item"><a class="navbar-brand" href="upload.htm">Upload</a></li>
					<li class="nav-item"><a class="navbar-brand"
						href="profile.htm">Profile</a></li>
					<li class="nav-item"><a class="navbar-brand" href="logout.htm">Logout</a></li>
					<li class="nav-item"><a class="navbar-brand" href="#">About</a></li>
					<li class="nav-item"><span style="width: 120px"></span></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="nav justify-content-end navbar-dark">
					<li class="nav-item searching-form">
						<form class="form-inline">
							<button class="btn btn-light" type="submit">Search</button>
							<input class="form-control mr-sm-2 w-75" type="search"
								placeholder="Search" aria-label="Search" maxlength="3">
						</form>
					</li>
					<li class="nav-item"><span style="width: 150px"></span></li>
					<li class="nav-item"><a class="navbar-brand" href="requestCode.htm">Reset
							password</a></li>
					<li class="nav-item"><a class="navbar-brand"
						href="register.htm">Register</a></li>
					<li class="nav-item"><a class="navbar-brand" href="login.htm">Login</a></li>
					<li class="nav-item"><a class="navbar-brand" href="#">About</a></li>
					<li class="nav-item"><span style="width: 120px"></span></li>
				</ul>
			</c:otherwise>
		</c:choose>
		<div class="row">
			<aside class="col-md-1"></aside>
			<article class="col-md-10">
				<div class="justify-content-center last-updated">
					<br>
					<h3>Last Updated</h3>
					<hr>
					<ul class="grid-5">
						<li>item1</li>
						<li>item2</li>
						<li>item3</li>
						<li>item4</li>
						<li>item5</li>
						<li>item6</li>
						<li>item7</li>
						<li>item8</li>
						<li>item9</li>
						<li>item10</li>
						<li>item11</li>
						<li>item12</li>
						<li>item13</li>
						<li>item14</li>
						<li>item15</li>
						<li>item16</li>
						<li>item17</li>
						<li>item18</li>
						<li>item19</li>
						<li>item20</li>
					</ul>
				</div>
				<br>
				<div class="justify-content-center most-popular">
					<h3>Most Popular</h3>
					<hr>
					<ul class="grid-5">
						<li>item1</li>
						<li>item2</li>
						<li>item3</li>
						<li>item4</li>
						<li>item5</li>
						<li>item6</li>
						<li>item7</li>
						<li>item8</li>
						<li>item9</li>
						<li>item10</li>
						<li>item11</li>
						<li>item12</li>
						<li>item13</li>
						<li>item14</li>
						<li>item15</li>
						<li>item16</li>
						<li>item17</li>
						<li>item18</li>
						<li>item19</li>
						<li>item20</li>
					</ul>
				</div>
			</article>
			<aside class="col-md-1"></aside>
		</div>
		<footer class="row"></footer>
	</div>
</body>
</html>