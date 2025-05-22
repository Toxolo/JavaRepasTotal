package ProbesDeObjectes;

/**
 * CuentaMenorEdad.java
 *
 * Cuenta especial para titulares menores de edad: no permite retiros.
 */
public class CuentaMenorEdad extends Cuenta {
    /**
     * Crea una cuenta para menor de edad.
     * @param nombre Nombre del titular
     * @param edad Edad del titular
     * @param numero Número de cuenta
     * @param saldo Saldo inicial
     */
    public CuentaMenorEdad(String nombre, int edad, String numero, double saldo) {
        super(nombre, edad, numero, saldo);
    }

    @Override
    public boolean retirar(double cantidad) {
        System.out.println("Operación no permitida: titular menor de edad.");
        return false;
    }
}
