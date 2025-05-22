package ProbesDeObjectes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ProgramaBanca.java
 *
 * Programa principal de gestión de cuentas y transferencias.
 */
public class ProgramaBanca {
    private static Scanner sc = new Scanner(System.in);
    private static List<Cuenta> cuentas = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opt = leerOpcion(1, 4);
            switch (opt) {
                case 1 -> crearCuenta();
                case 2 -> listarCuentas();
                case 3 -> realizarTransferencia();
                case 4 -> {
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                }
            }
        }
    }

    /** Muestra el menú principal. */
    private static void mostrarMenu() {
        System.out.println("\n--- Menú Banca ---");
        System.out.println("1. Crear nueva cuenta");
        System.out.println("2. Listar cuentas");
        System.out.println("3. Transferir fondos");
        System.out.println("4. Salir");
        System.out.print("Opción (1-4): ");
    }

    /**
     * Lee y valida una opción entera.
     */
    private static int leerOpcion(int min, int max) {
        while (true) {
            try {
                int res = Integer.parseInt(sc.nextLine());
                if (res >= min && res <= max) return res;
            } catch (NumberFormatException e) {}
            System.out.print("Elige entre " + min + " y " + max + ": ");
        }
    }

    /**
     * Crea una nueva cuenta (normal o menor de edad).
     */
    private static void crearCuenta() {
        System.out.print("Nombre del titular: ");
        String nombre = sc.nextLine().trim();
        int edad = leerEntero("Edad del titular: ");
        System.out.print("Número de cuenta: ");
        String num = sc.nextLine().trim();
        double saldo = leerDouble("Saldo inicial: ");

        Cuenta c;
        if (edad < 18) c = new CuentaMenorEdad(nombre, edad, num, saldo);
        else c = new Cuenta(nombre, edad, num, saldo);

        cuentas.add(c);
        System.out.println("Cuenta creada: " + c);
    }

    /** Muestra todas las cuentas registradas. */
    private static void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas.");
            return;
        }
        cuentas.forEach(System.out::println);
    }

    /**
     * Realiza una transferencia entre dos cuentas.
     */
    private static void realizarTransferencia() {
        if (cuentas.size() < 2) {
            System.out.println("Se necesitan al menos 2 cuentas.");
            return;
        }
        System.out.print("Cuenta origen (número): ");
        String origen = sc.nextLine().trim();
        System.out.print("Cuenta destino (número): ");
        String destino = sc.nextLine().trim();
        Cuenta c1 = buscarCuenta(origen);
        Cuenta c2 = buscarCuenta(destino);
        if (c1 == null || c2 == null) {
            System.out.println("Una o ambas cuentas no existen.");
            return;
        }
        double amt = leerDouble("Cantidad a transferir: ");
        c1.transferir(c2, amt);
    }

    /** Busca una cuenta por número. */
    private static Cuenta buscarCuenta(String num) {
        for (Cuenta c : cuentas) if (c.getNumero().equals(num)) return c;
        return null;
    }

    /** Lee y valida un entero. */
    private static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un entero.");
            }
        }
    }

    /** Lee y valida un double. */
    private static double leerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número válido.");
            }
        }
    }
}
