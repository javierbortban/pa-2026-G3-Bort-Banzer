package pa;
public class Demo {

	public static void main(String[] args) {
		IAccesoDatos acceso;
		if(args.length>0 && args[0].equalsIgnoreCase("Fichero")) {
			acceso=new EntradaDesdeFichero();
			System.out.println("estoy aqui");
		}
		else {
			acceso=new EntradaDesdeTeclado();
			System.out.println("t");
		}
		Ascensor ascensor=new Ascensor(acceso);
		while(true) {
			int total = ascensor.leer_peticiones();
			int rechazos = ascensor.analizar_peticicones();
			System.out.println("Numero total de peticiones: "+ total +", Peticiones rechazadas: "+ rechazos);
			if (total==0) {
				System.out.println("Ascensor inactivo.");
				break;
			}
			ascensor.llevar_personas_a_sus_destinos();
		}
	}

}
