package programa_principal;
import pa.Medico;
import pa.Cita;
public class Prueba {

	public static void main(String[] args) {
		Medico m1=new Medico("001","Oftalmólogo");
		m1.printHorario();
		System.out.println();
		System.out.println("Iniciamos el proceso de reserva de Citas ...\n");
		String[] pacientes = {"Pedro", "María", "Lucas", "Ana", "Gloria", "Matias", "Eva", "Carlos"};
		String[] franjas =   {"mañana", "mañana", "mañana", "mañana", "mañana", "otro", "tarde", "tarde"};
		int[] dias = {2,2,2,2,2,3,8,4};
		int i=0;
		int n=0;
		for (int s=0; s<pacientes.length;s++) {
        	Cita cita = m1.reservarCita(dias[s],franjas[s], pacientes[s]); // miércoles por la mañana
        	i++;
        	if (cita != null) {
        		cita.imprimirCita();
        		} else {
        		System.out.println("Cita no posible para " + pacientes[s]);
        		n++;
        		}
        	}
		System.out.println("------------------------------------");
		System.out.println("\nTotal de citas procesadas: "+ i);
		System.out.println("Total de citas no procesadas: "+ n + "\n");
		
		m1.printHorario();
		}
}
