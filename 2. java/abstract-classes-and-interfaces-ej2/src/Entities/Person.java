package Entities;

public class Person {
    private int age;
    private String name;
    private String surname;

    // CONSTRUCTORS
    public Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    // METHODS
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
