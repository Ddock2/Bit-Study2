/**
 * XMLHttpRequest Module
 */

var httpRequest = null;

function getXMLHttpRequest() {
	if(window.XMLHttpRequest)
		return new XMLHttpRequest();
	else
		return null;
}

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	
	if(httpMethod != 'GET' && httpMethod != 'POST')
		httpMethod = 'GET';
	
	var httpParams = '';
	if(params != null && params != '') {
		for(var key in params){
			if(httpParams == '')
				httpParams = key + '=' + encodeURIComponent(params[key]);
			else
				httpParams += '&' + key + '=' + encodeURIComponent(params[key]);
		}
	}
	
	var httpURL = url;
	if(httpMethod == 'GET' && params != ''){
		httpURL = httpURL + '?' + httpParams;
	}
	
	httpRequest.onreadystatechange = callback;
	
	httpRequest.open(httpMethod, httpURL, true);
	
	if(httpMethod == 'POST')
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=utf-8');
	/*
	 	Content-Type
	 		: request 데이터의 type 정보를 표현
	 	
	 	Text
	 		- text/html
	 		- text/plain
	 		- text/javascript
	 		- text/css
	 	
	 	Application
	 		- appllication/x-form-urlencoded
	 		- application/json
	 		
	 	File
	 		- multipart/formed-data
	 	
	 	application/x-form-urlencoded
	 		- HTML 기본형식
	 		- 대용량 데이터 전송(파일 첨부)에는 비효율적, multipart/form-data를 활용
	 */
	
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}