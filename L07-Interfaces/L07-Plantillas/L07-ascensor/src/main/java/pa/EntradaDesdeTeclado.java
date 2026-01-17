package pa;
import java.util.ArrayList;
import java.util.Scanner;

public class EntradaDesdeTeclado implements IAccesoDatos {
	private final Scanner sc;

	public EntradaDesdeTeclado() {
		sc=new Scanner(System.in);
	}

	@Override
	public int[] obtenerDatos() {
		ArrayList<Integer> datos=new ArrayList<>();
		while(sc.hasNextInt()) {
			datos.add(sc.nextInt());
		}
		if(sc.hasNextLine()) {
			sc.nextLine(); //cuando colocamos cualquier caracter que no sea numero, por ejemplo A, añadimos un salto "" para que la proxima vez que se use, lea el espacio y no la letra y se siga ejecutando
		}
		int[] res=new int[datos.size()];
		for(int i=0;i<datos.size();i++) {
			res[i]=datos.get(i);
		}
		return res;
	}
	
	
	
	
}
