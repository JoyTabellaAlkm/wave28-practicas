import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {
    private final CodigoMorseService service = new CodigoMorseService();

    @GetMapping("/traduccionAlEspanol")
    public String traduccionAlEspanol(@RequestParam String codigoMorse) {
        return service.traduccionAlEspanol(codigoMorse);
    }
}
