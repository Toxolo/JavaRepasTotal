Creacio de objecte basic


public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

Creacio de objecte amb restriccions

public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    private void validarEdat(int edat) {
        if (edat >= 18) {
            throw new IllegalArgumentException("Un menor ha de tindre menys de 18 anys.");
        }
    }

}

Creació objecte fill

public class Menor extends Cliente {
    private String tutor;

    public Cliente(String nombre, int edad, string tutor) {
        super(nombre, edad)
        this.tutor = tutor;
    }
}

Crear llista de objectes


public class ExempleLlista {

    public static void main(String[] args) {

        ArrayList<Menor> menors = new ArrayList<>();

        // Afegim alguns menors
        Menor m1 = new Menor("Anna", 12, "Laura");
        Menor m2 = new Menor("Marc", 15, "Pere");
        Menor m3 = new Menor("Joan", 10, "Maria");

        menors.add(m1);
        menors.add(m2);
        menors.add(m3);

        // Mostrar tots
        System.out.println("Llista completa:");
        for (Menor m : menors) {
            System.out.println(m);
        }

        // 🧹 1. Eliminar per índex (ex: el primer)
        menors.remove(0);

        // 🧹 2. Eliminar per referència (ex: eliminar "Marc")
        menors.remove(m2);

        // 🧹 3. Eliminar per condició (ex: eliminar per nom)
        menors.removeIf(m -> m.getNom().equals("Joan"));

        // Mostrar resultat final
        System.out.println("\nDesprés d'eliminar:");

        for (Menor m : menors) {
            System.out.println(m);

        }
    }
}

Modificar objecte especific

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Crear alguns clients per exemple
        clients.add(new Cliente("Anna", 25));
        clients.add(new Cliente("Joan", 30));
        clients.add(new Cliente("Maria", 40));

        // Preguntar pel nom del client a modificar
        System.out.print("Escriu el nom del client que vols modificar: ");
        String nomBuscat = sc.nextLine();

        boolean trobat = false;
        for (Cliente c : clients) {
            if (c.getNombre().equalsIgnoreCase(nomBuscat)) {
                trobat = true;

                // Si el trobem, demanem noves dades
                System.out.print("Nou nom: ");
                String nouNom = sc.nextLine();
                System.out.print("Nova edat: ");
                int novaEdat = sc.nextInt();
                sc.nextLine(); // neteja el buffer

                // Modifiquem l'objecte
                c.setNombre(nouNom);
                c.setEdad(novaEdat);

                System.out.println("Client modificat correctament.");
                break;
            }
        }

        if (!trobat) {
            System.out.println("No s'ha trobat cap client amb eixe nom.");
        }

        // Mostrar tots els clients després de modificar
        System.out.println("\nLlista de clients:");
        for (Cliente c : clients) {
            System.out.println(c);
        }
    }
}



