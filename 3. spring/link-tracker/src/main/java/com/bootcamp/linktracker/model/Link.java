package com.bootcamp.linktracker.model;

import lombok.*;

import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
@ToString
public class Link {
    private static AtomicLong autoIncrementalId = new AtomicLong(1);
    private Long id;
    private String link;
    private String password;
    private int cantRedirecciones;

    public Link(String link, String password, int cantRedirecciones) {
        this.id = autoIncrementalId.getAndIncrement();
        this.link = link;
        this.password = password;
        this.cantRedirecciones = cantRedirecciones;
    }
}
