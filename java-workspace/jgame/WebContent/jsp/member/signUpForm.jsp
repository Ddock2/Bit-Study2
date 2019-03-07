<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="/jgame/css/layout.css">
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
   function checkInput() {
      var f = document.forms['signUpForm'];

      if (f.inputID.value == '') {
          alert('아이디를 입력해 주세요');
          return false;
      } else if ($('#result-check-id').text() != "사용가능한 아이디 입니다"){
    	  alert('아이디 중복확인을 해주세요');
    	  return false;
      } else if (f.inputPassword.value == ''){
          alert('비밀번호를 입력해 주세요');
          return false;
      } else if (f.inputName.value == ''){
          alert('이름를 입력해 주세요');
          return false;
      } else if (f.inputPassword.value != f.inputPasswordCheck.value){
          alert('비밀번호가 일치하지 않습니다');
          return false;
      } else {
         document.signUp.submit();
      }
   }
   
   function checkID() {
      var id = document.signUpForm.inputID.value;
      if (id == '') {
         alert('확인할 아이디를 입력해주세요');
      } else {
         $.ajax({
        	 url: "/jgame/controller/ajaxProcess?a=checkID",
        	 Type: "post",
        	 data: { inputID : $('#inputID').val() },
        	 success: function(data){
        		 $('#result-check-id').text(data.replace('\n', ''));
        	 },
        	 error: function(){
        		 alert('중복확인 실패');
        	 }
         });
      }
   }
</script>
</head>
<body>
   <div id="header">
      <jsp:include page="/jsp/include/top.jsp"/>
    </div>
   <div class="contentwrap">
      <article class="container">
         <div class="page-header">
            <h2>회원가입 <small>일반회원가입</small></h2>
         </div>
         <form class="form-horizontal" name="signUpForm" action="/jgame/controller/member?a=joinProcess"
         	method="POST" onsubmit="return checkInput()" enctype="multipart/form-data">
         	
            <div class="form-group">
               <label for="inputID" class="col-sm-2 control-label">아이디</label>
               <div class="col-sm-4">
                  <input type="text" class="form-control" name="inputID" id="inputID" placeholder="아이디 입력">
                  <p class="help-block" id="result-check-id">중복확인을 해주세요</p>
               </div>
               <div class="col-sm-2">
                  <a class="btn btn-default" href="javascript:checkID()" role="button">중복확인</a>
               </div>
            </div>
            
            <div name="inputPW" class="form-group" >
               <label for="inputPassword" class="col-sm-2 control-label">비밀번호</label>
               <div name="child" class="col-sm-6">
                  <input type="password" class="form-control" name="inputPassword" placeholder="비밀번호 입력">
               </div>
            </div>
            
            <div name="inputCHKPW" class="form-group">
               <label for="inputPasswordCheck" class="col-sm-2 control-label">비밀번호 확인</label>
               <div name="child" class="col-sm-6">
                  <input type="password" class="form-control" name="inputPasswordCheck" placeholder="비밀번호 확인">
                  <p class="help-block">비밀번호를 한번 더 입력하세요</p>
               </div>
            </div>
            
            <div class="form-group">
               <label for="inputName" class="col-sm-2 control-label">이름</label>
               <div class="col-sm-6">
                  <input type="text" class="form-control" name="inputName" placeholder="이름 입력">
               </div>
            </div>
            
            <div class="form-group">
               <label for="inputProfileImg" class="col-sm-2 control-label">프로필 사진</label>
               <div class="col-sm-6">
                  <input type="file" class="form-control" name="profileImg" size="40"/>
                  <p class="help-block">선택사항 입니다</p>
               </div>
            </div>
            
            <div class="form-group">
               <label for="signUp" class="col-sm-2 control-label"></label>
               <div class="col-sm-6">
                  <button type="submit" class="btn btn-primary">회원가입</button>
                  <button type="button" onclick="location.href='/jgame'" class="btn btn-primary">홈으로 이동</button>
               </div>
            </div>
            
         </form>      
      </article>
   </div>
</body>
</html>