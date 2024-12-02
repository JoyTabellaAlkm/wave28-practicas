package Entities;

import Interfaces.IPrintable;

import java.util.List;

public class Curriculum implements IPrintable {
    private Person person;
    private List<String> skillset;

    // CONSTRUCTORS
    public Curriculum(Person person, List<String> skillset) {
        this.person = person;
        this.skillset = skillset;
    }

    // METHODS
    @Override
    public String toString() {
        return "Curriculum{" +
                "person=" + person.toString() +
                ", skillset=" + skillset +
                '}';
    }

    @Override
    public String print() {
        return this.toString();
    }
}
