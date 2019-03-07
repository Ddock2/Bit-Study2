/**
 * 	요청(request) 객체에서 추가한 파라미터와 헤더 활용
 * 	
 * 	query	: 클라이언트에서 GET 방식으로 전송한 요청 파라미터를 확인
 * 	body	: 클라이언트에서 POST 방식으로 전홍한 요청 파라미터를 확인
 * 				* body-parser와 같은 외장 모듈을 사용!
 * 	header(name) : 헤더 확인
 * 
 *  GET 방식
 *  	: http://localhost:3000?name=mammoth&age=80
 *  		-> ? 뒤에 있는 name=mammoth, age=80 파라미터
 *  		-> querystring
 *  	예시) var paramName = req.query.name
 */
var express = require('express'), http = require('http');
var app = express();

app.use(function(req, res, next){
	console.log('첫 번째 미들웨어 요청 처리!');
	
	var userAgent = req.header('User-Agent'); // 사용자 브라우저 정보
	var paramName = req.query.name;	// querystring의 name 파라미터
	var paramAge = req.query.age;	// querystring의 age 파라미터
	
	res.writeHead('200', {"Content-Type" : "text/html; charset=utf-8"});
	res.write('<h1>Express 서버 응답 결과</h1>');
	res.write('<div><p>User-Agent : ' + userAgent + '</p></div>');
	res.write('<div><p>Param Name : ' + paramName + '</p></div>');
	res.write('<div><p>Param Age : ' + paramAge + '</p></div>');
	res.end();
});

http.createServer(app).listen(3000, function(){
	console.log('Express 서버 3000 포트 가동!');
});