<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<style>
.mypage-table{
	width: 80%;
	border: 1px solid #dee2e6;
	margin-bottom: 10px;
}

.mypage-table th, .mypage-table td {
	text-align: center;
	height: 65px;
	border: 1px solid #dee2e6;
}

.mypage-table th {
	color: #495057;
	background-color: #e9ecef;
}

input[type="text"], input[type="password"] {
	width: 90%;
	height: 40%;
}
</style>
<script>
	// 입력 확인
	function checkInput(){
		if($('#curPassword').val().length == 0){
			alert('정보 수정을 하려면 현재 비밀번호를 입력해 주세요');
			$('#curPassword').focus();
        	return false;
		}else if($('#userName').val().length == 0){
			alert('이름 입력해 주세요');
        	return false;
		}else if($('#newPassword').val().length != 0){
			if($('#newPassword2').val() != $('#newPassword').val()){
				alert('변경하려는 비밀번호와 비밀번호 확인이 같지 않습니다');
	        	return false;
			}
		}
	}
	
	// 프로필 이미지 미리보기
	function changeImg(input){
		if(!checkFileType(input)){
			return false;
		}
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				$('#profile-view').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
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
		   $('#userProfile').val('');
		   return false;
	   }
	   
	   return true;
	}
</script>
</head>
<body>
   	<div id="header">
      <jsp:include page="/jsp/include/top.jsp"/>
    </div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h1>회원 정보</h1>
		<hr width="80%">
		<form action="/jgame/controller/member?a=updateUserInfo" onsubmit="return checkInput()" method="POST" enctype="multipart/form-data">
			<table class="mypage-table">
				<tr>
					<th>아이디</th>
					<td>${ userVO.id }</td>
					<td rowspan="3" colspan="2">
						<div style="display: inline-block; width:200px;">
							<img style="height:200px; width:200px;" src="/jgame/profile_img/${ userVO.profile_img_save_name }" id="profile-view">
							<input type="file" name="userProfile" id="userProfile" accept="image/gif,image/jpeg,image/png" onchange="changeImg(this)">
							<br>
						</div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName" id="userName" maxlength="20" value="${ userVO.name }"></td>
				</tr>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" maxlength="20" name="curPassword" id="curPassword"></td>
				</tr>
				<tr>
					<th>새 비밀번호</th>
					<td><input type="password" maxlength="20" name="newPassword" id="newPassword"></td>
					<th>새 비밀번호 확인</th>
					<td><input type="password" maxlength="20" name="newPassword2" id="newPassword2"></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td colspan="3">${ userVO.reg_date }</td>
				</tr>
			</table>
			<br>
			<button class="btn btn-default" type="submit">정보 수정</button>
		</form>
	</div>
</body>
</html>