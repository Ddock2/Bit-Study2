package com.bit.form;

/*
 	커맨드 패턴 (Command Pattern)
 		- Invoker(호출자, 발동자), Receiver(피호출자, 수신자)
 		- 호출자와 피호출자의 분리 (의존성 제거)
 		- 실제 수행할 기능(요청)을 캡슐화함으로 여러 기능을 재사용할 수 있는 방법(로깅)
 		
 		[구성]
 			- Command(명령)
 				수신자의 기능을 호출
 			- Invoker(발동자)
 				실제 기능 요청
 			- Receiver(수신자) + 캡슐화
 				Command에 호출이 됐다면, 실제 정의된 기능을 수행
 			- Client(클라이언트)
 		*실제 수신자의 기능이 변경되어도, 발동 방법은 변경이 없다
 		interface와 interface를 구현하는 class
 		 1. interface 거쳐서 발동자는 기능을 요청
 		 2. interface는 요청받을 것을 실제 구현 클래스로 전달
 		 3. 구현 클래스는 실제 기능을 수행
 		 4. 구현 클래스는 캡슐화를 통한 분리로 수신자를 따로 정의하여,
 		 	구현 클래스는 실제 기능을 수행(execute)
 */

// 커맨드 오브젝트
public class UserVO {
	private String id;
	private String password;
	private String name;
	
	public UserVO() {
		System.out.println("UserVO Created...");
	}
	public UserVO(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
}
