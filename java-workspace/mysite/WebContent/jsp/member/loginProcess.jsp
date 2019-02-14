<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert('${ msg }');
	
	if(${ ! empty userVO }){
		location.href = "/mysite";
	}else{
		location.href = "/mysite/controller/member?a=login";
	}
</script>