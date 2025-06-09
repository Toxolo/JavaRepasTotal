import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ProgramaBasico.java
 *
 * Programa que gestiona múltiples usuarios con sus edades y salarios.
 * Se organiza en métodos para modularidad y claridad.
 */
public class ProgramaMigDiccionari {
    static class Usuario {
        int edad;
        double salario;
        /**
         * Constructor de Usuario.
         * @param edad Edad del usuario
         * @param salario Salario mensual del usuario
         */
        Usuario(int edad, double salario) {
            this.edad = edad;
            this.salario = salario;
        }
    }

    private static Scanner sc = new Scanner(System.in);
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static final int EDAD_MINIMA = 16;
    private static final double SALARIO_MINIMO = 1040.0;

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(1, 5);
            switch (opcion) {
                case 1 -> anadirUsuario();
                case 2 -> mostrarUsuarios();
                case 3 -> modificarSalario();
                case 4 -> eliminarUsuario();
                case 5 -> {
                    System.out.println("Fin del programa. ¡Hasta luego!");
                    sc.close();
                    return;
                }
            }
        }
    }

    /**
     * Muestra las opciones del menú principal.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Usuarios ---");
        System.out.println("1. Añadir usuario");
        System.out.println("2. Mostrar todos los usuarios");
        System.out.println("3. Modificar salario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
        System.out.print("Elige opción (1-5): ");
    }

    /**
     * Lee una opción numérica entre un rango válido.
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Opción ingresada por el usuario
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
     * Solicita datos y añade un nuevo usuario al diccionario.
     * Valida edad mínima y salario mínimo.
     */
    private static void anadirUsuario() {
        System.out.print("Nombre de usuario: ");
        String nombre = sc.nextLine().trim();
        if (usuarios.containsKey(nombre)) {
            System.out.println("El usuario ya existe.");
            return;
        }
        int edad;
        do {
            edad = leerEntero("Edad (>= " + EDAD_MINIMA + "): ");
            if (edad < EDAD_MINIMA) System.out.println("Edad mínima " + EDAD_MINIMA + " años.");
        } while (edad < EDAD_MINIMA);

        double salario;
        do {
            salario = leerDouble("Salario mensual (>= " + SALARIO_MINIMO + ") (coma o punto): ");
            if (salario < SALARIO_MINIMO) System.out.println("Salario mínimo " + SALARIO_MINIMO + " €.");
        } while (salario < SALARIO_MINIMO);

        usuarios.put(nombre, new Usuario(edad, salario));
        System.out.println("Usuario añadido: " + nombre);
    }

    /**
     * Muestra todos los usuarios con sus datos.
     */
    private static void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios.");
            return;
        }
        System.out.println("Usuarios registrados:");
        for (Map.Entry<String, Usuario> e : usuarios.entrySet()) {
            Usuario u = e.getValue();
            System.out.printf("%s → Edad: %d, Salario: %.2f €%n", e.getKey(), u.edad, u.salario);
        }
    }

    /**
     * Modifica el salario de un usuario existente.
     * Valida salario mínimo.
     */
    private static void modificarSalario() {
        System.out.print("Nombre del usuario a modificar: ");
        String nombre = sc.nextLine().trim();
        Usuario u = usuarios.get(nombre);
        if (u == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        double salario;
        do {
            salario = leerDouble("Nuevo salario mensual (>= " + SALARIO_MINIMO + "): ");
            if (salario < SALARIO_MINIMO) System.out.println("Salario mínimo " + SALARIO_MINIMO + " €.");
        } while (salario < SALARIO_MINIMO);
        u.salario = salario;
        System.out.println("Salario actualizado.");
    }

    /**
     * Elimina un usuario del diccionario según su nombre.
     */
    private static void eliminarUsuario() {
        System.out.print("Nombre del usuario a eliminar: ");
        String nombre = sc.nextLine().trim();
        if (usuarios.remove(nombre) != null) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    /**
     * Lee y valida un número entero desde la entrada.
     * @param prompt Mensaje a mostrar para la lectura
     * @return Número entero ingresado
     */
    private static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número entero.");
            }
        }
    }

    /**
     * Lee y valida un número decimal desde la entrada.
     * @param prompt Mensaje a mostrar para la lectura
     * @return Número decimal ingresado
     */
    private static double leerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número.");
            }
        }
    }
}
