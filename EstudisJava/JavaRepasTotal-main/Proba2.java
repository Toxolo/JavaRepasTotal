import java.util.ArrayList;
import java.util.Scanner;

public class Proba2 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Treballador> llista = new ArrayList<>();

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear Treballador");
            System.out.println("2. Crear Conter");
            System.out.println("3. Mostrar tots");
            System.out.println("4. Eixir");
            System.out.print("Opció: ");
            int opcio = sc.nextInt();
            sc.nextLine(); // Neteja buffer

            switch (opcio) {
                case 1:
                    crearTreballador();
                    break;
                case 2:
                    crearConter();
                    break;
                case 3:
                    mostrarTots();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Programa finalitzat.");
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenta-ho de nou.");
            }
        }

        sc.close();
    }

    public static void crearTreballador() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Edat: ");
        int edat = sc.nextInt();
        sc.nextLine(); // neteja

        Treballador t = new Treballador(nom, cognoms, edat);
        llista.add(t);
        System.out.println("Treballador creat.");
    }

    public static void crearConter() {
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();
        System.out.print("Edat: ");
        int edat = sc.nextInt();
        System.out.print("Salari: ");
        int salari = sc.nextInt();
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // neteja

        Conter c = new Conter(nom, cognoms, edat, salari, id);
        llista.add(c);
        System.out.println("Conter creat.");
    }

    public static void mostrarTots() {
        if (llista.isEmpty()) {
            System.out.println("No hi ha treballadors registrats.");
        } else {
            System.out.println("\n--- LLISTA DE TREBALLADORS ---");
            for (Treballador t : llista) {
                if (t instanceof Conter) {
                    ((Conter) t).VorerConter(); // mostra info completa de Conter
                } else {
                    t.salutar(); // mostra info bàsica de Treballador
                }
            }
        }
    }
}
