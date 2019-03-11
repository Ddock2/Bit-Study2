package Basic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UnitMain01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext(
					"classpath:applicationContext.xml"
					);
		
		// 식별자와 어느 클래스인지를 전달!
		Unit obj = ctx.getBean("unit01", Unit.class);
		obj.prnMsg();
		
		Unit obj2 = ctx.getBean("unit02", Unit.class);
		obj2.prnMsg();
		
		// getBean 호출 시에 객체가 생성되는 것이 아니라
		// 단순히 이미 생성된 객체를 가져올 뿐 -> 단일체 패턴 (단일 객체 참조)
		Unit obj3 = ctx.getBean("unit01", Unit.class);
		obj3.prnMsg();
		
		ctx.close();
	}
}
