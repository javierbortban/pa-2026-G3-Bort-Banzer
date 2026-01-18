package pa.impresos;

import java.io.Serializable;
import java.time.LocalDate;

public class LineaFactura implements Serializable{
	private static final long serialVersionUID=1L;
	private String idCliente;
	private String servicio;
	private LocalDate date;
	private float importe;
	
	public LineaFactura(String idCliente,String servicio,LocalDate date,float importe) {
		this.idCliente=idCliente;
		this.servicio=servicio;
		this.date=date;
		this.importe=importe;
	}
	
	public String getIdCliente() {
		return idCliente;
	}
	
	public String getServicio() {
		return servicio;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public float getImporte() {
		return importe;
	}
	
	
}
