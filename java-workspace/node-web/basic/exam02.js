/**
 * 	Process 객체
 * 	 - 프로그램을 실행했을 때 생성되는 프로세스에 대한 정보를 다룰 수 있는 객체
 * 
 * 	 argv	: 프로세스 실행 시 전달된 파라미터 정보
 * 	 env	: 환경변수 정보
 * 	 exit()	: 프로세스 종료 메소드
 */

// argv로 전달된 파라미터 개수
console.log('argv 속성의 파라미터 개수 : %d', process.argv.length);

// argv로 전돨된 파라미터 확인
console.dir(process.argv);

// 환경 변수 
console.dir(process.env);