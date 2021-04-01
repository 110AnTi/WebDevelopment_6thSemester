<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
				<div class="row">
					<aside class="col-md-1"></aside>
					<article class="col-md-10">
						<div class="form-group form-control-lg">
							<br>
							<h3>Upload</h3>
							<hr>
							<form:form action="upload.htm" modelAttribute="book"
								method="post" enctype="multipart/form-data">
								<label for="upload-title" class="col-form-label">Title</label>
								<div>
									<form:input path="Title" id="upload-title" />
								</div>
								<label for="upload-genres">Genre</label>
								<div>
									<!--<c:forEach var="g" items="${listGenres}">
										<form:checkbox path="genres" id="upload-genres"
											value="${g.getID()}" label="${g.getName()}" />
									</c:forEach>-->


									<form:checkboxes path="genres" id="upload-genres"
										items="${listGenres }" itemValue="ID" itemLabel="Name" />
								</div>
								<label for="upload-publisher">Publisher</label>
								<div>
									<form:input path="publisher" id="upload-publisher" />
								</div>
								<label for="upload-authors">Authors</label>
								<div>
									<form:input path="" id="upload-author" name="authors"/>
								</div>
								<label for="upload-authors">File PDF</label>
								<div>
									<form:input type="file" name="filePDF" path=""
										id="upload-filepdf" />
								</div>
								<label for="upload-description">Description</label>
								<div>
									<form:textarea path="Description" id="upload-description" />
								</div>
								<div>
									<button type="submit" class="btn btn-success">Upload</button>
								</div>
							</form:form>
						</div>
					</article>
					<aside class="col-md-1"></aside>
				</div>
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
					<li class="nav-item"><a class="navbar-brand" href="#">Reset
							password</a></li>
					<li class="nav-item"><a class="navbar-brand"
						href="register.htm">Register</a></li>
					<li class="nav-item"><a class="navbar-brand" href="login.htm">Login</a></li>
					<li class="nav-item"><a class="navbar-brand" href="#">About</a></li>
					<li class="nav-item"><span style="width: 120px"></span></li>
				</ul>
				<div class="row">
					<aside class="col-md-1"></aside>
					<article class="col-md-10">
						<div class="form-group form-control-lg">
							<br>
							<h3>Profile</h3>
							<hr>
							<h5>You are not logged in!</h5>
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