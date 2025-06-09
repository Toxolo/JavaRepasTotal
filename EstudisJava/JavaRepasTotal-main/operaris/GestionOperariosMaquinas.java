import java.util.*;

/**
 * GestionOperariosMaquinas.java
 *
 * Programa principal para gestionar operarios, máquinas y sus relaciones.
 */
public class GestionOperariosMaquinas {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Operario> operarios = new HashMap<>();
    private static Map<String, Maquina> maquinas = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opt = leerOpcion(1, 6);
            switch (opt) {
                case 1 -> crearOperario();
                case 2 -> crearMaquina();
                case 3 -> asignarOperarioAMaquina();
                case 4 -> listarEntidades();
                case 5 -> listarRelaciones();
                case 6 -> { System.out.println("Saliendo..."); sc.close(); return; }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Crear nuevo operario");
        System.out.println("2. Crear nueva máquina");
        System.out.println("3. Asignar operario a máquina");
        System.out.println("4. Listar operarios y máquinas");
        System.out.println("5. Listar asignaciones");
        System.out.println("6. Salir");
        System.out.print("Opción (1-6): ");
    }

    private static int leerOpcion(int min, int max) {
        while (true) {
            try {
                int o = Integer.parseInt(sc.nextLine());
                if (o >= min && o <= max) return o;
            } catch (Exception e) {}
            System.out.print("Elige entre " + min + " y " + max + ": ");
        }
    }

    private static void crearOperario() {
        int num;
        do {
            num = leerEntero("Número de empleado: ");
            if (operarios.containsKey(num)) System.out.println("Ya existe ese número.");
        } while (operarios.containsKey(num));
        char sector = leerSector();
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine().trim();
        operarios.put(num, new Operario(num, sector, nombre));
        System.out.println("Operario creado: " + num);
    }

    private static void crearMaquina() {
        System.out.print("ID de máquina: ");
        String id = sc.nextLine().trim();
        if (maquinas.containsKey(id)) { System.out.println("Ya existe esa máquina."); return; }
        char sector = leerSector();
        maquinas.put(id, new Maquina(id, sector));
        System.out.println("Máquina creada: " + id);
    }

    private static void asignarOperarioAMaquina() {
        int num = leerEntero("Número de empleado: ");
        Operario op = operarios.get(num);
        if (op == null) { System.out.println("Operario no encontrado."); return; }
        System.out.print("ID de máquina: ");
        String id = sc.nextLine().trim();
        Maquina m = maquinas.get(id);
        if (m == null) { System.out.println("Máquina no encontrada."); return; }
        if (op.getSector() != m.getSector()) {
            System.out.println("Sector mismatch: operario " + op.getSector() + " vs máquina " + m.getSector());
            return;
        }
        op.asignarMaquina(m);
        m.addOperario(op);
        System.out.println("Asignado operario " + num + " a máquina " + id);
    }

    private static void listarEntidades() {
        System.out.println("Operarios:");
        operarios.values().forEach(System.out::println);
        System.out.println("Máquinas:");
        maquinas.values().forEach(System.out::println);
    }

    private static void listarRelaciones() {
        System.out.println("Asignaciones Operario -> Máquinas:");
        for (Operario op : operarios.values()) {
            System.out.println(op);
            op.getMaquinas().forEach(m -> System.out.println("  - " + m.getId()));
        }
        System.out.println("Asignaciones Máquina -> Operarios:");
        for (Maquina m : maquinas.values()) {
            System.out.println(m);
            m.getOperariosValidos().forEach(op -> System.out.println("  - #" + op.getNumEmpleado()));
        }
    }

    private static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            try { return Integer.parseInt(sc.nextLine()); }
            catch (Exception e) { System.out.println("Entero inválido."); }
        }
    }

    private static char leerSector() {
        while (true) {
            System.out.print("Sector (A,B,C,D,E,G): ");
            String s = sc.nextLine().trim().toUpperCase();
            if (s.matches("[ABCDEG]")) return s.charAt(0);
            System.out.println("Sector inválido.");
        }
    }
}
