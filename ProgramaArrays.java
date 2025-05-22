import java.util.Scanner;

/**
 * ProgramaArrays.java
 *
 * Programa que gestiona un array de enteros con operaciones:
 * - Crear array de tamaño definido por el usuario
 * - Rellenar valores (manual o por posición)
 * - Mostrar contenido
 * - Calcular suma y media
 * - Buscar un elemento
 * - Modificar un elemento
 * - Eliminar un elemento (desplazamiento)
 *
 * El programa organiza la lógica en métodos para mayor claridad
 * y permanece en bucle hasta que el usuario elige salir.
 */
public class ProgramaArrays {
    private static Scanner sc = new Scanner(System.in);
    private static int[] array;
    private static int length = 0;  // número lógico de elementos actuales

    public static void main(String[] args) {
        System.out.println("=== Gestión de Arrays ===");
        crearArray();
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(1, 7);
            switch (opcion) {
                case 1 -> mostrarArray();
                case 2 -> calcularSumaYMedia();
                case 3 -> buscarElemento();
                case 4 -> modificarElemento();
                case 5 -> eliminarElemento();
                case 6 -> rellenarArray();
                case 7 -> {
                    System.out.println("Fin del programa. ¡Hasta luego!");
                    sc.close();
                    return;
                }
            }
        }
    }

    /**
     * Crea el array pidiendo el tamaño al usuario.
     */
    private static void crearArray() {
        int size;
        do {
            size = leerEntero("Introduce tamaño del array (>=1): ");
            if (size < 1) System.out.println("El tamaño debe ser al menos 1.");
        } while (size < 1);
        array = new int[size];
        length = 0;
        System.out.println("Array creado con capacidad " + size + ".");
    }

    /**
     * Muestra las opciones del menú.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Mostrar array");
        System.out.println("2. Calcular suma y media");
        System.out.println("3. Buscar elemento");
        System.out.println("4. Modificar elemento");
        System.out.println("5. Eliminar elemento");
        System.out.println("6. Rellenar array");
        System.out.println("7. Salir");
        System.out.print("Elige opción (1-7): ");
    }

    /**
     * Lee y valida una opción numérica entre un rango.
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
     * Rellena el array: modo manual o rellenar posición específica.
     */
    private static void rellenarArray() {
        System.out.println("\nElige modo de rellenar:");
        System.out.println("1. Relleno manual hasta completar");
        System.out.println("2. Rellenar posición específica");
        System.out.print("Opción (1-2): ");
        int modo = leerOpcion(1, 2);

        if (modo == 1) {
            // Relleno manual
            while (length < array.length) {
                System.out.print("Valor #" + (length + 1) + ": ");
                String input = sc.nextLine().trim();
                if (input.equalsIgnoreCase("stop")) break;
                try {
                    int val = Integer.parseInt(input);
                    array[length++] = val;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Introduce un entero o 'stop'.");
                    // no incrementamos length, volvemos a pedir
                }
            }
            System.out.println("Datos almacenados: " + length + " de " + array.length + ".");
        } else {
            // Rellenar posición específica
            int pos;
            do {
                pos = leerEntero("Posición a rellenar (0-" + (array.length - 1) + "): ");
                if (pos < 0 || pos >= array.length)
                    System.out.println("Índice fuera de rango.");
            } while (pos < 0 || pos >= array.length);

            int val = leerEntero("Valor: ");
            array[pos] = val;
            if (pos >= length) length = pos + 1;
            System.out.println("Posición " + pos + " actualizada con valor " + val + ".");
        }
    }

    /**
     * Muestra el contenido actual del array.
     */
    private static void mostrarArray() {
        if (length == 0) {
            System.out.println("El array está vacío.");
            return;
        }
        System.out.print("Array: [");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i < length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    /**
     * Calcula y muestra la suma y la media de los elementos.
     */
    private static void calcularSumaYMedia() {
        if (length == 0) {
            System.out.println("No hay elementos para calcular.");
            return;
        }
        int suma = 0;
        for (int i = 0; i < length; i++) suma += array[i];
        double media = (double) suma / length;
        System.out.println("Suma: " + suma + ", Media: " + media);
    }

    /**
     * Busca un elemento en el array e informa su posición.
     */
    private static void buscarElemento() {
        if (length == 0) {
            System.out.println("Array vacío.");
            return;
        }
        int clave = leerEntero("Introduce valor a buscar: ");
        for (int i = 0; i < length; i++) {
            if (array[i] == clave) {
                System.out.println("Elemento encontrado en posición " + i + ".");
                return;
            }
        }
        System.out.println("Elemento no encontrado.");
    }

    /**
     * Modifica el valor de un elemento en una posición dada.
     */
    private static void modificarElemento() {
        if (length == 0) {
            System.out.println("Array vacío.");
            return;
        }
        int pos = leerEntero("Índice a modificar (0-" + (length - 1) + "): ");
        if (pos < 0 || pos >= length) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        int nuevo = leerEntero("Nuevo valor: ");
        array[pos] = nuevo;
        System.out.println("Elemento en posición " + pos + " modificado.");
    }

    /**
     * Elimina un elemento desplazando los siguientes a la izquierda.
     */
    private static void eliminarElemento() {
        if (length == 0) {
            System.out.println("Array vacío.");
            return;
        }
        int pos = leerEntero("Índice a eliminar (0-" + (length - 1) + "): ");
        if (pos < 0 || pos >= length) {
            System.out.println("Índice fuera de rango.");
            return;
        }
        for (int i = pos; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        length--;
        System.out.println("Elemento eliminado y array reordenado.");
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
