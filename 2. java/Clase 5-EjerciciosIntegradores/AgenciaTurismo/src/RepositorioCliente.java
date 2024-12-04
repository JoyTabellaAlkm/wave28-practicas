import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    private static Map<String, List<Localizador>> localizadorCliente;

    public static int cantidadLozalizadores(String dni){
        return localizadorCliente.get(dni).size();
    }
}
