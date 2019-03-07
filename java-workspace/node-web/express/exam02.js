/**
 *	미들웨어 (Middleware)
 *		: 두 시스템을 연결하여 주고 받을 때 중간에서 동작하는 방법 (S/W)
 *			-> 요청에 대한 응답과정 중간에 필요한 동작을 수행!
 *	
 *	라우터 (Router) -> 라우팅
 *		: 네트워크에서 데이터를 보낼 경로를 처리
 *			-> 클라이언트에서 보내는 주소를 처리
 *	
 *	미들웨어, 라우터는 하나의 독립된 기능을 가진 함수!
 *		-> 웹 요청과 응답에 관한 정보를 활용하여, 필요한 처리를 할 수 있는 독립 함수!
 */
var express = require('express'), http = require('http');
var app = express();

// 사용할 미들웨어 등록
app.use(function(req, res, next){
	console.log('첫 번째 미들웨어에서 요청 처리!');
	
	res.writeHead(200, {
		"Content-Type" : "text/html; charset=utf-8"
	});
	res.end('<h1>Express 서버에서 응답한 결과입니다.</h1>');
});

http.createServer(app).listen(3000, function(){
	console.log('Express 서버가 3000 포트에서 구동...');
});