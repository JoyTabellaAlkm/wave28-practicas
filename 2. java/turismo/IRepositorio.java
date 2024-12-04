
import java.util.List;

public interface IRepositorio<T> {
    void almacenar(T elem);

   // Localizador buscarReserva(String dni);

    List<Localizador> buscarReservas(String dni);
}
