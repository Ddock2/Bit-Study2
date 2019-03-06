/**
 *	http 모듈을 활용한 타 웹 서버에 데이터 요청
 *	( GET, POST )
 */
// GET
var http = require('http');

var options = {
	host : 'www.google.com',
	port : 80,
	path : '/'
};

// http의 get 메소드를 이용해서 options 객체에 설정된 host와 port 정보를 토대로 요청을 진행!
// data 이벤트를 통해 host에서 보낸 응답에 대한 res 객체를 구성
var req = http.get(options, function(res){
	var resData = '';
	// data 이벤트 : 데이터를 받는 중일 때
	res.on('data', function(chunk){
		resData += chunk;
	});
	// end 이벤트 : data 이벤트가 끝났을 때 (응답 데이터를 모두 받았을 때)
	res.on('end', function(){
		console.log(resData);
	});
});

req.on('error', function(err){
	console.log('에러 발생 -> ' + err.message);
});