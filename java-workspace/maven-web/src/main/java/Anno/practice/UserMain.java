package Anno.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:annoPracticeAppCtx.xml");
		
		MyCalculator my = ctx.getBean("myCalculator", MyCalculator.class);
		my.setFirstNum(7);
		my.setSecondNum(3);
		
		my.add();
		my.sub();
		my.mul();
		my.div();
	}
}
