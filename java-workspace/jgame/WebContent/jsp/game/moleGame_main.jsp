<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 사용자 CSS -->
<link rel="stylesheet" href="/jgame/css/gameMain.css"/>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	var players = {
			1 : new Audio(''),
			2 : new Audio(''),
			3 : new Audio('')
	};
	
	document.oncontextmenu = function(e){
		return false;
	};
	
	$(document).ready(function(){	// 우클릭, 드래그 방지
		$(document).bind('contextmenu', function(){ return false; });
		$(document).bind('mousedown', function(){ return false; });
		
		// 게임 시간
		var gameTime = 30;
		$('#time-cnt').html('남은 시간 : ' + gameTime);
		function time(){
			$('#time-cnt').html('남은 시간 : ' + gameTime);
		}
		
		// 점수 영역
		var score = 0;
		var pin = [];
		$('#score-view').html('Score : ' + score);
		function preScore(i){
			score = score + i;
			$('#score-view').html('Score : ' + score);
			pin.pop('in');
		}
		
		// 효과음
		function play(i){
			if(window.HTMLAudioElement){
				players[i].play();
			}
		}
		
		// 도구 영역 (player)
		var toolIdx = Math.round(Math.random() * 1);
		var tool = ['주먹', '망치', '폭탄'];
		var type = '';
		alert(tool[toolIdx] + '으로 시작합니다.');
		
		function weapon(toolIdx){
			switch(toolIdx){
			case 0 :
				type = 'A';
				$('span').dblclick(function(){
					$(this).stop(true, true);
					$(this).fadeOut(150, function(){
						play(1);
						preScore(300);
					});
				});
				break;
			case 1 :
				type = 'B';
				$('span').click(function(){
					$(this).stop(true, true);
					$(this).fadeOut(150, function(){
						play(2);
						preScore(200);
					});
				});
				break;
			case 2 :
				alert('폭탄을 획득하셨습니다.\n*능력: 한번 던지면모든 두더지가 사라집니다.');
				type = 'C';
				$('span').click(function(){
					$('[name=dude]').stop(true, true);
					$('[name=dude]').fadeOut(150);
					score = score + pin.length * 100;
					play(3);
					pin.length = 0;
					$('#score-view').html('Score : ' + score);
				});
				break;
			}
		}
		weapon(toolIdx);
		
		// 두더지 등장 주기
		function showTime(){
			var showTime = Number((Math.random() * 4 + 3) * 100);
			if(gameTime == 20)
				showTime = Number((Math.random() * 4 + 2) * 100);
			if(gameTime == 10)
				showTime = Number(Math.random() * 400);
			
			return showTime;
		}
		
		// 두더지 랜덤 발생 트리거
		setInterval(function(){
			var showNum = Math.round(Math.random() * 8 - 0.4);
			
			$('#button' + showNum).keydown(function(){
				var fadeNum = Math.round(Math.random() * 1.5) * 100;
				var color = ['red', 'blue', 'purple', 'green'];
				var colorNum = Math.floor(Math.random() * 3);
				
				if(gameTime == 30){ i = 2500;	j = 'slow';		}
				if(gameTime == 20){ i = 2200;	j = 'normal';	}
				if(gameTime == 10){ i = 1900;	j = 'fast';		}
				
				$(this).children().css('background-color', color[colorNum])
								  .fadeIn(fadeNum, function(){
								  		pin.push('in');
								  }).delay(i).hide(j, function(){
									  pin.pop('in');
								  });
			});
			$('#button' + showNum).trigger('keydown');
		}, showTime());
		
		// 시간 카운트
		$('#time-cnt').keyup(function(){
			if(gameTime > 0) {
				gameTime = gameTime - 1;
			}
			time();
			if(gameTime == 10) weapon(2);
			if(gameTime == 0){
				alert('Score : ' + score);
				// 결과 페이지로 이동
// 				location.href='moleGame_Result.do?score=' + score + '&type=' + type;
			}
		});
		
		// 시간 트리거, 트리거 발생
		setInterval(function(){
			$('#time-cnt').trigger('keyup');
		}, 1000);
	});
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp" />
	</div>
	
	<div style="height: 100px;"></div>
	<div align="center">
		<h1 id="time-cnt"></h1>
		<div style="width:700px; height:350px; cursor:url(''), auto;" id="mole">
			<h3 id="score-view">Score : 0</h3>
			<table>
				<tr>
					<td id="button0"><span name="dude"></span></td>
					<td id="button1"><span name="dude"></span></td>
					<td id="button2"><span name="dude"></span></td>
				</tr>
				<tr>
					<td id="button3"><span name="dude"></span></td>
					<td id="button4"><span name="dude"></span></td>
					<td id="button5"><span name="dude"></span></td>
				</tr>
				<tr>
					<td id="button6"><span name="dude"></span></td>
					<td id="button7"><span name="dude"></span></td>
					<td id="button8"><span name="dude"></span></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>