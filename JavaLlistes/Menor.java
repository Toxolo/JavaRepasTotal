
public class Menor extends Persona {
    public Menor(String nombre, int edad) {
        super(nombre, edad);
        if (edad > 17) {
            throw new IllegalArgumentException("Un menor no puede tener más de 17 años.");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Menor - Nombre: " + nombre + ", Edad: " + edad);
    }
}
