<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('글 등록 성공!');
		location.href = "/jgame/controller/board?a=boardList";
	}else{
		alert('글 등록 실패');
		location.href = "/jgame/controller/board?a=write";
	}
</script>