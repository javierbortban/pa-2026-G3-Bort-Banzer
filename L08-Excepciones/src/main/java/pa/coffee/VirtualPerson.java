package pa.coffee;
import pa.excepciones.*;

public class VirtualPerson {
	private int TOO_COLD=35;
	private int TOO_HOT=85;
	private String name;
	
	
	public VirtualPerson() {
		this.name = "anónimo";
	}
	public VirtualPerson(String name) {
		this.name = name;
	}
	
	public void drinkCoffee(CoffeeCup c) throws TooColdException, TooHotException {
		System.out.println("    "+name+": me voy a tomar un café");
		int temperature=c.getTemperature();
		
		if (temperature<=TOO_COLD) {
			throw new TooColdException(name + ": el café está a " + temperature + " grados: Demasiado FRÍO");
		}
		else if(temperature>=TOO_HOT) {
			throw new TooHotException(name + ": el café está a " + temperature + " grados: Demasiado CALIENTE");
		}
	}
	public String getName() {
		return name;
	}
	
}
