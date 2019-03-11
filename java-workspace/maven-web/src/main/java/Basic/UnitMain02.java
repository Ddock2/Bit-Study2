package Basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class UnitMain02 {
	public static void main(String[] args) {
		Resource resource
//			= new ClassPathResource("applicationContext.xml");
			= new FileSystemResource("D:\\git\\bit2\\java-workspace\\maven-web\\src\\main\\resources\\applicationContext.xml");
		BeanFactory factory
			= new XmlBeanFactory(resource);
		
		// BeanFactory는 getBean 마다 생성하여 받아온다
		Unit obj = (Unit)factory.getBean("unit01");
		obj.prnMsg();
		
		Unit obj2 = (Unit)factory.getBean("unit02");
		obj2.prnMsg();
		
		// 이미 만들어져 있는 객체를 가져온다 (단일체)
		Unit obj3 = (Unit)factory.getBean("unit01");
		obj3.prnMsg();
	}
}
