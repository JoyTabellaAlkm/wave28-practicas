package com.mercadolibre.sayhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/saludo")
public class SayHelloController {
    @Autowired
    private ISayHelloService sayHelloService;
    @GetMapping(path = "{name}/{lastname}")
    public String sayHello(@PathVariable String name,@PathVariable String lastname){
        return sayHelloService.sayHello(name ,lastname);
    }

}
