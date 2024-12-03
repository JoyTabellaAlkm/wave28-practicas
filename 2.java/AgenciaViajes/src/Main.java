import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1234", "Nicolas", "Buitrago");
        Reserva reservaHotel = new Reserva(cliente1, new HotelServicio("Marriot", 200.0));
        Reserva reservaComida = new Reserva(cliente1, new ComidaServicio("Plan comida 1", 220.0));
        Reserva reservaBoleto = new Reserva(cliente1, new BoletosServicio("Avianca", 100.0));
        Reserva reservaTransporte = new Reserva(cliente1, new TransporteServicio("Tours por la ciudad", 100.0));
        List<Reserva> listaReserva = new ArrayList<>(List.of(reservaHotel, reservaComida, reservaBoleto, reservaTransporte));
        Localizador localizador1 = new Localizador(cliente1, listaReserva);

        Repositorio.listaLocalizadores.add(localizador1);
        System.out.println(localizador1);

        System.out.println("-----------------------------");
        Reserva reservaHotel2 = new Reserva(cliente1, new HotelServicio("Hilton", 300.0));
        Reserva reservaBoleto2 = new Reserva(cliente1, new BoletosServicio("Latam", 150.0));
        List<Reserva> listaReserva2 = new ArrayList<>(List.of(reservaHotel, reservaHotel2, reservaBoleto, reservaBoleto2));
        Localizador localizador2 = new Localizador(cliente1, listaReserva2);

        Repositorio.listaLocalizadores.add(localizador2);
        System.out.println(localizador2);

        System.out.println("-----------------------------");
        List<Reserva> listaReserva3 = new ArrayList<>(List.of(reservaBoleto2));
        Localizador localizador3 = new Localizador(cliente1, listaReserva3);
        Repositorio.listaLocalizadores.add(new Localizador(cliente1, listaReserva3));

        Repositorio.listaLocalizadores.add(localizador3);
        System.out.println(localizador3);
    }
}

class Repositorio {
    public static List<Localizador> listaLocalizadores = new ArrayList<>();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

class Reserva {
    private Cliente cliente;
    private Servicio servicio;

    public Reserva(Cliente cliente, Servicio servicio) {
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", servicio=" + servicio +
                '}';
    }
}

class Localizador {
    private Cliente cliente;
    private Double total;
    private List<Reserva> reserva;

    public Localizador(Cliente cliente, List<Reserva> reserva) {
        this.cliente = cliente;
        this.total = 0.0;
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    private Double calcularTotal() {

        Double totalSinDesc = reserva.stream().mapToDouble(x -> x.getServicio().getCosto()).sum();
        Double totalConDes = 0.0;
        List<Localizador> loc = Repositorio.listaLocalizadores.stream().filter(x -> x.getCliente().getDni().equalsIgnoreCase(cliente.getDni())).toList();
        if (loc.size() > 2) {
            System.out.println("Haciendo descuento del 5%...");
            totalConDes = totalSinDesc * 0.95;
        }
        /*loc.stream().filter(x->x.)*/
        List<Localizador> locPaqueteCompleto = loc.stream().filter(x -> {
            List<Reserva> resrva = x.getReserva();
            boolean hotel = false;
            boolean comida = false;
            boolean boleto = false;
            boolean transporte = false;
            for (Reserva r : resrva) {
                Servicio s = r.getServicio();
                if (s instanceof HotelServicio) {
                    hotel = true;
                }
                if (s instanceof ComidaServicio) {
                    comida = true;
                }
                if (s instanceof BoletosServicio) {
                    boleto = true;
                }
                if (s instanceof TransporteServicio) {
                    transporte = true;
                }
            }
            return hotel && comida && boleto && transporte;
        }).toList();

        boolean hotel = false;
        boolean comida = false;
        boolean boleto = false;
        boolean transporte = false;
        Integer contadorHotel=0;
        Integer contadorBoletos=0;
        for (Reserva r : reserva) {
            Servicio s = r.getServicio();
            if (s instanceof HotelServicio) {
                hotel = true;
                contadorHotel++;
            }
            if (s instanceof ComidaServicio) {
                comida = true;
            }
            if (s instanceof BoletosServicio) {
                boleto = true;
                contadorBoletos++;
            }
            if (s instanceof TransporteServicio) {
                transporte = true;
            }
        }

        if (hotel && comida && boleto && transporte) {
            System.out.println("Haciendo descuento del 10%...");
            totalConDes = totalSinDesc * 0.90;
        }
        return totalConDes;
    }

    @Override
    public String toString() {
        this.total = calcularTotal();
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reserva=" + reserva +
                '}';
    }
}

abstract class Servicio {
    private String nombre;
    private Double costo;

    public Servicio(String nombre, Double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "nombre='" + nombre + '\'' +
                ", costo=" + costo +
                '}';
    }
}

class HotelServicio extends Servicio {

    public HotelServicio(String nombre, Double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "HotelServicio:" + super.toString();
    }
}

class ComidaServicio extends Servicio {

    public ComidaServicio(String nombre, Double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "ComidaServicio:" + super.toString();
    }
}

class BoletosServicio extends Servicio {

    public BoletosServicio(String nombre, Double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "BoletosServicio:" + super.toString();
    }
}

class TransporteServicio extends Servicio {

    public TransporteServicio(String nombre, Double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "TransporteServicio:" + super.toString();
    }
}