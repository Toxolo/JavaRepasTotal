package ProbesDeObjectes;
import java.text.DecimalFormat;

/**
 * Cuenta.java
 *
 * Una cuenta bancaria asociada a un cliente.
 */
public class Cuenta extends Cliente {
    private String numero;
    protected double saldo;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * Crea una cuenta bancaria.
     * @param nombre Nombre del titular
     * @param edad Edad del titular
     * @param numero Número de cuenta
     * @param saldo Saldo inicial
     */
    public Cuenta(String nombre, int edad, String numero, double saldo) {
        super(nombre, edad);
        this.numero = numero;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Deposita una cantidad en la cuenta.
     * @param cantidad Cantidad a depositar
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depositados " + df.format(cantidad) + " €. Saldo: " + df.format(saldo));
        }
    }

    /**
     * Retira una cantidad de la cuenta si hay saldo.
     * @param cantidad Cantidad a retirar
     * @return true si se retiró, false en caso contrario
     */
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retirados " + df.format(cantidad) + " €. Saldo: " + df.format(saldo));
            return true;
        }
        System.out.println("Fondos insuficientes.");
        return false;
    }

    /**
     * Transfiere una cantidad a otra cuenta.
     * @param destino Cuenta destino
     * @param cantidad Cantidad a transferir
     */
    public void transferir(Cuenta destino, double cantidad) {
        if (retirar(cantidad)) {
            destino.depositar(cantidad);
            System.out.println("Transferencia de " + df.format(cantidad) + " € de " + numero + " a " + destino.getNumero());
        }
    }

    @Override
    public String toString() {
        return "Cuenta[" + numero + "] Titular=" + getNombre() + " (" + getEdad() + " años) Saldo=" + df.format(saldo) + " €";
    }
}

