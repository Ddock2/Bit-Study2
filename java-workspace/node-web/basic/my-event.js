/**
 *	evnent Module (exam07.js)
 */
var util = require('util');	// 상속을 위한 util 모듈
var EventEmitter = require('events').EventEmitter;	// EventEmitter

var Test = function(){
	this.on('hello', function(){	// 이벤트 리스너 등록 (on 메소드)
		console.log('hello 이벤트 발생!');
	});
};

util.inherits(Test, EventEmitter);	// Test 객체에 EventEmitter 상속

Test.prototype.say = function(a, b){
	console.log('나는 테스트 객체 입니다.');
	return a + b;
};

module.exports = Test;
module.exports.title = '테스트 모듈입니다.'; // 변수를 직접 exports 가능!