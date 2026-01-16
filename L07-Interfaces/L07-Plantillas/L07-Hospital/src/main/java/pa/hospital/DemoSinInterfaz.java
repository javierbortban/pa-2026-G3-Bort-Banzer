package pa.hospital;
import pa.hospital.SinInterfaz.*;

public class DemoSinInterfaz {

	public static void main(String[] args) {
		Quirofano q1=new Quirofano("Q1");
		Quirofano q2=new Quirofano("Q2");
		SalaVideo s1=new SalaVideo(1);
		SalaVideo s2=new SalaVideo(2);
		GestionSalaHospital g1= new GestionSalaHospital ();
		g1.reservarQuirofano(q1);
		g1.reservarQuirofano(q2);
		g1.anularQuirofano(q1);
		g1.anularQuirofano(q2);
		g1.reservarSalaVideo(s1);
		g1.reservarSalaVideo(s2);
		g1.anularSalaVIdeo(s1);
		g1.anularSalaVIdeo(s2);
		
	}

}
