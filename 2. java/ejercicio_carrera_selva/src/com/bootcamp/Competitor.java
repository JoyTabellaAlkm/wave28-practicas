package com.bootcamp;

public class Competitor {
    private int nroCompetitor;
    private int dni;
    private String name;
    private String lastName;
    private int age;
    private String phone;
    private String emergencyNumber;
    private String bloodType;

    public Competitor(int nroCompetitor, int dni, String name, String lastName, int age, String phone, String emergencyNumber, String bloodType) {
        this.nroCompetitor = nroCompetitor;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.emergencyNumber = emergencyNumber;
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "nroCompetitor=" + nroCompetitor +
                ", dni=" + dni +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", bloodType='" + bloodType + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }
}
