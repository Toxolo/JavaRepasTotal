
import java.util.Objects;


public  class Alumne  implements Comparable<Alumne> {

    
    private String nom;
    private int edat;
    private Domicili dom;
    private static int notaMin = 5;
    
    // @Override
    // public int compareTo(Object obj) {
    // if (this.edat < ((Alumne)obj).edat) return -1;
    // else if (this.edat > ((Alumne)obj).edat) return +1;
    // else return 0;
    // }
   
    static Alumne copiarAlu(Alumne a1) {
       // return  new Alumne(a1.getNom(), a1.getEdat(), a1.getDom().getCarrer(), a1.getDom().getCp(), a1.getDom().getPoble());
    //    Domicili nouD = new Domicili() 
       return  new Alumne(a1.getNom(), a1.getEdat(), a1.getDom()); 
    }


    public Alumne(String nom, int edat, Domicili dom) {
        this.nom = nom;
        this.edat = edat;
        this.dom = dom;
    }


    public Alumne(String nom, int edat){
        this();        
        this.edat = edat;
        this.nom = nom;
     
    }

    Alumne() {
        
        System.out.println("Estic creant un alumne");
    }
    
   

    public Alumne(String nom, int edat, String carrer, int cp, String poble){
        this();        
        this.edat = edat;
        this.nom = nom;
       // this.dom = new Domicili(carrer, cp, poble);
        this.dom = new Domicili();
        this.dom.setCarrer(carrer);
        this.dom.setCp(cp);
        this.dom.setPoble(poble);
     
    }


    public Alumne(Alumne a1) {
        this.edat = a1.edat;
        this.nom = a1.nom;
        this.dom = a1.dom;

        
    }


    @Override
    public String toString(){
        return "Nom: " + this.nom + " edat:" + this.edat;

    }


    /**
     * esta funcion añl jfñalskjdf ñlaksjdfñlkajs fñ 
     * @return una cadena formada per el nom 
     */
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public int getEdat() {
        return edat;
    }


    public void setEdat(int edat) {

        this.edat = edat;
    }

    public void setCopiaDe(Alumne alumne) {
        this.nom = alumne.nom;
        this.edat = alumne.edat;
    }

    
    public static void mostraDades(Alumne alumne) {
        System.out.println("soc el mostra dades de la classe Alumne");
        System.out.println(alumne.getNom());
        System.out.println(alumne.getEdat());

    }

    public void mostraDades() {
        System.out.println("soc el mostra dades de la classe Alumne");
        System.out.println(this.getNom());
        System.out.println(this.getEdat());
    
    }

    public Alumne clon() {
        Alumne c = new Alumne(this.nom, this.edat);
        return c;

        // return new Alumne(this.nom, this.edat);

        /*
         * Alumne c = new Alumne();
         * c.nom = this.nom;
         * c.edat = this.edat;
         * return c;
         * 
         */
    }

    public Domicili getDom() {
        return dom;
    }

    public void setDom(Domicili dom) {
        this.dom = dom;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + this.edat;
        hash = 29 * hash + Objects.hashCode(this.dom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }


        if ( ! (obj instanceof Alumne)){
            return false;
        }
   
        // if (this.getClass() != obj.getClass()) {
        //     return false;
        // }


        // jo (this) i el paràmetre són de la mateixa classe. És a dir: que obj és realment un alumne( o fill d'Alumne')


        final Alumne other = (Alumne) obj;


        // if (this.edat != other.edat) {
        //     return false;
        // }
    
        
        if (Objects.equals(this.nom, other.nom) || this.edat == other.edat) {
            return true;
        } else {
            return false;
        }
        // return Objects.equals(this.dom, other.dom);
    }

    public static int getNotaMin() {
        return notaMin;
    }

    public static void setNotaMin(int notaMin) {
        Alumne.notaMin = notaMin;
    }

    @Override
    public int compareTo(Alumne t) {
        ComAluEdad cae = new ComAluEdad();
        ComAluNom can = new ComAluNom();
        if (cae.compare(this, t) != 0){
        return cae.compare(this, t);
        }
        return can.compare(this, t);
    }


    public int compareTo3(Alumne t) {
        if (this.edat != t.edat){
            return this.edat-t.edat;
        }
       return this.nom.compareTo(t.nom);
    }



    public int compareTo2(Alumne t) {
        if (this.edat < t.edat){
            return -1;
        }
        if (this.edat > t.edat){
            return 1;
        }
        if (this.nom.compareTo(t.nom)<0){
            return -1;
        }
        if (this.nom.compareTo(t.nom)>0){
            return 1;
        }
        return 0;

       
    }


}
