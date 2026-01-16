package pa.hospital.SinInterfaz;


public class GestionSalaHospital {
	
	public GestionSalaHospital() {
		
	}
	
	public void reservarQuirofano(Quirofano q) {
		System.out.println("Reservando quirófano " + q.getId());
	
	}
	public void anularQuirofano(Quirofano q) {
		System.out.println("Anulando reserva de quirófano " + q.getId());
	}
	public void reservarSalaVideo(SalaVideo s) {
		System.out.println("Reservando Sala de Video " + s.getId());
	}
	public void anularSalaVIdeo(SalaVideo s) {
		System.out.println("Anulando reserva de Sala de Video " + s.getId());
	}
	
}
