<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if(${ check }){
		alert('삭제 완료!');
	}else{
		alert('삭제 실패...');
	}
	
	location.href = '/jgame/controller/board?a=boardList';
</script>