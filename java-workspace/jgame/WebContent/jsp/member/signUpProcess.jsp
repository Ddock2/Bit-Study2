<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('가입 성공!');
		location.href = "/jgame";
	}else{
		alert('가입 실패!');
		location.href = "/jgame/controller/member?a=join";
	}
</script>