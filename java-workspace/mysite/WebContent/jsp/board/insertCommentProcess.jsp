<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ !check }){
		alert('댓글 작성 실패');
	}
	
	location.href = "/mysite/controller/board?a=boardDetail&no=${ no }";
</script>