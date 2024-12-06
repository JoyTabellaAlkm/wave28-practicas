package com.mercadolibre.sayhello;

import org.springframework.stereotype.Service;

@Service
public class SayHelloService implements ISayHelloService{
    public String sayHello(String name , String lastName){
        return "Hola "+name+" "+lastName;
    }
}
