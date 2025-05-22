import java.util.HashSet;
import java.util.Set;

/**
 * Maquina.java
 *
 * Representa una máquina con identificador, sector y operarios válidos.
 */
public class Maquina {
    private String id;
    private char sector;
    private Set<Operario> operariosValidos = new HashSet<>();

    /**
     * Crea una máquina.
     * @param id Identificador único de la máquina
     * @param sector Sector asignado (A, B, C, D, E, G)
     */
    public Maquina(String id, char sector) {
        this.id = id;
        this.sector = sector;
    }

    public String getId() {
        return id;
    }

    public char getSector() {
        return sector;
    }

    /**
     * Añade un operario válido para esta máquina.
     */
    public void addOperario(Operario o) {
        operariosValidos.add(o);
    }

    /**
     * Devuelve el conjunto de operarios válidos.
     */
    public Set<Operario> getOperariosValidos() {
        return operariosValidos;
    }

    @Override
    public String toString() {
        return "Máquina[" + id + " | sec=" + sector + "]";
    }
}
