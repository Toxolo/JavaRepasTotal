public class AlumneCicles extends Alumne {
    private String cicle;

    public AlumneCicles(String nom, int edat, String cicle) {
        super(nom, edat);
        this.cicle = cicle;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }
    
    @Override
    public String toString() {
        return "AlumneCicles [cicle=" + cicle + ", toString()=" + super.toString() + "]";
    }

   
    public void matricular() {
       
       System.out.println("posa el cicle en el sobre de matr");
    }
    
    
}
