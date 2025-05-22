package ProbesDeObjectes;

/**
 * Cliente.java
 *
 * Representa un cliente con nombre y edad.
 */
public class Cliente {
    private String nombre;
    private int edad;

    /**
     * Crea un cliente.
     * @param nombre Nombre del cliente
     * @param edad Edad del cliente
     */
    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
