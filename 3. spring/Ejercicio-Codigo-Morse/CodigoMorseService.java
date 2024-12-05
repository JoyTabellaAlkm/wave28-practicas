import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService {
    private final Map<String, String> traductor;

    public CodigoMorseService() {
        this.traductor = new HashMap<>();
        buildTraductor();
    }

    public String traduccionAlEspanol(String codigoMorse) {
        List<String> palabras = List.of(codigoMorse.split("   "));
        List<List<String>> letrasPorPalabra = palabras
                .stream()
                .map(this::separarLetrasDePalabra)
                .toList();
        String traduccion = letrasPorPalabra.stream()
                .map(this::palabraMorseAPalabraEspañol)
                .collect(Collectors.joining(" "));
        return traduccion;
    }

    private String palabraMorseAPalabraEspañol(List<String> palabra) {
        return palabra.stream()
                .map(this::traduccionMorseAEspanol)
                .collect(Collectors.joining(""));
    }

    private void buildTraductor() {
        traductor.put(".-", "A");
        traductor.put("-...", "B");
        traductor.put("-.-.", "C");
        traductor.put("-..", "D");
        traductor.put(".", "E");
        traductor.put("..-.", "F");
        traductor.put("--.", "G");
        traductor.put("....", "H");
        traductor.put("..", "I");
        traductor.put(".---", "J");
        traductor.put("-.", "K");
        traductor.put(".-..", "L");
        traductor.put("--", "M");
        traductor.put("-.", "N");
        traductor.put("---", "O");
        traductor.put(".--.", "P");
        traductor.put("--.-", "Q");
        traductor.put(".-.", "R");
        traductor.put("...", "S");
        traductor.put("-", "T");
        traductor.put("..-", "U");
        traductor.put("...-", "V");
        traductor.put(".--", "W");
        traductor.put("-..-", "X");
        traductor.put("-.--", "Y");
        traductor.put("--..", "Z");
        traductor.put(".----", "1");
        traductor.put("..---", "2");
        traductor.put("...--", "3");
        traductor.put("....-", "4");
        traductor.put(".....", "5");
        traductor.put("-....", "6");
        traductor.put("--...", "7");
        traductor.put("---..", "8");
        traductor.put("----.", "9");
        traductor.put("-----", "0");
        traductor.put("..--..", "?");
        traductor.put("-.-.--", "!");
        traductor.put(".-.-.-", ".");
        traductor.put("--..--", ",");
    }

    private String traduccionMorseAEspanol(String letraMorse) {
        return traductor.get(letraMorse);
    }

    private List<String> separarLetrasDePalabra(String palabra) {
        return Arrays.stream(palabra.split(" ")).toList();
    }
}
