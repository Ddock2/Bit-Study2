<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<jsp:include page="/include/top.jsp"/>
	</div>
	<div style="height: 80px;"></div>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">
					Sign In<br> <small>(Start this Service)</small>
				</h1>
				<div class="accout-wall">
					<img class="profile-img" src="https://www.ornl.gov/themes/ornl/images/no-profile-img.png" width="350px" height="350px"/>
					<form class="form-signin" name="loginProcess" action="" method="POST">
						<input type="text" class="form-control" placeholder="ID" name="id" required autofocus>
						<input type="password" class="form-control" placeholder="PASSWORD" name="password" required>
						<button class="btn btn-lg btn-default btn-block" type="submit">Sign in</button>
					</form>
				</div>
				<a href="" class="text-center new-account">Create an account</a>
			</div>
		</div>
	</div>
</body>
</html>