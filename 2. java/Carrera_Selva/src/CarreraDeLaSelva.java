import java.util.ArrayList;
import java.util.List;

class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private int costoMenor;
    private int costoMayor;
    private boolean permiteMenores;
    private List<Inscripcion> inscripciones;

    public Categoria(int id, String nombre, String descripcion, int costoMenor, int costoMayor, boolean permiteMenores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoMenor = costoMenor;
        this.costoMayor = costoMayor;
        this.permiteMenores = permiteMenores;
        this.inscripciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean permiteMenores() {
        return permiteMenores;
    }

    public int calcularCosto(int edad) {
        return edad < 18 ? costoMenor : costoMayor;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public int calcularMontoTotal() {
        return inscripciones.stream().mapToInt(Inscripcion::getMonto).sum();
    }

    @Override
    public String toString() {
        return "Categoría: " + nombre + " - " + descripcion;
    }
}

class Participante {
    private int numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int numero, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumero() {
        return numero;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (DNI: " + dni + ")";
    }
}

class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = categoria.calcularCosto(participante.getEdad());
    }

    public int getMonto() {
        return monto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    @Override
    public String toString() {
        return "Inscripcion #" + numero + " - " + participante.toString() + " - Monto: $" + monto;
    }
}

public class CarreraDeLaSelva {
    public static void main(String[] args) {
        // Crear categorías
        Categoria circuitoChico = new Categoria(1, "Circuito Chico", "2 km por selva y arroyos", 1300, 1500, true);
        Categoria circuitoMedio = new Categoria(2, "Circuito Medio", "5 km por selva, arroyos y barro", 2000, 2300, true);
        Categoria circuitoAvanzado = new Categoria(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra", 0, 2800, false);

        // Crear participantes
        Participante p1 = new Participante(1, "12345678", "Juan", "Perez", 17, "123456789", "987654321", "O+");
        Participante p2 = new Participante(2, "87654321", "Maria", "Gomez", 22, "123456789", "987654321", "A-");
        Participante p3 = new Participante(3, "11223344", "Luis", "Rodriguez", 18, "123456789", "987654321", "B+");

        // Crear inscripciones
        Inscripcion inscripcion1 = new Inscripcion(1, circuitoChico, p1);
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMedio, p2);
        Inscripcion inscripcion3 = new Inscripcion(3, circuitoAvanzado, p3);

        // Agregar inscripciones a las categorías
        circuitoChico.agregarInscripcion(inscripcion1);
        circuitoMedio.agregarInscripcion(inscripcion2);
        circuitoAvanzado.agregarInscripcion(inscripcion3);

        // Mostrar inscripciones por categoría
        System.out.println("Inscripciones en Circuito Chico:");
        for (Inscripcion i : circuitoChico.getInscripciones()) {
            System.out.println(i);
        }

        System.out.println("\nInscripciones en Circuito Medio:");
        for (Inscripcion i : circuitoMedio.getInscripciones()) {
            System.out.println(i);
        }

        System.out.println("\nInscripciones en Circuito Avanzado:");
        for (Inscripcion i : circuitoAvanzado.getInscripciones()) {
            System.out.println(i);
        }

        // Calcular monto total recaudado por categoría
        System.out.println("\nMonto total recaudado:");
        System.out.println("Circuito Chico: $" + circuitoChico.calcularMontoTotal());
        System.out.println("Circuito Medio: $" + circuitoMedio.calcularMontoTotal());
        System.out.println("Circuito Avanzado: $" + circuitoAvanzado.calcularMontoTotal());
        System.out.println("Total: $" + (circuitoChico.calcularMontoTotal() + circuitoMedio.calcularMontoTotal() + circuitoAvanzado.calcularMontoTotal()));
    }
}