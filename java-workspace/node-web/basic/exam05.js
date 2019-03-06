/**
 *	주소 문자열 (URL), 요청 파라미터(Query String) 다루기
 */

// url 모듈 가져오기
var url = require('url');

// parse() : 주소 문자열 URL 객체로 반환
var curURL = url.parse('https://www.naver.com');

// format() : URL 객체를 주소 문자열로 반환
var curStr = url.format(curURL);

console.log('주소 문자열 : %s', curStr);
console.log(curURL);