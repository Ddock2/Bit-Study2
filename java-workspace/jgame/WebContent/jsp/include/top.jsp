<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="content">
			<div class="navbar-header">
				<a class="navbar-brand" href="/jgame">Home</a>
				<input type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</div>
		</div>
		
		<div class="navbar-collapse collapse">
			<div class="row">
				<ul class="nav navbar-nav">
					<li><a href="/jgame/controller/member?a=join">회원가입</a></li>
					<li><a href="/jgame/controller/member?a=login">로그인</a></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>