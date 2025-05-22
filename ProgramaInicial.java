import java.util.Scanner;

/**
 * ProgramaBasico.java
 * 
 * Ejemplo básico que:
 * - Lee varias variables usando Scanner
 * - Acepta decimales con coma o punto en salario
 * - Usa un if para comprobar la edad
 * - Utiliza switch para distintas opciones
 * - Controla errores de entrada con validación en bucles
 * - Permanece en bucle hasta que el usuario elige salir
 */
public class ProgramaInicial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad = 0;
        double salario = 0;

        // Validar lectura de edad
        while (true) {
            System.out.print("Introduce tu edad: ");
            try {
                edad = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Edad no válida. Por favor, introduce un número entero.");
            }
        }

        // Validar lectura de salario (acepta coma o punto)
        while (true) {
            System.out.print("Introduce tu salario mensual (usa coma o punto): ");
            String salInput = sc.nextLine().replace(',', '.');
            try {
                salario = Double.parseDouble(salInput);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Salario no válido. Por favor, introduce un número.");
            }
        }

        // Comprobación de edad
        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }

        // Bucle principal del menú
        while (true) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Mostrar edad y salario");
            System.out.println("2. Calcular salario anual");
            System.out.println("3. Salir");
            System.out.print("Opción (1-3): ");

            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduce un número entre 1 y 3.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Edad: " + edad + " años");
                    System.out.println("Salario mensual: " + salario + " €");
                    break;
                case 2:
                    double anual = salario * 12;
                    System.out.println("Salario anual estimado: " + anual + " €");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige 1, 2 o 3.");
            }
        }
    }
}
