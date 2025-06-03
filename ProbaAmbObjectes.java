import java.util.Scanner;

public class ProbaAmbObjectes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vols crear un Treballador o un Conter?");
        System.out.print("Escriu 'T' per Treballador o 'C' per Conter: ");
        String tipus = sc.nextLine().trim().toUpperCase();

        System.out.print("Nom: ");
        String nom = sc.nextLine();

        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();

        System.out.print("Edat: ");
        int edat = sc.nextInt();
        sc.nextLine(); // netejar buffer

        if (tipus.equals("T")) {
            Treballador treballador = new Treballador(nom, cognoms, edat);
            treballador.salutar();
        } else if (tipus.equals("C")) {
            System.out.print("Saldo: ");
            double saldo = sc.nextDouble();

            Conter conter = new Conter(nom, cognoms, edat, saldo, Id);
            conter.VorerConter();
        } else {
            System.out.println("Opció no vàlida.");
        }

        sc.close();
    }
}
