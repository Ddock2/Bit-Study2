package Anno.type01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain02 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:annoAppCtx02.xml");
		
		MyCalculator02 my = ctx.getBean("myCalculator", MyCalculator02.class);
		my.setFirstNum(7);
		my.setSecondNum(3);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
