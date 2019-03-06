/**
 *	이벤트 처리
 *		- 클라이언트가 웹 서버에 접속 후 데이터를 요청 했을 때,
 *		  여러 상황에 맞추어 콜백 함수 등록!
 *
 *	 connection	: 클라이언트가 접속하여 연결 객체가 만들어질 때의 이벤트
 *	 request	: 클라이언트가 요청할 때 발생하는 이벤트
 *	 close		: 서버를 종료할 때 발생하는 이벤트
 *	 
 *	 writeHead(statusCode, statusMassage, headers);
 *		: 응답으로 보낼 헤더 생성
 *	 		statusCode		-> 상태 코드
 *			statusMessage	-> 상태 메시지
 *			headers			-> 헤더 객체
 *	
 *	 write(chunk, encoding, callback);
 *		: 응답 본문 생성, 여러번 호출 가능!
 *			chunk		-> body를 구성할 조각
 *			encoding	-> 문자열 인코드 타입
 *			callback	-> 콜백 함수
 *	
 *	 end(data, encoding, callback);
 *		: 실제 응답 전송
 *			data		-> 최종 응답에 포함할 데이터
 *			encoding	-> 포함할 데이터의 인코드 타입
 *			callback	-> 콜백 함수 (응답이 최종적으로 전송된 후)
 */
var http = require('http');
var server = http.createServer();
var port = 3000;

// 클라이언트 연결 이벤트 처리
// TODO 이벤트 리스너 -> 콜백 함수가 왜 중복 호출이 되는가?
// 유저 접속을 위한 연결과 브라우저의 접속으로 총 2번 연결
// 브라우저에서는 http://hostname/favicon.ico 를 찾기 위해 요청
//		favicon.ico : 브라우저 title의 로고
//
// 예시) https://www.naver.com/favicon.ico -> 네이버 즐겨찾기 아이콘
server.on('connection', function(socket){
	console.log('클라이언트가 접속했습니다');
});

// 클라이언트 요청 이벤트 처리
server.on('request', function(req, res){
	console.log('클라이언트의 요청이 들어왔습니다.');
	
	// 접속한 클라이언테에게 응답
	res.writeHead(200, {'Content-Type' : 'text/html; charset=utf-8'});
	res.write('<!DOCTYPE html>');
	res.write('<html>');
	res.write('<head>');
	res.write('	<title>응답 페이지</title>');
	res.write('</head>');
	res.write('<body>');
	res.write('		<h1>Hello Node 응답입니다!</h1>');
	res.write('</body>');
	res.write('</html>');
	res.end();	// 응답 끝! 클라이언트로 응답 전송 완료
});

// 서버 종료 이벤트 처리
server.on('close', function(){
	console.log('서버가 종료되었습니다.');
});

server.listen(port, function(){
	console.log('%d 포트 웹 서버가 구동되었습니다.', port);
});