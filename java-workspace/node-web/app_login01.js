/**
 * 	public -> login01.html
 */
// Express 기본 모듈
var express = require('express'),
	http	= require('http'),
	path	= require('path');

// Express 미들웨어
var bodyParser	= require('body-parser'),
	stat		= require('serve-static');

// Express 객체 생성
var app = express();

// 기본 속성 설정
app.set('port', process.env.PORT || 3000);

// body-parser를 사용해 application/x-www-form-urlencoded 파싱
app.use(bodyParser.urlencoded({
	extended : false
}));

// body-parser를 사용해 application/json 파싱
app.use(bodyParser.json());

// serve-static을 사용해 루프 패스 설정
app.use(stat(path.join(__dirname, 'public')));

app.use(function(req, res, next){
	console.log('미들웨어에서 요청 처리!');
	
	// GET -> query		POST -> body
	var paramId = req.body.id || req.query.id;
	var paramPassword = req.body.password || req.query.password;
	
	res.writeHead('200', {
		"Content-Type" : "text/html; charset=utf-8"
	});
	res.write('<h1>Express 서버에서 응답한 결과입니다.</h1>');
	res.write('<div><p>Param Id : ' + paramId + '</p></div>');
	res.write('<div><p>Param Password : ' + paramPassword + '</p></div>');
	res.end();
});

http.createServer(app).listen(3000, function(){
	console.log('Express Server Listening... on 3000');
});