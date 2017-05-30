<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Clinic</title>

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="resources/css/custom.css" rel="stylesheet">
</head>
<body class="login">
	<div class="login_wrapper">
		<div class="animate form login_form">
			<section class="login_content">
				<form action="login" method="POST">
					<h1>Login</h1>
					<div>
						<input type="text" class="form-control" placeholder="Username"
							required name="username" />
					</div>
					<div>
						<input type="password" class="form-control" placeholder="Password"
							required name="password" />
					</div>
					<div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
					<div>
						<button class="btn btn-default submit" type="submit">Log
							in</Button>
					</div>

					<div class="clearfix"></div>
					
					<c:if test="${not empty msg}">
						<p class="msg">${msg}</p>
					</c:if>
					
					<c:if test="${not empty error}">
						<p class="msg">${error}</p>
					</c:if>

					<div class="separator">

						<div class="clearfix"></div>
						<br />

						<div>
							<h1>
								<i class="fa fa-heart"></i> Clinic Management System
							</h1>
							<p>©2017 Group 4.</p>
						</div>
					</div>
				</form>
			</section>
		</div>
	</div>	
</body>
</html>
