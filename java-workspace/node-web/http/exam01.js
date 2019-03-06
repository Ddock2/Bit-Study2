/**
 *	웹 서버 만들기
 *
 *	http 모듈을 활용해서 서버 객체를 생성!
 *
 *	listen(port, [hostname], [backlog], [callback]);
 *	 : 서버 실행 후 대기
 *		port		: 대기할 포트 번호
 *		hostname	: 실제 대기시킬 IP 번호, 이더넷 카드나 아이피 번호가 여러 개일 때 사용
 *		backlog		: 동시 접속 연결 수
 *		callback	: 대기가 완료되면 실행할 콜백 함수
 *	
 *	 var host = '192.168.1.31';
 *	 var port = 3000;
 *	 server.listen(port, host, '50000', function(){ ... });
 */
var http = require('http');

// 웹 서버 객체 만들기
var server = http.createServer();

// 웹 서버 시작 후 3000번 포트로 대기
var port = 3000;
server.listen(port, function(){
	console.log('%d 포트 웹 서버가 시작되었습니다.', port);
});
