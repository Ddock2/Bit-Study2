<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
	// 두 수 사이의 합계를 구하는 메소드
	public int sum(int a, int b){
		int temp = 0;
		for(int i=a; i<=b; i++){
			temp += i;
		}
		return temp;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1 ~ 100 까지의 합계 : <%= sum(1,100) %>
</body>
</html>