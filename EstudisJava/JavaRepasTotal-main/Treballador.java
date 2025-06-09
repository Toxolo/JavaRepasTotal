
public class Treballador {
    private String nom;
    private String apellidos;
    private int edad;

    public Treballador(String nom, String apellidos, int edad) {
        this.nom = nom;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNom() {
        return nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }   

    public void salutar() {
        System.out.println("Hola, soc " + nom + " " + apellidos + " i tinc " + edad);
    }
}