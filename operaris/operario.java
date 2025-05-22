import java.util.HashSet;
import java.util.Set;

/**
 * Operario.java
 *
 * Representa un operario con número de empleado, sector y nombre completo.
 * Mantiene un conjunto de máquinas que puede operar.
 */
public class Operario {
    private int numEmpleado;
    private char sector;
    private String nombreCompleto;
    private Set<Maquina> maquinas = new HashSet<>();

    /**
     * Crea un operario.
     * @param numEmpleado Identificador único del empleado
     * @param sector Sector asignado (A, B, C, D, E, G)
     * @param nombreCompleto Nombre completo del operario
     */
    public Operario(int numEmpleado, char sector, String nombreCompleto) {
        this.numEmpleado = numEmpleado;
        this.sector = sector;
        this.nombreCompleto = nombreCompleto;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public char getSector() {
        return sector;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Asigna una máquina a este operario.
     */
    public void asignarMaquina(Maquina m) {
        maquinas.add(m);
    }

    /**
     * Devuelve el conjunto de máquinas asignadas.
     */
    public Set<Maquina> getMaquinas() {
        return maquinas;
    }

    @Override
    public String toString() {
        return "Operario[#" + numEmpleado + " | sec=" + sector + " | " + nombreCompleto + "]";
    }
}
