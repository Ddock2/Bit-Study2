package Anno.type03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Bean의 id를 audi로 설정하고, 비지니스 로직 포함
@Service("audi")
public class AudiMaker implements CarMaker{
	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		car.setName("Audi A7");
		System.out.println(car.getName() + "을 " + money.getAmount() + "에 판매!");
		
		return car;
	}
}
