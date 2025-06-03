public class Conter extends Treballador {
    private int  Id;
    private int salari;

    public Conter (String nom, String apellidos, int edad, int salari, int Id){
        super(nom, apellidos, edad);
        this.salari=salari;
        this.Id=Id;
    }

    public int getId() {
        return Id;
    }
    public int getSalari() {
        return salari;
    }
    public void setId(int id) {
        Id = id;
    }
    public void setSalari(int salari) {
        this.salari = salari;
    }

    public void VorerConter(){
        salutar();
        System.out.println("El teu conter es el " + Id + " i tens " + salari + "€");
    }
}
