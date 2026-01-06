package pa;

import pa.Interfaces.*;
import pa.sorting.*;

public class Demo1 {

	public static void main(String[] args) {
		System.out.println("Original (Paises)");
		System.out.println("=================");
		Country[] c= {
				new Country("España"),
				new Country("Venezuela"),
				new Country("Francia"),
				new Country("Belgica"),
				new Country("Holanda"),
				
		};
		System.out.print("\t");
		for (Country pais:c) {
			System.out.print(pais.getName()+" ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Ordenado (Paises)");
		System.out.println("=================");
		Sort.selectionSort(c);
		System.out.print("\t");
		for (Country pais:c) {
			System.out.print(pais.getName()+" ");
		}
		Grade[] g= {
				new Grade(8.5),
				new Grade(4.5),
				new Grade(0.2),
				new Grade(5.0),
				new Grade(1.6),
				new Grade(8.5)
		};
		System.out.println();
		System.out.println();
		System.out.println("Original (Notas)");
		System.out.println("=================");
		System.out.print("\t");
		for (Grade nota:g) {
			System.out.print(nota.getValue()+" ");
		}
		System.out.println();
		System.out.println();
		Sort.selectionSort(g);
		System.out.println("Ordenado (Notas)");
		System.out.println("=================");
		System.out.print("\t");
		for (Grade nota:g) {
			System.out.print(nota.getValue()+" ");
		}
		System.out.println();
		System.out.println();
	}

}
