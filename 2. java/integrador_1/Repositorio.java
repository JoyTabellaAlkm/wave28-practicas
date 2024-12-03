package integrador_1;

import java.util.*;

public class Repositorio {
  List<Localizador> compras = new ArrayList<Localizador>();

  void agregarCompra(Localizador localizador){
    System.out.println("Nueva compra: ");
    System.out.println(localizador.toString());
    compras.add(localizador);
  }

  int contarComprasPorUsuario(int id){
    int cnt = 0;
    for(Localizador localizador : compras){
      cnt += (localizador.getClienteId() == id ? 1 : 0);
    }
    return cnt;
  }
}
