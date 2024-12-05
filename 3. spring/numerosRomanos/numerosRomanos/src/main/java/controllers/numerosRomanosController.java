package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conversion")
public class numerosRomanosController {

    @GetMapping("/{numeroDecimal}")
    public int convertirARomano(@PathVariable Character numeroDecimal) {


        return 0;
    }


}
