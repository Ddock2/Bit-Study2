package Anno.type02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// empAppCtx.xml의 Bean으로 등록!
// <context:component-scan/>을 통해 해당 패키지의  @Component
@Component
public class Development {
	Emp emp;
	
	public Development() { System.out.println("Development..."); }
	
	// @Component를 활용해 등록한 Bean과 연결
	//	- Programmer Bean이 존재할 경우에만 본 생성자를 수행!
	//	- @Autowired의 require를 false로 두면, 예외 무시!
	//	- 예외를 무시했다면, 기본 생성자 호출로 Bean을 생성
	@Autowired/*(required=false)*/
	public Development(@Qualifier(value="programmer") Emp emp) {
		this.emp = emp;
		System.out.println("의존 주입...");
	}
	
	
//	@Autowired
//	@Qualifier("programmer")
//	public Development(Emp emp) {	// 생성자 DI
//		this.emp = emp;				// 의존 주입
//	}
	
	public void work() {
		emp.gotoOffice();
		System.out.println("작업을 시작합니다.");
		emp.gotoHome();
	}
}
