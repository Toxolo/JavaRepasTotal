

public class AlumnesEso extends Alumne {
    private int telfpa;
    private int telfma;

    @Override
    public void mostraDades(){
        super.mostraDades();
        System.out.println(this.telfma);
        System.out.println(this.telfpa);
    }

    public void matricular() {
       
        System.out.println("posa el tel pare i mare en el sobre de matr");
     }
     
    public void AlumnesEso (String nom, int edat, int tp, int tm){
        // una crida al constructor del pare
        // super();
        this.setNom(nom);
        this.setEdat(edat);
        this.telfpa = tp;
        this.telfma = tm;
    }
    public AlumnesEso(int telfma, int telfpa, String nom, int edat) {
        super(nom, edat);
        this.telfma = telfma;
        this.telfpa = telfpa;
    }
    @Override
    public String toString() {
        return "AlumnesEso [telfpa=" + telfpa + ", telfma=" + telfma + ", toString()=" + super.toString() + "]";
    }

    public int getTelfpa() {
        return telfpa;
    }

    public void setTelfpa(int telfpa) {
        this.telfpa = telfpa;
    }

    public int getTelfma() {
        return telfma;
    }

    public void setTelfma(int telfma) {
        this.telfma = telfma;
    }



    
    
}
