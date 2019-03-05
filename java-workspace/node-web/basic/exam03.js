/**
 *	my-calculator Module 사용
 */

// 모듈을 페이지에서 사용하겠다
var myCalcModule = require('./my-calculator');

console.log('덧셈 : %d', myCalcModule.add(10, 20));
console.log('뺄셈 : %d', myCalcModule.sub(10, 20));
console.log('곱셈 : %d', myCalcModule.mul(10, 20));
console.log('나눗셈 : %d', myCalcModule.div(10, 20));
