<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('글 수정 성공!');
	}else{
		alert('글 수정 실패');
	}
	location.href = "/jgame/controller/board?a=boardList";
</script>