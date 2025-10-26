package pa;

public class NotasAsignatura {
    private String nombreAsignatura;
    private float[] notas;

    public NotasAsignatura(String nombre, float[] nota) {
        this.nombreAsignatura = nombre;
        this.notas = nota;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public float[] getNotas() {
        return notas;
    }

    public float calcularValorMinimo() {
        float min = notas[0];
        for (float nota : notas) {
            if (nota < min) min = nota;
        }
        return min;
    }

    public float calcularValorMaximo() {
        float max = notas[0];
        for (float nota : notas) {
            if (nota > max) max = nota;
        }
        return max;
    }

    public float calcularMedia() {
        float suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    private int[] calcularFrecuencias() {
        int[] frecuencias = new int[11];
        for (float nota : notas) {
            if (nota == 10.0f) {
                frecuencias[10]++;
            } else if (nota >= 0.0f && nota < 10.0f) {
                int entero = (int) nota; // parte entera
                frecuencias[entero]++;
            }
        }
        return frecuencias;
    }

    public void mostrarHistograma(int inicio, int fin) {
        System.out.println("---------------------");
        System.out.println("Histograma de notas de la asignatura: " + nombreAsignatura);
        System.out.println("Intervalo de notas: [" + inicio + "," + fin + "]");
        System.out.println();

        // Validación del rango
        if (inicio < 0 || fin > 10 || inicio > fin) {
            System.out.println("\tRango de valores inválido");
            System.out.println();
            return;
        }

        int[] f = calcularFrecuencias();

        // Calcular frecuencia máxima en el rango
        int max = 0;
        for (int i = inicio; i <= fin; i++) {
            if (f[i] > max) max = f[i];
        }
        System.out.printf("frecuencia máxima del intervalo= %d%n", max);
        System.out.println();
        // Dibujar de arriba (max) hacia abajo (1)
        for (int nivel = max; nivel >= 1; nivel--) {
            System.out.print("\t");
            for (int i = inicio; i <= fin; i++) {
                if (f[i] >= nivel) {
                    System.out.print("  *  ");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }

        // Línea separadora y etiquetas
        System.out.println("\t---------------------------------");
        System.out.print("\t");
        for (int i = inicio; i <= fin; i++) {
            System.out.printf("%3d ", i);
        }
        System.out.println();
        System.out.println();
    }

    public void mostrarNotas_en_columnas(int columnas) {
        System.out.println("Listado de notas de la asignatura: " + nombreAsignatura);
        System.out.println("\tnúmero de columnas = " + columnas);
        System.out.println();

        // Según el PDF: mensaje de error para 0 columnas y >6
        if (columnas < 1 || columnas > 6) {
            System.out.println("\tError: El número de columnas debe estar entre 0..6");
            System.out.println();
            return;
        }

        int contadorFila = 0;
        System.out.print("\t"); // cada fila empieza con tabulador

        for (int i = 0; i < notas.length; i++) {
            System.out.printf("%6.1f", notas[i]);
            contadorFila++;

            if (contadorFila == columnas) {
                System.out.println();    // fin de fila
                if (i < notas.length - 1) {
                    System.out.print("\t"); // siguiente fila empieza con tab
                }
                contadorFila = 0;
            }
        }
        if (contadorFila != 0) {
            System.out.println(); // cerrar última fila si quedó incompleta
        }
        System.out.println(); // línea en blanco final, como en el ejemplo
    }
}
