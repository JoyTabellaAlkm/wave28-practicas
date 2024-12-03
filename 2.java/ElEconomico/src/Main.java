import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1234", "Nicolas", "Buitrago");
        Cliente cliente2 = new Cliente("5678", "Ana", "Cárdenas");
        Cliente cliente3 = new Cliente("9876", "Gabi", "Lopez");

        List<Cliente> listaClientes = new ArrayList<>(List.of(cliente1, cliente2, cliente3));

        listaClientes.forEach(System.out::println);

        listaClientes.remove(cliente1);
        System.out.println("--------------------------------");
        listaClientes.forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("==================================================");
            System.out.println("Menú");
            System.out.println("(1) Consultar cliente");
            System.out.println("(0) Salir");
            System.out.println("==================================================");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    consultarCliente(listaClientes);
                    break;
            }
        } while (option != 0);

    }

    static void consultarCliente(List<Cliente> lista) {
        System.out.println("Ingrese el DNI del cliente");
        Scanner sc = new Scanner(System.in);
        String option = sc.nextLine();

        Cliente c = lista.stream().filter(x -> x.getDni().equalsIgnoreCase(option)).findAny().orElse(null);

        if (c != null) {
            System.out.println(c.toString());
        } else {
            System.out.println("El cliente No existe");
        }
    }
}

class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNobre() {
        return nombre;
    }

    public void setNobre(String nobre) {
        this.nombre = nobre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}

class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double costoUnitario;

    public Item(String codigo, String nombre, Integer cantidad, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}

class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = items = new ArrayList<Item>();
        this.totalCompra = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
}