package documents;

import printer.IPrintable;

import java.util.List;

public class Curriculum implements IPrintable {
    private String name;
    private String dni;
    private int age;
    private String email;
    private List<String> skills;

    public Curriculum(String name, String dni, int age, String email, List<String> skills) {
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return " name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", skills=" + skills;
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo curriculum " + this);
    }
}
