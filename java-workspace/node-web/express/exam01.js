/**
 *	Express 활용
 *		
 *		http 객체만 활용해서 서버 생성하는 방법은 작업량이 많다.
 *		express를 통해 미들웨어, 라우터를 활용해 쉽게 서버를 구성한다.
 *		
 *		express의 시작점 app.js
 *			: main의 역할
 *		
 *		[app 객체 주요 메소드]
 *			set(name, value)	: 서버 설정을 위한 속성을 지정
 *			get(name)			: set으로 지정해준 속성 가져오기
 *			use(path, function)	: 미들웨어 함수 사용
 *			get(path, function) : 특정 경로로 요청된 정보를 처리
 */
var express = require('express'), http = require('http');

var app = express(); // 익스프레스 객체 생성

// 기본 포트 app 객체에 속성으로 설정
app.set('port', process.env.PORT || 3000);
	/*
	 * process.env.PORT 변수가 존재한다면 사용하고,
	 * 아니라면 3000번 포트를 사용하라
	 * 
	 * env			: 서버 모드 설정
	 * views		: 사용자에게 보여줄 view 폴더 배열 생성
	 * view engine	: 디폴트로 사용할 뷰 엔진 설정 (ejs, pug...)
	 * 	클라이언테에 보낼 응답 웹 문서를 만들 때 사용.
	 *  템프릿 형태로 만들어두고 사용.
	 */

// express 서버 생성
http.createServer(app).listen(app.get('port'), function(){
	console.log('express Server Start... -> ' + app.get('port'));
});
