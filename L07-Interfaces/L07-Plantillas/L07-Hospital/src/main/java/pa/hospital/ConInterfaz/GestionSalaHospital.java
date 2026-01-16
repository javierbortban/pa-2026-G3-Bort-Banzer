package pa.hospital.ConInterfaz;

public class GestionSalaHospital {
	public void reservar(ISala sala) {
		sala.reservar();
	}
	public void anular(ISala sala) {
		sala.anular();
	}
	
}
