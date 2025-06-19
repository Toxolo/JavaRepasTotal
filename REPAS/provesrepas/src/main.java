
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;





public class main {

    

    static  boolean esSimetric(ArrayList<Integer> numeros){
        boolean es;
        System.out.println(numeros);
        if (numeros.size()<= 1){
            es = true;
        }
        else {
            if (numeros.get(0) != numeros.get(numeros.size()-1)){
                es = false;
            }
            else {
                numeros.remove(0);
                numeros.remove(numeros.size()-1);
                
            es = esSimetric(numeros);
                
            }
        }

        System.out.println("   resultat: "+ es);
        return es;
    }

    static void mostraDades(Alumne a){
        System.out.println(a.getNom());

        //if (a.getClass() == AlumnesEso.class){ // 'a' és alumneeso
        if (a instanceof AlumnesEso){ // si 'a' ve d'un new d'alumneeso o fill d'alumneeso
            AlumnesEso ae = (AlumnesEso)a;
            System.out.println( ae.getTelfma()    );
        }
        else {
            System.out.println("no soc alu eso");
        }

    }


    static  int llegir(){
        Scanner teclat = new Scanner(System.in);
        System.out.println("Dis-me un número positiu: ");
        int num = teclat.nextInt();
        if (num<0){
            System.out.println("inc. ha de ser positiu");
            num = llegir();
        }
        System.out.println("ok");


        return num;
    }

    static void proves(){


        int n = llegir();

        ArrayList <Integer> ll = new ArrayList<>();
        ll.add(7);
        ll.add(3);
        ll.add(9);
        ll.add(5);
        ll.add(2);
        ll.add(55);
        ll.add(9);
        ll.add(3);
        ll.add(7);

        if (esSimetric(ll)){
            System.out.println("SI");
        } else {
            System.out.println("No es");
        }




        Alumne a1 = new Alumne();
        Alumne a2 = new Alumne("Isabel", 19);

        // Alumne.notaMin = 4;

        Alumne.setNotaMin(4);
        System.out.println(Alumne.getNotaMin());


        // a1.setNom("Josep");main.mostraDades(a1);
        a1.setEdat(18);
        System.out.println(a1);
        a1.setNom("Josep");
        
        // System.out.println(a2.edat);

        System.out.println(a1.toString());
        a1.setNom("Josep");
        
        // re
        Alumne.mostraDades(a1);
        a1.mostraDades( );

       
        Alumne a4;
        
        a4 = a1.clon();

        Alumne a5 = new Alumne();
        

        a5.setCopiaDe(a1);

        Domicili d1 = new  Domicili("PAU PICASSO", 2344, "Bellreguard");
       // Alumne a6 = new Alumne("David", 21, d1);

        Alumne a7 = new Alumne("afdsa", 33, "carrer", 3333, "Sueca");

        System.out.println("ALU ESO------------------");

        AlumnesEso a8 = new AlumnesEso(23423542, 47656346, "Jose", 12);
        a8.mostraDades();

        System.out.println("--------------- md");
        mostraDades(a8);
       
        mostraDades(a7);
        
        ArrayList<Alumne> alumnes = new ArrayList<>();
        alumnes.add(a7);
        alumnes.add(a5);
        alumnes.add(a4);
        alumnes.add(a2);
        alumnes.add(a1);
        System.out.println("No ordenada");
        for (Alumne alumne : alumnes) {
        System.out.println(alumne);
        }

        Collections.sort(alumnes);

        System.out.println("Ordenada");
        for (Alumne alumne : alumnes) {
            System.out.println(alumne);
            }

        // if (a7.compareTo(a8) < 0){
        //     System.out.println(a7 + "Es menor");
        // } else if(a7.compareTo(a8) > 0) {
        //     System.out.println(a7 + "Es major");
        // } else {
        //     System.out.println("Son iguals en orden");
        // }

            ComAluEdad cae = new ComAluEdad();
            ComAluNom can = new ComAluNom();

            System.out.println(cae.compare(a7, a8));
            System.out.println(can.compare(a7, a8));

            // alumnes.sort(cae);

            Collections.sort(alumnes, cae);
            System.out.println("LLista ordenada Edad");
        System.out.println("Ordenada");
        for (Alumne alumne : alumnes) {
            System.out.println(alumne);
            }

    }


    public static void main(String[] args) {
        //proves();
        Alumne a1 = new Alumne("pep", 3);
        // Alumne a2;

        Alumne a2 = Alumne.copiarAlu(a1); 
         //a2 = a1.copiaAlu();
         a2 = new Alumne( a1  );


    } //Main
}
