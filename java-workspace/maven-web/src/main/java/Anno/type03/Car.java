package Anno.type03;

import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	private String name;
	
	public Car() { super(); }
	public Car(String name) {
		super();
		this.name = name;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
}
