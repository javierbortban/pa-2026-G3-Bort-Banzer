package pa.sinInterfaces;

import java.util.ArrayList;
import java.util.Scanner;

import pa.Peticion;

public class Ascensor {
	// declaración de atributos. Son todos privados.
	private static final int MAX_PISO = 20;
	private static final int MAX_PERSONAS = 4;

	private final ArrayList<Peticion> peticiones;
	private final ArrayList<Peticion> peticiones_validas;
	private int piso_actual;
	private final Scanner lector_peticiones;

	public Ascensor() {
		peticiones = new ArrayList<>();
		peticiones_validas = new ArrayList<>();
		piso_actual = 0;
		lector_peticiones = new Scanner(System.in);
	}

	private String nuevo_aviso(Peticion p) {
		String mensaje_error;

		final int destino = p.getPiso_destino();

		// b) fuera de rango
		if (destino < 0 || destino > MAX_PISO) {
			mensaje_error = " - El usuario que ha pulsado " + destino + " ha introducido un valor incorrecto\n";
		}
		// c) mismo piso
		else if (destino == piso_actual) {
			mensaje_error = " - El usuario que ha pulsado " + destino + " ya está en esa planta\n";
		}
		// a) válida pero no cabe
		else {
			mensaje_error = " - El usuario que ha pulsado " + destino + " ya no cabe\n";
		}

		return mensaje_error;
	}

	public int leer_peticiones() {

		System.out.println("\n---------------------------------");
		System.out.println("Estoy en el piso: " + piso_actual);
		System.out.println("Puertas abiertas. Espero peticiones: ");

		int num = 0;

		// leemos enteros hasta encontrar la 'A'
		while (lector_peticiones.hasNextInt()) {
			final int destino = lector_peticiones.nextInt();
			peticiones.add(new Peticion(destino));
			num++;
		}

		// consume la 'A' y el fin de línea
		if (lector_peticiones.hasNextLine()) {
			lector_peticiones.nextLine();
		}

		return num;
	}

	public int analizar_peticicones() {
		String avisos = "";
		int num_avisos = 0;

		// analizamos una a una todas las peticiones (y las borramos de peticiones)
		while (!peticiones.isEmpty()) {
			final Peticion p = peticiones.remove(0);
			final int destino = p.getPiso_destino();

			final boolean destino_ok = (destino >= 0 && destino <= MAX_PISO);
			final boolean distinto_actual = (destino != piso_actual);
			final boolean valida = destino_ok && distinto_actual;

			if (valida && peticiones_validas.size() < MAX_PERSONAS) {
				peticiones_validas.add(p);
			} else {
				avisos += nuevo_aviso(p);
				num_avisos++;
			}
		}

		// mostramos los pisos de destino de los que entran
		if (!peticiones_validas.isEmpty()) {
			System.out.print(" Entran en el ascensor las personas que van a los pisos: ");
			for (Peticion p : peticiones_validas) {
				System.out.print(p.getPiso_destino() + ", ");
			}
			System.out.println();
		}

		// mostramos avisos si los hay
		if (num_avisos > 0) {
			System.out.println(" AVISOS:");
			System.out.print(avisos);
		}

		return num_avisos;
	}

	public void llevar_personas_a_sus_destinos() {

		System.out.println("Cerrando puertas. Estamos en el piso: " + piso_actual);

		Integer anterior_destino = null;

		// procesamos y eliminamos CADA petición válida
		while (!peticiones_validas.isEmpty()) {
			final Peticion p = peticiones_validas.remove(0);
			final int destino = p.getPiso_destino();

			if (anterior_destino != null && destino == anterior_destino) {
				System.out.println(" La siguiente persona también puede bajar");
				// piso_actual ya está en ese destino (porque la anterior era igual)
			} else if (destino > piso_actual) {
				System.out.println(" Subiendo a una persona la planta " + destino);
				piso_actual = destino;
			} else if (destino < piso_actual) {
				System.out.println(" Bajando a una persona la planta " + destino);
				piso_actual = destino;
			}

			anterior_destino = destino;
		}
	}
}
