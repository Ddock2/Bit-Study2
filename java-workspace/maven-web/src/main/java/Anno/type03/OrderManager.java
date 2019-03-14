package Anno.type03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {
	// CarMaker 인터페이스 변수에 대입 가능한 Bean을 찾아 연결
	//	-> AudiMaker, BenzMaker (둘 이상이니 어느 것을 연결시킬지 모름)
	//	-> @Quailifier 한정자 활용
	@Autowired
	@Qualifier("audi")
	private CarMaker carmaker;
	
	// Money 클래스 변수에 대입 가능한 Bean을 찾아 연결
	@Autowired
	private Money money;
	
	public OrderManager() {
		super();
	}
	
	public void order() {
		money.setAmount(11700);
		@SuppressWarnings("unused")
		Car car = this.carmaker.sell(money);
	}
}
