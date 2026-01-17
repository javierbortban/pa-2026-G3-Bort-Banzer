package pa;
import pa.coffee.*;
import pa.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public class Demo_coffee {

	public static void main(String[] args) {
		System.out.println("Comenzamos...");
		System.out.println("Creamos los cafés que podemos servir:");
		String[] valores= {"aaa", "","20","95", "75", "18", "35.7", "55"};
		List<CoffeeCup> cafes=new ArrayList<>();
		
		for(String s:valores) {
			try {
				if(s.isEmpty()) {
					System.out.println("Detectado un valor de temperatura vacío");
				}
				else {
					int temp=Integer.parseInt(s);
					cafes.add(new CoffeeCup(temp));
					System.out.println("  La entrada con valor: "+temp+" es correcta");
				}
			}catch(NumberFormatException e){
				System.out.println("Entrada incorrecta: "+s+" no es un número entero");
				
			}
		}
		System.out.println();
		VirtualCafe c= new VirtualCafe("Dolche Gusto");
        System.out.println("====================================================");
        System.out.print("Podemos preparar hasta " + cafes.size() + " cafés con diferentes temperaturas: ");
        
        for(int i=0;i<cafes.size();i++) {
        	System.out.print(cafes.get(i).getTemperature());
        	if ((cafes.size()-i)>2) {
        		System.out.print(" ,");
        	}else if((cafes.size()-i)==1) {
        		System.out.print(" y ");
        	}	
        }
        System.out.println();
        System.out.println();
		String[] clientes= {"", "Roberto","Verónica","Alberto","María"};
		
		for(String n:clientes) {
			VirtualPerson p;
			if(n.isEmpty()) {
				p=new VirtualPerson();
			}else {
				p=new VirtualPerson(n);
			}
			c.addClient(p, true);
		}
		System.out.println();
		System.out.println("Tenemos que atender a los siguientes clientes: ");
		for (VirtualPerson persona:c.getClients()) {
			System.out.println("  -"+persona.getName());
		}
		System.out.println();
		int indiceCafe=0;
		VirtualPerson cliente;
		
		while((cliente=c.getNextClient())!=null) {
			CoffeeCup cafeActual= cafes.get(indiceCafe);
			indiceCafe=(indiceCafe+1)%cafes.size();
			
			boolean otroCafe=c.serveCustomer(cliente, cafeActual);
			
			if (otroCafe) {
				System.out.println("No se preocupe "+cliente.getName()+": Ahora le traemos otro café");
				c.addClient(cliente, false);
			}
		}
		System.out.println();
		System.out.println("Ya no quedan clientes a los que servir");
		System.out.println();
		System.out.println("Hoy se ha recaudado un total de "+c.getGanancias()+" euros");
	}

}
