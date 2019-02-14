<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('가입 성공!');
		location.href = "/mysite";
	}else{
		alert('이미 존재하는 아이디랑께');
		location.href = "/mysite/controller/member?a=join";
	}
</script>