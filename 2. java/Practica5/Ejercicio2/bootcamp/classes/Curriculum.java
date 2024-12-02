package bootcamp.classes;

import bootcamp.interfaces.Imprimible;

import java.util.ArrayList;

public class Curriculum extends Document {
    private String name;
    private String lastname;
    private Integer age;
    private ArrayList<String> skills = new ArrayList<>();

    public Curriculum(String name, String lastname, Integer age){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public void setSkill(String skill) {
        skills.add(skill);
    }

    @Override
    public void print(){
        System.out.println("Curriculum de: " + name + " " + lastname);
        System.out.println("Edad: " + age);
        System.out.println("Habilidades");
        for(String habilidad : skills ){
            System.out.println("* " + habilidad);
        }
    }

}
