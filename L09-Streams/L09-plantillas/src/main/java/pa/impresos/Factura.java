package pa.impresos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Factura implements Serializable {
	private static final long serialVersionUID=1L;
	private static int ultimoID=0;
	private static int MAX_LINEAS=6;
	private int id;
	private LocalDate fecha;
	private String cliente;
	private ArrayList<LineaFactura> lineas;
	private float total;
	
	
	
	public Factura(String cliente) {
		this.id=++ultimoID;
		this.cliente = cliente;
		this.fecha=LocalDate.now();
		this.total=0.0f;
		this.lineas=new ArrayList<>();
	}

	public ArrayList<LineaFactura> getLineas() {
		return lineas;
	}
	
	public int getId() {
		return id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	public void setLineas(ArrayList<LineaFactura> lineas) {
		this.lineas = lineas;
	}
	
	public int addLinea(LineaFactura l) {
		if(lineas.size()>=MAX_LINEAS) {
			return -1;
		}
		this.lineas.add(l);
		this.total+=l.getImporte();
		return this.lineas.size();
	}
	
	

}
