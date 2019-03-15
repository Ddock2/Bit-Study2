<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드</h2>
	<form action="<%=request.getContextPath()%>/file/upload.do" method="post" enctype="multipart/form-data">
		<input type="text" name="id" value="test"><br>
		<input type="file" name="attachFile01"><br>
		<input type="file" name="attachFile02"><br>
		<input type="submit" value="업로드"><br>
	</form>
	<br><br>
	안되면  D:\git\bit2\java-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\spring-mvc에 upload파일 생성
</body>
</html>