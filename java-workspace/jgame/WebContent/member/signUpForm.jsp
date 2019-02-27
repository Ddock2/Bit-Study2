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
<script type="text/javascript">
   function checkInput() {
      var f = document.forms['signUpForm'];

      if (f.inputID.value == '') {
            alert('아이디를 입력해 주세요');
            return false;
      } else if (f.inputPassword.value == ''){
            alert('비밀번호를 입력해 주세요');
            return false;
      } else if (f.inputName.value == ''){
            alert('이름를 입력해 주세요');
            return false;
      } else if (f.inputEmail.value == ''){
            alert('이메일를 입력해 주세요');
            return false;
      } else if (f.inputNumber.value == ''){
            alert('전화번호가 정확히지 않습니다');
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
         alert('확인할 아이디를 입력해주세요')
      } else {
         window.open('/jgame/checkID.do?id=' + id, '', 'width=400; height=400')
      }
   }
</script>
</head>
<body>
   <div id="header">
      <jsp:include page="/include/top.jsp"/>
    </div>
   <div class="contentwrap">
      <article class="container">
         <div class="page-header">
            <h2>회원가입 <small>일반회원가입</small></h2>
         </div>
         <form class="form-horizontal" name="signUpForm" action="/jgame/signUp.do"
         	method="POST" onsubmit="return checkInput()">
            <div class="form-group">
               <label for="inputID" class="col-sm-2 control-label">아이디</label>
               <div class="col-sm-4">
                  <input type="text" class="form-control" name="inputID" placeholder="아이디 입력">
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
               <label for="inputPasswordCheck" class="col-sm-2 control-label">비밀번호확인</label>
               <div name="child" class="col-sm-6">
                  <input type="password" class="form-control" name="inputPasswordCheck" placeholder="비밀번호 확인">
                  <p class="help-block">비밀번호를 한번 더 입력하세요</p>
               </div>
            </div>
            
            <div class="form-group">
               <label for="inputName" class="col-sm-2 control-label">이름</label>
               <div class="col-sm-6">
                  <input type="text" class="form-control" name="inputName" placeholder="이름 입력">
                  <p class="help-block">이름을 한번 더 입력하세요</p>
               </div>
            </div>
            
            <div class="form-group">
               <label for="inputEmail" class="col-sm-2 control-label">이메일</label>
               <div class="col-sm-6">
                  <input type="email" class="form-control" name="inputEmail" placeholder="이메일 입력">
                  <p class="help-block">이메일을 입력하세요</p>
               </div>
            </div>
            
            <div class="form-group">
               <label for="inputNumber" class="col-sm-2 control-label">전화번호</label>
               <div class="col-sm-6">
                  <input type="text" class="form-control" name="inputNumber" placeholder="전화번호 입력">
                  <p class="help-block">- 없이 입력해 주세요</p>
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