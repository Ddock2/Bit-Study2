/**
 *	여러개의 미들웨어 활용
 *	
 *	미들웨어 내부의 기본 구성 요소
 *		1. 요청 객체 (request)
 *		2. 응답 객체 (response)
 *		3. 미들웨어 이동 (next)
 *	
 *	http 모듈에서 추가되는 미들웨어의 메소드
 *		send(body)		: 클라이언트에 응답 데이터 보내기 (html, buffer, json, jsonarray)
 *		status(code)	: http 상태 코드 반환
 *			-> 상태 코드는 end, send 같은 전송 메소드를 추가로 호출해야 전송 가능
 *		sendStatus(statusCode)
 *			: http 상태 코드 반환, 상태 코드는 상태 메시지와 함께 전송
 *		redirect(status, path)
 *			: 웹 페이지 경로를 강제 이동
 *		render(view, locals, callback)
 *			: 뷰 엔진을 사용해 문서를 만든 뒤 전송
 */
var express = require('express'), http = require('http');
var app = express();

// 첫 번째 미들웨어 등록
app.use(function(req, res, next){
	console.log('첫 번째 미들웨어에서 요청 처리!');
	
	req.user = 'Mammoth';
	next();	// 두 번째 미들웨어로 이동!
	// *반드시 다음 미들웨어로 이동 시켜라
});

app.use(function(req, res, next){
	console.log('두 번째 미들웨어에서 요청 처리!');
	
	res.writeHead('200', {
		"Content-Type" : "text/html; charset=utf-8"
	});
	res.end('<h1>Express 서버에서 ' + req.user + '가 응답한 결과입니다.');
});

http.createServer(app).listen(3000, function(){
	console.log('Express 서버가 3000 포트로 구동...');
});