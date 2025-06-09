
# 🧠 Proyecto Java: Gestión de Personas y Menores

## 📋 Objetivo

Crear una aplicación en Java por consola que permita gestionar **personas adultas y menores de edad** con reglas específicas, aprovechando conceptos de:

- Programación orientada a objetos (POO)
- Herencia
- Validación de datos
- Interacción dinámica mediante menú

---

## 📦 Estructura del proyecto

El programa está dividido en **tres archivos** Java:

```
├── Persona.java   // Clase base
├── Menor.java     // Subclase de Persona
└── Main.java      // Lógica de menú y listas
```

---

## 🧱 Clases

### 1. `Persona.java`

```java
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
```

✅ Reglas:
- Solo acepta edades **18 o más**.
- Lanza una excepción si se viola esa condición.

---

### 2. `Menor.java`

```java
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
```

✅ Reglas:
- Solo acepta edades **menores a 18**.
- Reutiliza el constructor de `Persona`.
- Sobrescribe el método `mostrarInfo()` para indicar el tipo.

---

## 📊 Lógica del programa (Main.java)

### Listas utilizadas

```java
ArrayList<Persona> listaPersonas = new ArrayList<>();
ArrayList<Menor> listaMenores = new ArrayList<>();
```

- **`listaPersonas`**: almacena objetos `Persona` (mayores).
- **`listaMenores`**: almacena objetos `Menor`.

---

### Menú interactivo

```text
--- Menú ---
1. Crear una persona o menor
2. Mostrar listas de personas y menores
3. Eliminar una persona de la lista de personas
4. Editar la edad de un menor
5. Salir
```

---

### Funcionalidades clave

#### ✅ Crear persona o menor
- Según la edad y el tipo elegido (`p` o `m`), el objeto se guarda en la lista correspondiente.
- Valida automáticamente que la edad sea coherente.

#### ✅ Mostrar listas
- Muestra por separado:
  - Lista de personas adultas
  - Lista de menores

#### ✅ Eliminar persona
- Permite eliminar objetos **solo de la lista de adultos** (`listaPersonas`).

#### ✅ Editar edad de un menor
- Si al modificar la edad de un menor esta alcanza **18 o más**:
  - Se elimina de `listaMenores`.
  - Se convierte en una nueva instancia de `Persona`.
  - Se añade automáticamente a `listaPersonas`.

---

## 🧪 Ejemplo de uso

```
1. Crear una persona o menor
> m
> Juan
> 17

2. Mostrar listas
📋 Menores:
1. Menor - Nombre: Juan, Edad: 17

4. Editar la edad de un menor
> Juan pasa a 18

🔄 El menor ha sido convertido en persona y movido.

2. Mostrar listas
📋 Personas:
1. Persona - Nombre: Juan, Edad: 18
📋 Menores:
(ninguno)
```

---

## 🧰 Compilación y ejecución

```bash
javac Main.java Persona.java Menor.java
java Main
```

---

## 🧠 Conceptos aprendidos

- **POO en Java**: clases, objetos, herencia, sobrescritura.
- **Validación** de datos en tiempo de ejecución (`throw`).
- **Listas dinámicas** (`ArrayList`) y gestión de datos.
- **Interfaz por consola** con `Scanner` y menú interactivo.
- Lógica de **conversión de tipos** (`Menor` → `Persona`).
