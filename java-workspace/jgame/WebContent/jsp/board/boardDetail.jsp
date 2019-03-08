<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 사용자 CSS -->
<link rel="stylesheet" href="/jgame/css/boardDetail.css"/>
<script>
	function goTo(page){
		location.href = page;
	}
	
	function deleteBoard(page){
		if(confirm("진짜 삭제??")){
			goTo(page);		
		}
	}
	
	function loginCheck(){
		if(${empty userVO}){
			alert('로그인 후 이용 가능한 서비스 입니다.');
			return false;
		}
		if(document.getElementById('input-comment-content').value == ""){
			alert('글도 입력 안하고??');
			document.getElementById('input-comment-content').focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>질문</h2>
		<hr width="80%">
		<br>
		<div id="board-detail">
			<table id="detail-table">
				<tr>
					<th width="25%">제목</th>
					<td width="40%">
						<c:out value="${ boardVO.title }"/>
					</td>
					<th width="10%">조회수</th>
					<td width="15%" align="center">
						${ boardVO.view_cnt }
					</td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td width="40%">
						${ boardVO.writer }
					</td>
					<th width="10%">등록일</th>
					<td width="15%" align="center">
						${ boardVO.reg_date }
					</td>
				</tr>
				<tr>
					<th width="25%" style="height: 12em;">내용</th>
					<td colspan="3">
						<c:out value="${ boardVO.content }"/>
					</td>
				</tr>
				<c:if test="${ not empty fileList[0] }">
					<tr>
						<th rowspan="2">첨부파일</th>
						<td style="height: 25px;" colspan="3">
								<a target="blank" href="/jgame/upload/${ fileList[0].file_save_name }" download="${ fileList[0].file_ori_name }" class="click">
									${ fileList[0].file_ori_name }
								</a>
								&nbsp;&nbsp;(${ fileList[0].file_size }bytes)
						</td>
					</tr>
					<tr>
						<td style="height: 25px;" colspan="3">
							<c:if test="${ not empty fileList[1] }">
								<a target="blank" href="/jgame/upload/${ fileList[1].file_save_name }" download="${ fileList[1].file_ori_name }" class="click">
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
				<form action="/jgame/controller/board?a=updateBoard" method="post">
					<input type="hidden" name="no" value="${ boardVO.no }"/>
					<input type="submit" value="글 수정"/>&nbsp;&nbsp;
					<input type="button" value="글 삭제" onclick="deleteBoard('/jgame/controller/board?a=deleteBoard&no=${ boardVO.no }')"/>
				</form>
				<br>
			</c:if>
			<input type="button" value="뒤로" onclick="goTo('/jgame/controller/board?a=boardList')"/>
			<br><br>
		</div>
		
		<div id="comment-input">
			<form action="/jgame/controller/board" method="post" onsubmit="return loginCheck()">
				<strong class="left">댓글 (${ commentList.size() })</strong><br>
				<input type="hidden" name="a" value="insertComment"/>
				<input type="hidden" name="board_no" value="${ boardVO.no }"/>
				<textarea placeholder="남기고 싶은 댓글을 남기세요" name="commentContent" id="input-comment-content"></textarea>
				<br>
				<input type="submit" value="댓글쓰기" class="right"/>
			</form>
			<div style="clear: both;"></div>
			<br>
		</div>
		
		<div id="board-comments">
			<c:forEach var="comment" items="${ commentList }">
				<div class="board-comment">
					<div class="comment-writer">${ comment.writer } <a class="right">${ comment.reg_date }</a></div>
					<div style="clear: both;"></div>
					<div class="comment-content">&nbsp;&nbsp;<c:out value="${ comment.content }"/></div>
				</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>