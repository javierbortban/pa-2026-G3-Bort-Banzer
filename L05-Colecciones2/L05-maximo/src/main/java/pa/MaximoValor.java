package pa;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MaximoValor {

	public static void main(String[] args) {
		System.out.println("Introduzca los datos con o sin decimales separados con espacios.");
		System.out.println("Teclee una letra para finalizar");
		Scanner s= new Scanner(System.in);
		s.useLocale(Locale.ENGLISH);
		ArrayList<Double> numeritos= new ArrayList<>();
		while (s.hasNextDouble()) {
			double v=s.nextDouble();
			numeritos.add(v);
		}
		if(s.hasNextLine()) {
			s.nextLine();
		}
		s.close();
		if (numeritos.isEmpty()) {
			System.out.println("No se ha leido ningún número");
			return;
		}
		double max=numeritos.getFirst();
		for(double numerito:numeritos) {
			if(numerito>max){
				max=numerito;
			}
		}
		System.out.println();
		System.out.println("Valores numéricos y máximo valor:");
		for(double numerito:numeritos) {
			System.out.print(numerito);
			if (numerito==max) {
				System.out.print(" <== máximo valor");
			}
			System.out.println();
		}
		

	}

}
