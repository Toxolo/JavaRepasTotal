
public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("Una persona debe tener al menos 18 años.");
        }
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarInfo() {
        System.out.println("Persona - Nombre: " + nombre + ", Edad: " + edad);
    }
}
