<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#detail-table th, td {
		border: 1px solid;
	}
</style>
<script>
	function goTo(page){
		location.href = '/mysite/controller/board?a=' + page + '&no=${ boardVO.no }';
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>게시글 상세</h2>
		<hr width="80%">
		<br>
		<table style="width: 70%; border: 1px solid;" id="detail-table">
			<tr>
				<th width="25%">제목</th>
				<td width="45%">
					${ boardVO.title }
				</td>
				<th width="10%">조회수</th>
				<td width="10%" align="center">
					${ boardVO.view_cnt }
				</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td width="45%">
					${ boardVO.writer }
				</td>
				<th width="10%">등록일</th>
				<td width="10%" align="center">
					${ boardVO.reg_date }
				</td>
			</tr>
			<tr>
				<th width="25%" style="height: 12em;">내용</th>
				<td colspan="3">
					${ boardVO.content }
				</td>
			</tr>
			<c:if test="${ not empty fileList[0] }">
				<tr>
					<th rowspan="2">첨부파일</th>
					<td style="height: 25px;" colspan="3">
							<a target="blank" href="/jboard/upload/${ fileList[0].file_save_name }" download="${ fileList[0].file_ori_name }">
								${ fileList[0].file_ori_name }
							</a>
							&nbsp;&nbsp;(${ fileList[0].file_size }bytes)
					</td>
				</tr>
				<tr>
					<td style="height: 25px;" colspan="3">
						<c:if test="${ not empty fileList[1] }">
							<a target="blank" href="/jboard/upload/${ fileList[1].file_save_name }" download="${ fileList[1].file_ori_name }">
								${ fileList[1].file_ori_name }
							</a>
							&nbsp;&nbsp;(${ fileList[1].file_size }bytes)
						</c:if>
					</td>
				</tr>
			</c:if>
		</table>
		<br>
		<c:if test="${ userVO.id == boardVO.writer }">
			<input type="button" value="글 수정" onclick="goTo('updateBoard')"/>&nbsp;&nbsp;
			<input type="button" value="글 삭제" onclick="goTo('deleteBoard')"/>
		</c:if>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>