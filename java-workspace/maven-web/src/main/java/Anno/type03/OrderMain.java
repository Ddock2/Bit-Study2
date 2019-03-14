package Anno.type03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class OrderMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx
			= new GenericXmlApplicationContext("carAppCtx.xml");
		
		OrderManager manager = (OrderManager) ctx.getBean("orderManager");
		manager.order();
	}
}
