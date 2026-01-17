package pa.coffee;
import java.util.ArrayList;

import pa.excepciones.TooColdException;
import pa.excepciones.TooHotException;

public class VirtualCafe {
	private String name;
	private ArrayList<VirtualPerson> clients;
	private double ganancias;
	private static final double PRECIO_CAFE=2.00;
	private static final double PROPINA=0.50;
	
	public boolean serveCustomer(VirtualPerson v, CoffeeCup c) {
		System.out.println("Hola "+v.getName()+", aquí tiene su café");
		try {
			v.drinkCoffee(c);
			cobrarCafe(true);
			return false;
		} catch (TooColdException e) {
			System.out.println("    "+v.getName()+": Tráigame otro café");
			return true;
		} catch (TooHotException e) {
			System.out.println("    No le dejaré propina");
			cobrarCafe(false);
			return false;
		}
	}
	
	public VirtualCafe(String name) {
		this.name = name;
		this.clients= new ArrayList<>();
		this.ganancias=0.0;
		System.out.println("La cafetería "+name+" abre sus puertas");
	}

	public String getName() {
		return name;
	}
	
	public void addClient(VirtualPerson p,boolean nuevoCliente) {
		clients.add(p);
		if (nuevoCliente) {
			System.out.println("El cliente "+p.getName()+" ha entrado en la cafetería "+name);
		}
		
	}
	
	public ArrayList<VirtualPerson> getClients() {
		return clients;
	}
	
	public int getNumberClients() {
		int num_clientes= clients.size();
		return num_clientes;
	}
	
	public VirtualPerson getNextClient() {
		if(!clients.isEmpty()) {
			VirtualPerson proximo_cliente=clients.remove(0);
			return proximo_cliente;
		}
		else {
		return null;
		}
	}
	
	private void cobrarCafe(boolean deja_propina) {
		double total=PRECIO_CAFE;
		if(deja_propina) {
			total+=PROPINA;
		}
		ganancias +=total;
		System.out.println("    Cobrado: "+total+" euros");
	}
	
	public double getGanancias() {
		return ganancias;
	}
	
}
