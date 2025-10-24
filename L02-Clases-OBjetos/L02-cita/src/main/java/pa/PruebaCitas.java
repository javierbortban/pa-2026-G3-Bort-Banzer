package pa;

public class PruebaCitas {
	
	private void mostrar_si_hay_solape_entre(Cita citaA, Cita citaB) {
		citaA.imprimir();
		citaB.imprimir();
		
		System.out.print("Estas dos citas");
		if(citaA.solapa_con(citaB)) {
			System.out.println(" SOLAPAN");
		}else {
			System.out.println(" No solapan");
		}
		System.out.println();
	}

	public static void main(String[] args) {		
		PruebaCitas prueba = new PruebaCitas();
		Cita c1 = new Cita(); 
		c1.setDia(3); 
		c1.setFranjaHoraria(10, 12);
        Cita c2 = new Cita(); 
        c2.setDia(3); 
        c2.setFranjaHoraria(11, 13); 
        Cita c3 = new Cita(); 
        c3.setDia(3); 
        c3.setFranjaHoraria(7,  12); 
        Cita c4 = new Cita(); 
        c4.setDia(3);  
        c4.setFranjaHoraria(10, 11); 
        Cita c5 = new Cita(); 
        c5.setDia(3); 
        c5.setFranjaHoraria(16, 18); 
        Cita c6 = new Cita(); 
        c6.setDia(2); 
        c6.setFranjaHoraria(10, 11);
        
        prueba.mostrar_si_hay_solape_entre(c1, c2);
        prueba.mostrar_si_hay_solape_entre(c1, c3);
        prueba.mostrar_si_hay_solape_entre(c1, c4);
        prueba.mostrar_si_hay_solape_entre(c1, c5);
        prueba.mostrar_si_hay_solape_entre(c1, c6);
			
		}

	}
