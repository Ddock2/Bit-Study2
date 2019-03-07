<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('글 수정 성공!');
		location.href = "/mysite/controller/board?a=boardList";
	}else{
		alert('글 수정 실패');
		location.href = "/mysite/controller/board?a=write";
	}
</script>