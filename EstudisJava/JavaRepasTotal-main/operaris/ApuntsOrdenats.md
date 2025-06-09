# 📘 Apunts Java: Objectes, Llistes i Modificacions

---

## ✅ 1. Creació d’un objecte bàsic

```java
public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}


🔒 2. Creació d’un objecte amb restricció d’edat


public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        validarEdat(edad);
        this.nombre = nombre;
        this.edad = edad;
    }

    private void validarEdat(int edat) {
        if (edat >= 18) {
            throw new IllegalArgumentException("Un menor ha de tindre menys de 18 anys.");
        }
    }
}

🧬 3. Creació d’un objecte fill (Herència)

public class Menor extends Cliente {
    private String tutor;

    public Menor(String nombre, int edad, String tutor) {
        super(nombre, edad);
        this.tutor = tutor;
    }
}

📋 4. Crear una llista d’objectes i mostrar-los


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
✏️ 5. Modificar un objecte específic dins d’una llista
java
Copiar
Editar
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cliente> clients = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Afegim alguns clients
        clients.add(new Cliente("Anna", 25));
        clients.add(new Cliente("Joan", 30));
        clients.add(new Cliente("Maria", 40));

        // Buscar client per nom
        System.out.print("Escriu el nom del client que vols modificar: ");
        String nomBuscat = sc.nextLine();

        boolean trobat = false;
        for (Cliente c : clients) {
            if (c.getNombre().equalsIgnoreCase(nomBuscat)) {
                trobat = true;

                // Demanar noves dades
                System.out.print("Nou nom: ");
                String nouNom = sc.nextLine();
                System.out.print("Nova edat: ");
                int novaEdat = sc.nextInt();
                sc.nextLine(); // neteja buffer

                // Modificar l'objecte
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

✅ Exemple fora d’una subclasse (en qualsevol constructor):
java
Copiar
Editar
public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = (edad > 18) ? 18 : edad;  // Limitem a màxim 18 anys
    }
}
🔹 En este cas, si algú intenta crear un Cliente amb 30 anys, automàticament li assignarà 18.

🔄 També pots fer mínims:
java
Copiar
Editar
this.edad = (edad < 0) ? 0 : edad;  // No permet edats negatives
🎯 És una tècnica molt útil quan:
No vols llençar excepcions.

Vols ajustar automàticament valors dins d’un límit.

Et val que el programa continue amb un valor corregit.

🔥 Bonus: combinació de límits mínim i màxim
java
Copiar
Editar
this.edad = Math.max(0, Math.min(edad, 18)); // entre 0 i 18
Açò vol dir:

Si edad < 0 → agafa 0

Si edad > 18 → agafa 18

Si està entre 0 i 18 → es queda igual