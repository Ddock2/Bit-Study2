/**
 * http://usejsdoc.org/
 */
var http = require('http');

// localhost:3000으로 접속!
http.createServer(function(request, response){
	response.writeHead(200, {'Content-Type' : 'text/html'});
	response.write('Hello Node.js');
}).listen(3000, function(){
	console.log('Server is listening on 3000');
});
