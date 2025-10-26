package pa;

public class Demo {

	public static void main(String[] args) {
		// Datos de entrada
        float[] listaNotas = {
            7.0f, 0.2f, 3.2f, 5.8f, 6.4f, 1.4f,
            4.7f, 5.5f, 1.6f, 5f, 3f, 1f, 8.2f, 1.8f
        };

        // Crear objeto de la clase NotasAsignatura
        NotasAsignatura matematicas = new NotasAsignatura("Matemáticas", listaNotas);

        // Mostrar listado con 0 columnas (error)
        matematicas.mostrarNotas_en_columnas(0);

        // Mostrar listado con 3 columnas
        matematicas.mostrarNotas_en_columnas(6);

        // Calcular y mostrar estadísticas básicas
        System.out.printf("Nota mínima: %.2f%n", matematicas.calcularValorMinimo());
        System.out.printf("Nota máxima: %.2f%n", matematicas.calcularValorMaximo());
        System.out.printf("Nota media: %.2f%n%n", matematicas.calcularMedia());

        // Mostrar histogramas
        matematicas.mostrarHistograma(0, 11);  // rango inválido
        matematicas.mostrarHistograma(3, 8);   // rango válido
        matematicas.mostrarHistograma(0, 5);   // rango válido
        matematicas.mostrarHistograma(3, 1);   // rango inválido
    }
}

