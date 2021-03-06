<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="${pageContext.request.contextPath}/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/lightbox.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/lightbox.js"></script>
<c:if test="${not empty authUser}">
	<script type="text/javascript">
	$(function(){
		// 업로드 다이얼로그
		var dialogUpload = $('#dialog-upload-form').dialog({
			autoOpen: false,
			height: 280,
			width: 320,
			modal: true,
			buttons: {
				'업로드': function(){
					$('#dialog-upload-form').children().eq(1).submit();
				},
				'취소' : function(){
					$(this).dialog('close');
				}
			},
			close: function(){
				$('#dialog-upload-form form').get(0).reset();
			}
		});
		
		$('#upload-image').click(function(event){
			event.preventDefault();
			dialogUpload.dialog('open');
		});
	});
	</script>
</c:if>
<script>
//입력 확인
function checkInput(){
	if($('#input-comments').val().length == 0){
		alert('코멘트가 비었어요');
		$('#input-comments').focus();
    	return false;
	}else if($('#input-file').val().length == 0){
		alert('첨부 파일이 선택되지 않았습니다');
    	return false;
	}
}

// 프로필 사진 입력 이미지 파일인지 체크
function checkFileType(obj){
   var fileKind = obj.value.lastIndexOf('.');
   var fileName = obj.value.substring(fileKind+1, obj.length);
   var fileType = fileName.toLowerCase();
   
   var acceptedFileType = new Array();
   acceptedFileType = ['jpg', 'gif', 'png', 'jpeg'];
   
   if(acceptedFileType.indexOf(fileType)==-1){
	   alert('선택한 파일은 서비스가 지원되지 않는 파일입니다');
	   $('#input-file').val('');
	   return false;
   }
   
   return true;
}
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="gallery">
				<div>
					<h1>갤러리</h1>
					<c:if test="${not empty authUser}">
						<a href="" id="upload-image">이미지 올리기</a>
					</c:if>
				</div>
				<ul>
					<c:forEach items="${list}" var="vo">
						<li>
							<a href="${pageContext.request.contextPath}${baseURL}/${vo.saveFileName}"
								class="image"
								style="background-image:url('${pageContext.request.contextPath}${baseURL}/${vo.saveFileName}')"
								title="${vo.comments}"
								data-lightbox="image-group">&nbsp;</a>
							<c:if test="${not empty authUser && authUser.no == vo.userNo}">
								<a href="${pageContext.request.contextPath}/gallery/delete/${vo.no}"
									class="del-button"
									title="삭제">삭제</a>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
			<c:if test="${not empty authUser}">
				<div id="dialog-upload-form" title="이미지 업로드" style="display: none;">
					<p class="validateTips normal">이미지와 간단한 코멘트를 입력해 주세요.</p>
					<form action="${pageContext.request.contextPath}/gallery/upload"
						method="post"
						enctype="multipart/form-data"
						onsubmit="return checkInput()">
						<label>코멘트</label>
						<input type="text" id="input-comments" name="comments" value="">	
						<label>파일</label>
						<input type="file" id="input-file" name="file" accept="image/gif,image/jpeg,image/png" onchange="checkFileType(this)">	
						<input type="submit" tabindex="-1" style="position: ablsolute; top: -1000px;">	
					</form>
				</div>
			</c:if>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="gallery"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>