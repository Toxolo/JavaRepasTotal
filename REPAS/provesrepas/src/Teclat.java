
import java.util.Scanner; // Importar Scanner

public class Teclat {
    static Scanner sc = new Scanner(System.in); // Scanner únic

    static public String scString() { return sc.nextLine(); } // Llig línia. Ex: String nom = Teclat.scString();

    static public int scInt() { // Llig enter. Ex: int edat = Teclat.scInt();
        int resultat;
        resultat = sc.nextInt(); sc.nextLine(); // Neteja buffer
        return resultat;
    }

    static public char scChar() { return sc.nextLine().toUpperCase().charAt(0); } // Llig lletra. Ex: char op = Teclat.scChar();

    static public void nl() { sc.nextLine(); } // Neteja línia. Ex: Teclat.nl();
}
