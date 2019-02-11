<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bit.board.db.BoardDAO" %>
<%@ page import="com.bit.board.db.BoardVO" %>
<%@ page import="com.bit.board.db.FileVO" %>
<%
	request.setCharacterEncoding("utf-8");
	
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.selectByNo(Integer.parseInt(request.getParameter("no")));
	List<FileVO> files = dao.selectFileByNo(Integer.parseInt(request.getParameter("no")));
	
	
	request.setAttribute("board", board);
	request.setAttribute("files", files);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function doList(){
		location.href="/jboard/list.do";
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="content" align="center">
		<hr width="80%">
		<h2>게시글</h2>
		<hr width="80%">
		<br>
		
		<table style="width: 80%;" border="1">
			<tr>
				<th width="25%">제목</th>
				<td>
					${ board.title }
				</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%" style="height: 12em;">내용</th>
				<td>
					${ board.content }
				</td>
			</tr>
			<c:if test="${ not empty files[0] }">
				<tr>
					<th rowspan="2">첨부파일</th>
					<td style="height: 25px;">
							<a href="/jboard/upload/${ files[0].file_save_name }">${ files[0].file_ori_name }</a>&nbsp;&nbsp;${ files[0].file_size }bytes
					</td>
				</tr>
				<tr>
					<td style="height: 25px;">
						<c:if test="${ not empty files[1] }">
							<a href="/jboard/upload/${ files[1].file_save_name }">${ files[1].file_ori_name }</a>&nbsp;&nbsp;${ files[1].file_size }bytes
						</c:if>
					</td>
				</tr>
			</c:if>
		</table>
		<br>
		<input type="button" value="목록" onclick="doList()"/>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>