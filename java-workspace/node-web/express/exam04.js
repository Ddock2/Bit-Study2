/**
 *	send()
 *		: express에서 응답을 조금 더 단순히 하기 위한 메소드
 */
var express = require('express'), http = require('http');
var app = express();

app.use(function(req, res, next){
	console.log('첫 번째 미들웨어에서 요청 처리');
//	res.send({ name : 'Mammoth', age : 80});
//	res.status(403).send('Forbidden');	// 403 : 허용 금지
	// 상태 코드 생성 및 메시지와 함께 전송!
//	res.sendStatus(403);	// 상태코드만 전달
	
	res.redirect('https://google.com');	 // google 페이지 이동
});

http.createServer(app).listen(3000, function(){
	console.log('Express 서버가 3000 포트에서 구동...');
});