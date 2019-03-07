/**
 *	express-error-handler
 *		: 여러 오류를 동시에 해결하고, 페이지 이동을 시켜줄 수 있는 미들웨어
 *			-> npm install express-error-handler --save
 */
var express = require('express'),
	http	= require('http'),
	path	= require('path');

var bodyParser	= require('body-parser'),
	stat		= require('serve-static'),
	expressErrorHandler
				= require('express-error-handler');

var app = express();

var router = express.Router();

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

app.set('port', process.env.PORT || 3000);

app.use(bodyParser.urlencoded({
	extended : false
}));

app.use(bodyParser.json());

app.use(stat(path.join(__dirname, 'public')));

app.use('/', router);

// *반드시 모든 라우터 등록을 한 후 오류 페이지를 등록! (핸들러 작성)
var errorHandler = expressErrorHandler({
	static : {
		'404' : './public/404.html'
	}
});

// 에러 처리 미들웨어 등록
app.use(expressErrorHandler.httpError(404));
app.use(errorHandler);

http.createServer(app).listen(3000, function(){
	console.log('Express Server Listening... on 3000');
});