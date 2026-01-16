package pa.hospital;

import pa.hospital.ConInterfaz.*;

public class DemoConInterfaz {

	public static void main(String[] args) {
		GestionSalaHospital g1=new GestionSalaHospital();
		Quirofano[] quirofanos= new Quirofano[5];
		SalaVideo[] salas= new SalaVideo[10];
		for(int i=0;i<quirofanos.length;i++) {
			quirofanos[i]=new Quirofano();
			g1.reservar(quirofanos[i]);
		}
		for(int i=0;i<salas.length;i++) {
			salas[i]=new SalaVideo();
			g1.reservar(salas[i]);
		}
		for(Quirofano q:quirofanos) {
			g1.anular(q);
		}
		for(SalaVideo s:salas){
			g1.anular(s);
		}

	}

}
