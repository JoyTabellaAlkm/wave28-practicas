package com.example.concesionarioautos.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Servicios {
    Date date;
    Integer kilometers;
    String descriptions;
}
