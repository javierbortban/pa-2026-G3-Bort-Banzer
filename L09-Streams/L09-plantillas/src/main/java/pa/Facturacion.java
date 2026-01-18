package pa;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import pa.impresos.*;
public class Facturacion {
	private ArrayList<Factura> listaFacturas;

	public Facturacion() {
		this.listaFacturas=new ArrayList<>();
	}
	
	public ArrayList<Factura> getFacturas() {
		return listaFacturas;
	}
	
	public Factura buscarFactura(String nombreCliente) {
		for(Factura f:listaFacturas) {
			String nombrelista=f.getCliente();
			if(nombrelista.equals(nombreCliente)) {
				return f;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Facturacion f=new Facturacion();
		Console console=System.console();
		
		if(console==null) {
			System.out.println("Ejecute el programa desde el terminal");
			return;
		}
		
		int intentos=0;
		boolean ok=false;
		
		while(intentos<3&&!ok) {
			ok=f.login();
			intentos++;
		}
		
		if(ok) {
			System.out.println("Bienvenido.");
		}
		
		ArrayList<LineaFactura> lineas=f.leerLineas("src/main/resources/datosLineas.txt");
		f.generarFacturas(lineas);
		f.imprimirFacturas();
		f.guardarFicheroFacturas();
		f.leerFicheroFacturas();
	}
	public void imprimirFacturas() {
		for(Factura f:listaFacturas) {
			String nombreFichero="factura"+f.getId()+".txt";
			
			try(BufferedWriter bw=new BufferedWriter(new FileWriter(nombreFichero))){
				bw.write("Id factura: "+f.getId()+"Fecha: "+f.getFecha().toString());
				bw.newLine();
				bw.write("Cliente:"+f.getCliente());
				bw.newLine();
				bw.write(String.format("%-14s%-16s%-10s","Fecha","Servicio","Importe"));
				bw.newLine();
				bw.write(String.format("%-14s%-16s%-10s","-","-","-").replace("", "-"));
				
				for(LineaFactura l:f.getLineas()) {
					bw.write(String.format("%-14s",l.getDate().toString()));
					bw.write(String.format("%-16s",l.getServicio()));
					bw.write(String.format("%-10s",l.getImporte()));
				}
				
				bw.write("Total importe: "+f.getTotal()+" euros");
			} catch (IOException e) {
				System.out.println("Error escribiendo " + nombreFichero );
				System.out.println(e.getMessage());
			}
			}
	}
	
	public void guardarFicheroFacturas() {
		System.out.println("GUARDANDO FACTURAS");
		try(ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("facturas.dat")))){
			 for (Factura f : listaFacturas) {
		            oos.writeObject(f);
		            System.out.println("Guardada factura " + f.getId());
		            }	
		}
		catch (EOFException ex) {
		}
		catch(IOException e) {
			System.out.println("Error en las operaciones de E/S con ficheros.");
			System.out.println(e.getMessage());
		}
	}
	
	public void leerFicheroFacturas() {
		try(ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream("facturas.dat")))){
			while(true) {
				Factura f= (Factura) ois.readObject();
				System.out.println();
				System.out.println("FACTURA leida");
				System.out.println("Fecha: " + f.getFecha());
	            System.out.println("Cliente: " + f.getCliente());
	            System.out.println("Total factura: " + f.getTotal() + " euros");
	            System.out.println("Número de líneas: " + f.getLineas().size());
	            for (LineaFactura lf : f.getLineas()) {
	                System.out.println("   Servicio: " + lf.getServicio()
	                        + " " + lf.getDate()
	                        + " " + lf.getImporte());
	            }
			}
		}catch (ClassNotFoundException e) { //obligatorio al trabajar con Streams de objetos
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}catch(EOFException e) {
			
		}catch(IOException e) {
			System.out.println("Error en las operaciones de E/S con ficheros.");
			System.out.println(e.getMessage());
		}
	}
	
	public void generarFacturas(ArrayList<LineaFactura> lineas) {
		for(LineaFactura l:lineas) {
			String cliente=l.getIdCliente();
			Factura factura=buscarFactura(cliente);
			if(factura == null) {
				factura=new Factura(cliente);
				listaFacturas.add(factura);
			}
			factura.addLinea(l);
		}
		
	}
	
	public ArrayList<LineaFactura> leerLineas(String fichero){
		ArrayList<LineaFactura> res=new ArrayList<>();
		try (BufferedReader br= new BufferedReader(new FileReader(fichero))){
			ArrayList<String> bloque = new ArrayList<>(4);
	        String linea;

	        while ((linea = br.readLine()) != null) {
	            linea = linea.trim();

	            // 1) Ignorar líneas vacías para no desalinear el bloque
	            if (linea.isEmpty()) continue;

	            // 2) Acumular hasta tener 4 líneas (cliente, servicio, fecha, importe)
	            bloque.add(linea);

	            if (bloque.size() == 4) {
	                String cliente = bloque.get(0);
	                String servicio = bloque.get(1);
	                String fechaStr = bloque.get(2);
	                String importeStr = bloque.get(3);

	                LocalDate fecha = LocalDate.parse(fechaStr);

	                // por si viene "175.75f"
	                float importe = Float.parseFloat(importeStr.replace("f", "").trim());

	                res.add(new LineaFactura(cliente, servicio, fecha, importe));

	                bloque.clear(); // listo para el siguiente bloque
	            }
	        }

	        // Si el fichero acaba “a medias”, avisamos (opcional pero útil)
	        if (!bloque.isEmpty()) {
	            System.out.println("[WARNING] Fichero terminado con un bloque incompleto: " + bloque);
	        }
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return res;
		
	}
	
	public boolean login() {
		Console console=System.console();
		if(console==null) {
			return false;
		}
		String login=console.readLine("Login: ");
		char[] passwordchars=console.readPassword("Contraseña: ");
		String password=new String(passwordchars);
		if(login.equals("usuario") && password.equals("factura")) {
			System.out.println("Credenciales válidos");
			System.out.println();
			return true;
		}
		else {
			System.out.println("Login o contraseña inválido");
			System.out.println();
			return false;
		}
		
	}
	
	
}
