package Anno.type03;

import org.springframework.stereotype.Component;

@Component("money")
public class Money {
	private int amount;
	
	public Money() {
		super();
	}
	public Money(int amount) {
		super();
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
