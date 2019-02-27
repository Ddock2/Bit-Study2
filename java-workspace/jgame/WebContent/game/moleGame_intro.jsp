<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jgame/css/tutorials.css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#start').hide();
		$('#hide').click(function(){
			$('#button').hide(1000, function(){
				$(this).remove();
			});
			$('#slidebox').hide(1000, function(){
				$(this).remove();				
			});
			$('#start').show();
		});
		
		$('#innerHide').click(function(){
			$('#button').hide(1000, function(){
				$(this).remove();
			});
			$('#slidebox').hide(1000, function(){
				$(this).remove();				
			});
			$('#start').show();
		});
	});
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/include/top.jsp" />
	</div>
	
	<div id="page-wrapper">
		<div class="title">
			<marquee direction="up" height="250" behavior="alternate" scrollamount="8">
				<span style="color:white; filter:shadow(color='ff00ff'); height:3px;">
					<h1 align="center" data-text="두더지 잡기">두더지 잡기</h1>
					<h2 align="center" data-text="tutorials">tutorials</h1>
				</span>
			</marquee>
		</div>
		<br><br>
		
		<div align="center">
			<div id="button">
				<button class="btn btn-info btn-default btn-lg" onclick="moveTo('L')">이전</button>
				<button class="btn btn-info btn-default btn-lg" onclick="moveTo('R')">다음</button>
				<button id="hide" class="btn btn-danger btn-default btn-lg">끝내기</button>
			</div>
			<br>
			<div id="start">
				<button class="btn btn-warning btn-default btn-lg" onclick="location.href='moleGame_Main.do'">
					바로 게임 시작하기
				</button>
			</div>
			<br>
			<div id="slidebox">
				<ul id="slider">
					<li><img src="/jgame/image/help01.png"/></li>
					<li><img src="/jgame/image/help02.png"/></li>
					<li><img src="/jgame/image/help03.png"/></li>
					<li><img src="/jgame/image/help04.png"/></li>
					<li>
						<div align="center">
							<h1>튜토리얼 완료</h1>
							<h2>게임을 시작하시려면 끝내기를 누르세요!</h2>
							<button id="innerHide" class="btn btn-danger btn-default btn-lg">끝내기</button>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		var x = 1000;
		var slider = document.getElementById('slider');
		var slideArray = slider.getElementsByTagName('li');
		var slideMax = slideArray.length - 1;
		var curSlideNum = 0;
		
		// 초기 이미지를 left 0, 나머지는 숨겨라
		for(i = 0; i<=slideMax; i++){
			if(i == curSlideNum)
				slideArray[i].style.left = 0;
			else
				slideArray[i].style.left = x + 'px';
		}
		
		// Slide Change
		var isSliding = false;
		var next = 0;
		
		function moveTo(way){
			switch(way){
				case 'L' : changeSlideToFront(); break;
				case 'R' : changeSlideToRear(); break;
			}
		}
		
		// To Front
		function changeSlideToFront(){
			if(!isSliding && (next > 0)){
				isSliding = true;
				next = curSlideNum - 1;
				frontSliding();
			}
		}
		
		function frontSliding(){
			var curX = parseInt(slideArray[curSlideNum].style.left, 10);
			var nextX = parseInt(slideArray[next].style.left, 10);
			var newCurX = curX + 30;
			var newNextX = nextX + 30;
			
			if(newCurX >= 1000){
				slideArray[curSlideNum].style.left = newCurX + 'px';
				slideArray[next].style.left = 0;
				curSlideNum = curSlideNum - 1;
				isSliding = false;
				return;
			}
			slideArray[curSlideNum].style.left = newCurX + 'px';
			slideArray[next].style.left = newNextX + 'px';
			setTimeout(function(){
				frontSliding();
			}, 20);
		}
		
		// To Rear
		function changeSlideToRear(){
			if(!isSliding && (next < slideMax)){
				isSliding = true;
				next = curSlideNum + 1;
				rearSliding();
			}
		}
		
		function rearSliding(){
			var curX = parseInt(slideArray[curSlideNum].style.left, 10);
			var nextX = parseInt(slideArray[next].style.left, 10);
			var newCurX = curX - 30;
			var newNextX = nextX - 30;
			
			if(newCurX <= -x){
				slideArray[curSlideNum].style.left = -x + 'px';
				slideArray[next].style.left = 0;
				curSlideNum = curSlideNum + 1;
				isSliding = false;
				return;
			}
			slideArray[curSlideNum].style.left = newCurX + 'px';
			slideArray[next].style.left = newNextX + 'px';
			setTimeout(function(){
				rearSliding();
			}, 20);
		}
	</script>
</body>
</html>