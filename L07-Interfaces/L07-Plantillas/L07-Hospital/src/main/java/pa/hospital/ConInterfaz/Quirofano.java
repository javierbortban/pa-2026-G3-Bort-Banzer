package pa.hospital.ConInterfaz;

public class Quirofano implements ISala{
	private static int contador=0;
	private final String id;

	public Quirofano() {
		
		this.id="quirofano- "+contador;
		contador++;
	}

	public String getId() {
		return id;
	}

	@Override
	public void reservar() {
		System.out.println("\tReservado el quirófano: "+id);
		
	}

	@Override
	public void anular() {
		System.out.println("\tAnulada la reserva del quirófano: "+id);
		
	}
	
	
	
	

}
