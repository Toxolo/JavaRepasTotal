import java.util.Scanner;

/**
 * ProgramaMatriz.java
 *
 * Programa que gestiona una matriz de enteros con operaciones:
 * - Crear matriz de tamaños definidos por el usuario (filas x columnas)
 * - Rellenar valores (manual o por posición)
 * - Mostrar la matriz completa
 * - Calcular suma y media de todos los elementos
 * - Buscar un elemento
 * - Modificar un elemento
 * - Eliminar una fila o columna
 *
 * Estructura modular con métodos y menú en bucle hasta salir.
 */
public class ProgramaMatriz {
    private static Scanner sc = new Scanner(System.in);
    private static int[][] matriz;
    private static int filas, cols;

    public static void main(String[] args) {
        System.out.println("=== Gestión de Matrices ===");
        crearMatriz();
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(1, 8);
            switch (opcion) {
                case 1 -> mostrarMatriz();
                case 2 -> rellenarMatriz();
                case 3 -> calcularSumaYMedia();
                case 4 -> buscarElemento();
                case 5 -> modificarElemento();
                case 6 -> eliminarFila();
                case 7 -> eliminarColumna();
                case 8 -> {
                    System.out.println("Fin del programa. ¡Hasta luego!");
                    sc.close();
                    return;
                }
            }
        }
    }

    /**
     * Crea la matriz pidiendo filas y columnas.
     */
    private static void crearMatriz() {
        do {
            filas = leerEntero("Número de filas (>=1): ");
            if (filas < 1) System.out.println("Debe haber al menos 1 fila.");
        } while (filas < 1);
        do {
            cols = leerEntero("Número de columnas (>=1): ");
            if (cols < 1) System.out.println("Debe haber al menos 1 columna.");
        } while (cols < 1);
        matriz = new int[filas][cols];
        System.out.println("Matriz creada de " + filas + "x" + cols + ".");
    }

    /**
     * Muestra las opciones del menú.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Menú Matriz ---");
        System.out.println("1. Mostrar matriz");
        System.out.println("2. Rellenar matriz");
        System.out.println("3. Calcular suma y media");
        System.out.println("4. Buscar elemento");
        System.out.println("5. Modificar elemento");
        System.out.println("6. Eliminar fila");
        System.out.println("7. Eliminar columna");
        System.out.println("8. Salir");
        System.out.print("Elige opción (1-8): ");
    }

    /**
     * Lee una opción numérica entre un rango válido.
     */
    private static int leerOpcion(int min, int max) {
        while (true) {
            try {
                int opt = Integer.parseInt(sc.nextLine());
                if (opt >= min && opt <= max) return opt;
            } catch (NumberFormatException ignored) {}
            System.out.print("Opción no válida. Elige entre " + min + " y " + max + ": ");
        }
    }

    /**
     * Muestra toda la matriz formateada.
     */
    private static void mostrarMatriz() {
        System.out.println("Matriz " + filas + "x" + cols + ":");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%5d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Rellena la matriz solicitando valores fila a fila o por posición.
     */
    private static void rellenarMatriz() {
        System.out.println("\n1. Relleno completo fila a fila");
        System.out.println("2. Rellenar posición específica");
        System.out.print("Opción (1-2): ");
        int modo = leerOpcion(1, 2);
        if (modo == 1) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < cols; j++) {
                    matriz[i][j] = leerEntero("Valor [" + i + "," + j + "]: ");
                }
            }
        } else {
            int i, j;
            do {
                i = leerEntero("Fila (0-" + (filas-1) + "): ");
            } while (i < 0 || i >= filas);
            do {
                j = leerEntero("Columna (0-" + (cols-1) + "): ");
            } while (j < 0 || j >= cols);
            matriz[i][j] = leerEntero("Valor: ");
        }
        System.out.println("Matriz actualizada.");
    }

    /**
     * Calcula y muestra la suma y la media de todos los elementos.
     */
    private static void calcularSumaYMedia() {
        int suma = 0;
        for (int[] fila : matriz) for (int v : fila) suma += v;
        double media = (double) suma / (filas*cols);
        System.out.println("Suma total: " + suma + ", Media: " + media);
    }

    /**
     * Busca un elemento e informa su(s) posición(es).
     */
    private static void buscarElemento() {
        int clave = leerEntero("Valor a buscar: ");
        boolean found = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (matriz[i][j] == clave) {
                    System.out.println("Encontrado en [" + i + "," + j + "]");
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No encontrado.");
    }

    /**
     * Modifica un elemento en posición dada.
     */
    private static void modificarElemento() {
        int i, j;
        do { i = leerEntero("Fila (0-" + (filas-1) + "): "); } while (i<0||i>=filas);
        do { j = leerEntero("Columna (0-" + (cols-1) + "): "); } while (j<0||j>=cols);
        matriz[i][j] = leerEntero("Nuevo valor: ");
        System.out.println("Elemento ["+i+","+j+"] modificado.");
    }

    /**
     * Elimina una fila desplazando las siguientes hacia arriba.
     */
    private static void eliminarFila() {
        int row;
        do { row = leerEntero("Fila a eliminar (0-" + (filas-1) + "): "); } while (row<0||row>=filas);
        for (int i = row; i < filas-1; i++) {
            matriz[i] = matriz[i+1];
        }
        // última fila vacía
        matriz[filas-1] = new int[cols];
        System.out.println("Fila " + row + " eliminada.");
    }

    /**
     * Elimina una columna desplazando las siguientes hacia la izquierda.
     */
    private static void eliminarColumna() {
        int col;
        do { col = leerEntero("Columna a eliminar (0-" + (cols-1) + "): "); } while (col<0||col>=cols);
        for (int i = 0; i < filas; i++) {
            for (int j = col; j < cols-1; j++) {
                matriz[i][j] = matriz[i][j+1];
            }
            matriz[i][cols-1] = 0;
        }
        System.out.println("Columna " + col + " eliminada.");
    }

    /**
     * Lee y valida un número entero desde la entrada.
     */
    private static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un entero.");
            }
        }
    }
}
