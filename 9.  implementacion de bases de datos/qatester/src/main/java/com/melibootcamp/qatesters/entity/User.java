package com.melibootcamp.qatesters.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    @OneToMany(mappedBy = "assignedUser")
    private Set<TestCase> assignedTestCases;

    //Agregar una funcion que permite traer un listado de todos los testCases que tiene un usuario

}
