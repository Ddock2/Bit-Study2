<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#header-table { 
		width: 100%;
		border: 1px solid;
		text-align: center;
	}
	
	#header-table td{
		border: 1px solid;
	}
	
	#logo {
		width: 70px;
		height: 70px;
	}
	
	.click {
		text-decoration: none;
		font-weight: bold;
	}
	
	.click:hover {
		font-weight: normal;
		cursor: pointer;
	}
</style>

<table id="header-table">
	<tr>
		<td width="20%">
			<a href="/mysite">
				<img src="/mysite/image/good.png" id="logo"/>
			</a>
		</td>
		<td width="60%">
			<h1><a href="/mysite" class="click">Good Site</a></h1>
		</td>
		<td width="20%">
			<c:choose>
				<c:when test="${ empty userVO }">
					<a href="/mysite/controller/member?a=join" class="click">회원가입</a> ||
					<a href="/mysite/controller/member?a=login" class="click">로그인</a>
				</c:when>
				<c:otherwise>
					<a onclick="alert('${ userVO.id}(${ userVO.name})님은 ${ userVO.reg_date}에 가입하셨답니다아')" style="font-size: 20px;" class="click">
						<c:out value="${ userVO.id }"/>
					</a>
					<br>
					<a href="/mysite/controller/member?a=logoutProcess" class="click" style="font-size: 12px;">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
<br>