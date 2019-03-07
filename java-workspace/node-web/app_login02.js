/**
 * 	public -> login02.html
 * 	
 * 	라우터 미들웨어 (Router Middleware)
 * 		라우터 객체 등록 메소드
 * 			get(callback)		: GET	 방식 처리 및 요청 시 콜백 함수 지정
 * 			post(callback)		: POST	 방식 처리 및 요청 시 콜백 함수 지정
 * 			put(callback)		: PUT	 방식 처리 및 요청 시 콜백 함수 지정
 * 			delete(callback)	: DELETE 방식 처리 및 요청 시 콜백 함수 지정
 * 			all(callback)		: 모든	 방식 처리 및 요청 시 콜백 함수 지정
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

// 라우터 객체 생성
var router = express.Router();

// 라우터 함수 등록
router.route('/process/login').post(function(req, res){
	console.log('/process/login 처리!');
	
	var paramId = req.body.id || req.query.id;
	var paramPassword = req.body.password || req.query.password;
	
	res.writeHead('200', {
		"Content-Type" : "text/html; charset=utf-8"
	});
	res.write('<h1>Express 서버에서 응답한 결과입니다.</h1>');
	res.write('<div><p>Param Id : ' + paramId + '</p></div>');
	res.write('<div><p>Param Password : ' + paramPassword + '</p></div>');
	res.write("<br><br><a href='/login02.html'>로그인 페이지 돌아가기</a>");
	res.end();
});

// 모든 요청 주소에 대한 처리
//	- 미들웨어는 "등록 순서대로 처리"하는 특성을 이용한 오류 페이지 처리!
//	- 단순히 페이지가 없을 때를 대비한 처리일 뿐!
router.all('*', function(req, res){
	res.status(404).send('<h1>Express 404 NOT FOUND. 페이지를 찾을 수 없습니다.</h1>');
});

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

// 라우터 미들웨어 등록
//	-> app 설정을 마친 후 마지막에 등록 시키는 것이 안전하다
app.use('/', router);

http.createServer(app).listen(3000, function(){
	console.log('Express Server Listening... on 3000');
});