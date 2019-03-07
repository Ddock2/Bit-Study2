<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('${ msg }');
	
	if(${ ! empty userVO }){
		location.href = "/jgame";
	}else{
		location.href = "/jgame/controller/member?a=login";
	}
</script>