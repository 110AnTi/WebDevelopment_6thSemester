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
					<li class="nav-item"><a class="navbar-brand" href="#">Upload</a></li>
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
							<h3>Profile</h3>
							<hr>
							<form:form action="profile.htm" modelAttribute="user">
								<div>
									<form:input path="ID" id="profile-username" value="${ID }"
										readonly="true" type="hidden" />
								</div>
								<label for="profile-username" class="col-form-label ">Username</label>
								<div>
									<form:input path="Username" id="profile-username"
										value="${Username }" />
								</div>
								<label for="profile-fullname" class="col-form-label ">Fullname</label>
								<div>

									<form:input path="Fullname" id="profile-fullname"
										value="${Fullname }" />
								</div>
								<label for="profile-gender" class="col-form-label ">Gender</label>
								<div>
									<form:select path="Gender" id="profile-gender"
										value="${Gender==0 ? '----------Male---------' : '---------Female--------' }">
										<form:option value="0" label="----------Male---------" />
										<form:option value="1" label="---------Female--------" />
									</form:select>
								</div>
								<label for="profile-birthday" class="col-form-label ">Birthday</label>
								<div>
									<fmt:formatDate value="${Birthday}" var="birthdayString"
										pattern="MM/dd/yyyy" />
									<form:input path="Birthday" id="profile-birthday"
										value="${birthdayString }" />
								</div>
								<label for="profile-email" class="col-form-label ">Email</label>
								<div>
									<form:input path="Email" id="profile-email" value="${Email }" />
								</div>
								<label for="profile-phone" class="col-form-label ">Phone</label>
								<div>
									<form:input path="Phone" id="profile-phone" value="${Phone }" />
								</div>
								<label for="profile-address" class="col-form-label ">Address</label>
								<div>
									<form:input path="Address" id="profile-address"
										value="${Address }" />
								</div>
								<label for="register-password" class="col-form-label ">Password</label>
								<div>

									<form:password path="Password" id="register-password"/>
								</div>
								<div>
									<button type="submit" class="btn btn-success">Save</button>
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