<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	로그인 시 알림을 띄우고,
	해당 화면으로 이동
	성공 시 -> 홈
	실패 시 -> 로그인화면
-->

<script>
	alert('${ msg }');
	location.href = '${ url }';
</script>