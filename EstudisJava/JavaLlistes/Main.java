
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        ArrayList<Menor> listaMenores = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear una persona o menor");
            System.out.println("2. Mostrar listas de personas y menores");
            System.out.println("3. Eliminar una persona de la lista de personas");
            System.out.println("4. Editar la edad de un menor");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("¿Deseas crear una Persona o un Menor? (p/m): ");
                    String tipo = scanner.nextLine().toLowerCase();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        if (tipo.equals("p")) {
                            Persona p = new Persona(nombre, edad);
                            listaPersonas.add(p);
                            System.out.println("✔ Persona añadida a la lista de personas.");
                        } else if (tipo.equals("m")) {
                            Menor m = new Menor(nombre, edad);
                            listaMenores.add(m);
                            System.out.println("✔ Menor añadido a la lista de menores.");
                        } else {
                            System.out.println("❌ Opción inválida. Usa 'p' o 'm'.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n📋 Lista de Personas:");
                    if (listaPersonas.isEmpty()) {
                        System.out.println("  (ninguna)");
                    } else {
                        for (int i = 0; i < listaPersonas.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            listaPersonas.get(i).mostrarInfo();
                        }
                    }

                    System.out.println("\n📋 Lista de Menores:");
                    if (listaMenores.isEmpty()) {
                        System.out.println("  (ninguno)");
                    } else {
                        for (int i = 0; i < listaMenores.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            listaMenores.get(i).mostrarInfo();
                        }
                    }
                    break;

                case 3:
                    if (listaPersonas.isEmpty()) {
                        System.out.println("La lista de personas está vacía.");
                    } else {
                        System.out.println("\n📋 Personas disponibles:");
                        for (int i = 0; i < listaPersonas.size(); i++) {
                            System.out.println((i + 1) + ". " + listaPersonas.get(i).nombre);
                        }
                        System.out.print("Selecciona el número a eliminar: ");
                        int eliminar = scanner.nextInt();
                        scanner.nextLine();
                        if (eliminar >= 1 && eliminar <= listaPersonas.size()) {
                            Persona eliminada = listaPersonas.remove(eliminar - 1);
                            System.out.println("✔ Persona eliminada: " + eliminada.nombre);
                        } else {
                            System.out.println("❌ Índice inválido.");
                        }
                    }
                    break;

                case 4:
                    if (listaMenores.isEmpty()) {
                        System.out.println("No hay menores en la lista.");
                        break;
                    }

                    System.out.println("\n📋 Menores disponibles:");
                    for (int i = 0; i < listaMenores.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        listaMenores.get(i).mostrarInfo();
                    }

                    System.out.print("Selecciona el número del menor a editar: ");
                    int seleccion = scanner.nextInt();
                    scanner.nextLine();

                    if (seleccion >= 1 && seleccion <= listaMenores.size()) {
                        Menor menorSeleccionado = listaMenores.get(seleccion - 1);
                        System.out.print("Nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        scanner.nextLine();
                        String nombreActual = menorSeleccionado.nombre;

                        if (nuevaEdad >= 18) {
                            try {
                                Persona nuevaPersona = new Persona(nombreActual, nuevaEdad);
                                listaPersonas.add(nuevaPersona);
                                listaMenores.remove(seleccion - 1);
                                System.out.println("🔄 El menor ha sido convertido en persona y movido.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("❌ Error al convertir: " + e.getMessage());
                            }
                        } else {
                            try {
                                listaMenores.set(seleccion - 1, new Menor(nombreActual, nuevaEdad));
                                System.out.println("✔ Edad del menor actualizada.");
                            } catch (IllegalArgumentException e) {
                                System.out.println("❌ Error al actualizar: " + e.getMessage());
                            }
                        }
                    } else {
                        System.out.println("❌ Selección inválida.");
                    }
                    break;

                case 5:
                    continuar = false;
                    System.out.println("👋 Programa finalizado.");
                    break;

                default:
                    System.out.println("❌ Opción no válida.");
            }
        }

        scanner.close();
    }
}
