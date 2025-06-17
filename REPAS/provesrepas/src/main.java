



public class main {

    


    static void mostraDades(Alumne a){
        System.out.println(a.getNom());

        //if (a.getClass() == AlumnesEso.class){ // 'a' és alumneeso
        if (a instanceof AlumnesEso){ // si 'a' ve d'un new d'alumneeso o fill d'alumneeso
            AlumnesEso ae = (AlumnesEso)a;
            System.out.println( (ae.getTelfma()    );
        }
        else {
            System.out.println("no soc alu eso");
        }

    }
    public static void main(String[] args) {
        Alumne a1 = new Alumne();
        Alumne a2 = new Alumne("Isabel", 19);

        Alumne.notaMin = 4;

        Alumne.setNotaMin(4);
        System.out.println(Alumne.getNotaMin())


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
    
    } //Main
}
