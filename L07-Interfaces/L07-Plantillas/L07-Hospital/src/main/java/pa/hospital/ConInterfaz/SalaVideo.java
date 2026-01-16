package pa.hospital.ConInterfaz;

public class SalaVideo implements ISala {
	private static int contador=100;
	private final int id;

	public SalaVideo() {
		this.id = contador;
		contador++;
		
	}

	public int getId() {
		return id;
	}

	@Override
	public void reservar() {
		System.out.println("--->Reservada la sala de video "+id);
		
	}

	@Override
	public void anular() {
		System.out.println("--->Anulada la reserva de sala de video "+id);
		
	}

	
	
	

}
