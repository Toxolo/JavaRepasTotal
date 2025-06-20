

public class Articles implements avaluable, Comparable<Articles> {

    public static int getIva() {
        return iva;
    }

    private int codiNumeric;
    private String nom;
    private float  preu;
    private static int iva = 21;


    public Articles(int codiNumeric, String nom, float preu) {
        this.codiNumeric = codiNumeric;
        this.nom = nom;
        this.preu = preu;
    }


    public Articles(int codiNumeric, float preu) {
        this.codiNumeric = codiNumeric;
        this.preu = preu;
    }


    @Override
    public String toString() {
        return codiNumeric + "-" + nom + ": " + preu + " Preu total de: " + GetCost();
    }


    @Override
    public float GetCost() {
        return preu/2;
    }

    public int getCodiNumeric() {
        return codiNumeric;
    }

    public String getNom() {
        return nom;
    }

    public float getPreu() {
        return preu;
    }


    public void setCodiNumeric(int codiNumeric) {
        this.codiNumeric = codiNumeric;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    public void setPreu(float preu) {
        this.preu = preu;
    }


    public static void setIva(int iva) {
        Articles.iva = iva;
    }

    @Override
    public int compareTo(Articles t) {
        if (this.preu < t.preu){
            return -1;
        }
        if (this.preu > t.preu){
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codiNumeric;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Articles other = (Articles) obj;
        if (codiNumeric != other.codiNumeric)
            return false;
        return true;
    }

        

   

}
