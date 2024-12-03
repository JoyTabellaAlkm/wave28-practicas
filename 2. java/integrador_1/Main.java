package integrador_1;

public class Main {
  public static void main(String[] args) {
    Repositorio repositorio = new Repositorio(); //Base de datos de compras

    Cliente cliente1 = new Cliente(1,"Mariana", "Ramirez");
    Cliente cliente2 = new Cliente(2,"Nicolas", "Arias");

    //Mariana comprando

    Reserva reserva1 = new Hotel(10);
    Reserva reserva2 = new Boleto(10);

    Localizador compra1 = new Localizador(cliente1);
    compra1.agregarReserva(reserva1);
    compra1.agregarReserva(reserva2);

    repositorio.agregarCompra(compra1);
    

    //Nicolas comprando
    Reserva reserva3 = new Comida(20);

    Localizador compra2 = new Localizador(cliente2);
    compra2.agregarReserva(reserva3);

    //Mariana comprando again

    Localizador compra3 = new Localizador(cliente2);
    Reserva reserva4 = new Reserva(200);
    compra3.agregarReserva(reserva4);
    //Mariana recibe descuento por segunda compra para futuras compras
    if(repositorio.contarComprasPorUsuario(1) == 2)cliente1.setDescuento(0.5);
  }
  
}
