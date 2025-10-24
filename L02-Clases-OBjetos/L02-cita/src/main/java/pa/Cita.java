package pa;

public class Cita {
	private int inicio; //0..24
	private int fin;  //0..24
	private int dia_semana;  //0..6
	
	public Cita() {
		this.dia_semana = 0;
		this.inicio = 0;
		this.fin = 1;	
	}
	
	public int getInicio() {
		return inicio;
	}
	
	public int getFin() {
		return fin;
	}
	
	public int getDia() {
		return dia_semana;
	}
		
	public void setDia(int dia) {
		if (dia >=0 && dia <=6 ) {
			dia_semana= dia;
		}
	}
	
	public void setFranjaHoraria(int inicio, int fin) {
		if (franja_es_valida(inicio,fin)) {
			this.inicio= inicio;
			this.fin = fin;
		}
	}
	
	private boolean hora_valida(int hora) {
		return hora >=0 && hora <=24;
	}
	
	private boolean franja_es_valida(int inicio, int fin) {
		return hora_valida(inicio) && hora_valida(fin) && inicio<fin;
	}
		
	public boolean solapa_con(Cita c) {
		if(this.dia_semana != c.dia_semana) {
			return false;
		}
		
		boolean noSolapan= (this.fin<c.inicio) || (this.inicio <=c.fin);
		
		return !noSolapan;
	}
	
	private String mostrarDia(int dia) {
		switch (dia) {
		case 0: return "Lunes" ;
		case 1: return "Martes" ;
		case 2: return "Miércoles" ;
		case 3: return "Jueves" ;
		case 4: return "Viernes" ;
		case 5: return "Sábado" ;
		case 6: return "Domingo";
		default: return "Dia inválido";
		}
	}
	
	public void imprimir() {
		System.out.println();
		System.out.println("Datos de la cita:");
		System.out.println("  " + "-hora de inicio: " + inicio);
		System.out.println("  " + "-hora fin: " + fin);
		System.out.println("  " + "-dia semana: " + mostrarDia(dia_semana));
		
		
	}

}
