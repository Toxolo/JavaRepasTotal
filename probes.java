
import java.util.Arrays;
import java.util.Scanner;

public class probes {
    public static void mostraMitja (int a, int b){
        int mitja = (a + b)/2;
        System.out.println(mitja);
    }

    public static float calculaMitja(int a, int b) {
        float mitja = (a + b)/2.0f;
        return mitja;
    }

    public static int primer(int[] llista) {
        return llista[0];
        
    }


    public static int ultim(int[] llista) {
        int posUlt = llista.length-1;
        int qElem = llista.length;
        return llista[llista.length-1];
        
    }

    public static int[] creaVectorEnters(int cuantitat, int valor) {
        int[] vector = new int[cuantitat];
        for (int i = 0; i < vector.length; i++) {
            vector[i]=valor;
        }
        return vector;
    }

    public static int[] sumaColumnes(int[][] m) {
        int[] vSuma = new int[m[0].length];
        int totalColumna=0;
        for (int col = 0; col < m[0].length; col++) {
            // CALCULAR LA SUMADELA COLUMNA

            // Inicacum
            totalColumna = 0;

            // Sumar la col
            for (int fil = 0; fil < m.length; fil++) {
                totalColumna +=  m[fil][col];
            }
        }
        // RETORNAR VECTOR
        return vSuma;
    }

    public static void mostra(int[][] m) {
        int COL = m[0].length; 
        int FIL = m.length;
        //numeros columnes
        for (int c = 0; c < COL; c++) {
            System.out.print(c + "\t");
        }
        System.out.println("");
        // matriu
        for (int fil = 0; fil < FIL; fil++) {
            
            System.out.print(fil + "\t");
            for (int col = 0; col < 10; col++) {
                System.out.print(m[fil][col] + "\t");
            }
            System.out.println(fil);
        }
        for (int c = 0; c < COL; c++) {
            System.out.print(c + "\t");
        }
        System.out.println("");
    }


    public static void posaFicha(char[][] tauler, int columna, char color) {
            boolean ficat = false;
            
            for (int fil = tauler.length-1 ; fil > -1 && !ficat; fil--){
                    if (tauler[fil][columna] == 'B'){
                        tauler[fil][columna] = color;
                        ficat = true;

                    }
            } 
            if (!ficat){
                System.out.println("La columna estaba plena");
            }   
    }
    public static void main(String[] args) {
        Scanner teclat = new Scanner (System.in);
        mostraMitja(4, 7);
        mostraMitja(5, 2);
        int edat = 10;
        int edad2 = 12;
        mostraMitja(edat, edad2);
        float resultat1 = calculaMitja(5, 2);
        System.out.println(calculaMitja(3,3));
       
        int notes[] = {17, 12, 20};


        int resultat2 = primer(notes);
        System.out.println("El primer alumne te " + resultat2);

        int[] vector1 = {3,3,4,56};
        int[]v2;

        v2 = vector1;
        
        vector1 = creaVectorEnters(10, -1);

        int[][] notes2 = new int[4][3];// 4 alu i 3 exer

        // demanem per teclat les notes per cada exercici

        for (int ex = 0; ex < notes2[0].length; ex++) {
            System.out.println("Notes del exercici " + ex);
            for (int al = 0; al < notes2.length; al++) {
                System.out.println("nOTA DE ALUMNE " + al);
                notes2[al][ex] = teclat.nextInt(); 
            }
        }

        int[] vSuma;
        vSuma = sumaColumnes(notes2);

        for (int i = 0; i < vSuma.length; i++) {
            System.out.println("Total " + vSuma[i]);
        }

        //System.out.println(vSuma); // mostra adr. mem.

        System.out.println( Arrays.toString(vSuma) );

        

    }
}
