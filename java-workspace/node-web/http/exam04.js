/**
 *	http 모듈을 활용한 타 웹 서버에 데이터 요청
 *	( GET, POST )
 */
// POST
var http = require('http');

var opts = {
	host : 'www.google.com',
	port : 80,
//	method : 'POST',	// POST 방식 통신 설정
	path : '/',
	headers : {}
};

var resData = '';
var req = http.get(opts, function(res){
	res.on('data', function(chunk){
		resData += chunk;
	});
	res.on('end', function(){
		console.log(resData);
	});
});

opts.headers['Content-Type'] = 'application/x-www-forn-urlencoded';
req.data = 'q=node';	// 구글 검색한 검색어 (query)

opts.headers['Content-Length'] = req.data.length;
// 검색어가 달라 질 수 있으므로 길이 요청할 때 마다 새로 지정!

req.on('error', function(err){
	console.log('에러 발생 -> ' + err.message);
});

// 요청 전송
req.write(req.data);
req.end();