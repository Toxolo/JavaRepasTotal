
import java.util.ArrayList;
import java.util.Collections;

public class ExamenJosepSegrellesExtraordinaria {

        //activitat 3
    public static ArrayList<Integer>  negPos(ArrayList<Integer> llista) {
        int negatius = 0;
        int positiu = 0;
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i) < 0){
                negatius +=1;
            } else {
                positiu +=1;
            }
        }
        ArrayList <Integer> ll = new ArrayList<>();
        ll.add(negatius);
        ll.add(positiu);
        return ll;
    }


        //activitat4

    
    public static boolean  sopaDeLletres(char[][] m, String p, int fil, int col ) {
        
        int plon = p.length();
        if (fil > (m.length -1)) return false;
        if (m[0].length - (col) < plon  ){
            return false;
        }
        int imprimir = 0;
            for (int i = col; i < (col + p.length()); i++) {

                m[fil][i] = p.charAt(imprimir);
                imprimir+=1;
            }
            
        
        return true;
    }

    //Activitat 5 mostrar llista
    public static void mostraLlista(ArrayList<Articles> ll) {
        int preparat = 0;
        for (Articles article: ll) {
            System.out.println(article);
            if (article.getClass() == Preparat.class){
            preparat +=1;
            }
            }
            System.out.println(preparat + " són plats preparats");
        System.out.println("El persentage d'Iva es de " + Articles.getIva() + "%");
    }

    //buscar per codis
    public static void Buscar(ArrayList<Articles> ll, int codic) {

        Articles codiBuscar = new Articles(codic, "-1", -1);
        int codiTrobat = ll.indexOf(codiBuscar);
        if (codiTrobat == -1) {
            System.out.println("No existeis ningun amb el codi " + codic);
        } else {
            System.out.println(ll.get(codiTrobat));
        }
    }

    public static void main(String[] args) {
        //activitat 3
        ArrayList <Integer> llistaAc3 = new ArrayList<>();
        ArrayList <Integer> llistaAc3Resultat = new ArrayList<>();
        llistaAc3.add(3);
        llistaAc3.add(-2);
        llistaAc3.add(7);
        llistaAc3Resultat = negPos(llistaAc3);
        System.out.println("Hi han " + llistaAc3Resultat.get(0) + " nombres negatius i " + llistaAc3Resultat.get(1) + " nombres positius");

        //activitat 4 acabar
        String paraula = "hola";
        
        char[][] sopalletres = new char[5][7];
        
        for (int fil = 0; fil < sopalletres.length; fil++) {
            for (int col = 0; col < sopalletres[0].length; col++) {
                sopalletres[fil][col] = '_';
            }
        }

        if (sopaDeLletres(sopalletres, paraula, 4, 0) == false){
            System.out.println("No cap la paraula");
        }

        for (int fil = 0; fil < sopalletres.length; fil++) {
            System.out.println("");
            for (int col = 0; col < sopalletres[0].length; col++) {
                System.out.print(" " + sopalletres[fil][col]);
            }
        }
        System.out.println("");

        //activitat 5

        //objectes

        Articles a1 = new Articles(123, "bocata", 9);
        Articles a2 = new Articles(2,  "burguer", 12);
        Articles a3 = new Articles(3,  "aburguer", 12);

        Preparat p1 = new Preparat(01, "macarrons", 8, 10);
        Preparat p2 = new Preparat(13, "costelles", 20, 21);

        //Llista

        ArrayList<Articles> carta = new ArrayList<>();

        carta.add(a3);
        carta.add(a2);
        carta.add(p2);
        carta.add(a1);
        carta.add(p1);
        
        
        // Buscar codi 123
        Buscar(carta, 123);

        //mostraLlista
        System.out.println("Mostrar llista : ");
        System.out.println("");
        mostraLlista(carta);

        //ordenada
        System.out.println("Ordenada: ");
        System.out.println("");
        Collections.sort(carta);
        mostraLlista(carta);

    } //main
}