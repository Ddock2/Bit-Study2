/**
 *	이벤트 처리
 *	
 *	...
 *	<button id="btn1">버튼</button>
 *	<script>
 *		var btn1 = document.getElementById('btn1');
 *		btn1.onclick = function() {
 *			alert('click');
 *		}
 *	</script>
 *	...
 *
 *	btn.onclick	-> 이벤트
 *	function	-> 버튼을 클릭했다는 이벤트가 발생했을 때 호출되는 콜백함수
 *	
 *	노드에서는 사용자가 이벤트를 만들고 활용하는 EventEmitter 제공!
 *	
 *	사용자가 이벤트를 발생시킬 함수를 선택 ( 자바스크립트의 함수는 객체의 원형 )
 *	즉, 함수에 EventEmitter를 상속!
 */
var TestModule = require('./my-event');

var test = new TestModule();
var result = test.say(10, 20);

if(result === 30){
	test.emit('hello');
}else {
	console.log(result);
}