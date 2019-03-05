/**
 *	사용자 정의 모듈 (exam03.js)
 */
// exports를 활용한 방법
//	- 속성을 직접 추가하여 여러 변수나 함수를 각각의 속성으로 활용!
//exports.add = function(a, b){
//	return a + b;
//};
//
//exports.sub = function(a, b){
//	return a - b;
//};
//
//exports.mul = function(a, b){
//	return a * b;
//};
//
//exports.div = function(a, b){
//	return a / b;
//};

// module.exports를 활용한 방법
var calc = {};
calc.add = function(a, b){
	return a + b;
};
calc.sub = function(a, b){
	return a - b;
};
calc.mul = function(a, b){
	return a * b;
};
calc.div = function(a, b){
	return a / b;
};
module.exports = calc;