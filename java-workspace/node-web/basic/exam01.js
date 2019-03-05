/**
 * 	Node.js
 * 	 - 자바스크립트를 이용하여 웹 서버를 구성 할 수 있게 해주는 개발 도구
 * 	 - 특징
 * 		1. 개발자가 필요한 모듈과 패키지를 만들거나 사용 (레고를 조립하듯)
 * 		2. 비동기 입출력 (Non Blocking IO) 방식 적용
 * 		3. 이벤트 기반 입출력 방식 적용 (모듈 및 함수간의 상호작용)
 * 
 * 	 - 전역 객체
 * 		console		: 콘솔 창에 결과를 보여주는 객체
 * 		process		: 프로세스 실행에 대한 정보를 다루는 객체
 * 		exports, module.exports
 * 					: 모듈을 다루는 객체
 * 
 * 	 console.log 이외의 메소드
 * 		dir(Object)	: 자바스크립트 객체의 모든 속성을 보여줘라
 * 		time(id)	: 실행 시간을 측정하기 위한 시작 시간을 기록
 * 		timeEnd(id)	: time(id)에서 수행된 실행시간 측정을 끝내라
 */

var result = 0;
console.time('duration_time');
for(var i=0; i<=100000; i++){
	result += i;
}
console.timeEnd('duration_time');

var myObj = { name : 'person_name', age : 30};
console.dir(myObj);

console.log("현재 실행한 파일의 이름과 전체 절대 경로 : %s", __filename);
console.log("현재 실행한 파일의 전체 절대 경로 : %s", __dirname);

console.dir(process.argv);