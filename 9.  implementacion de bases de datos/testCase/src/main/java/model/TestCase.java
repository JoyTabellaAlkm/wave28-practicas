package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    private String description;
    private Boolean tested;
    private Boolean passed;

    public Long getId_case() {
        return id_case;
    }

    public void setId_case(Long id_case) {
        this.id_case = id_case;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public int getNumber_of_tries() {
        return number_of_tries;
    }

    public void setNumber_of_tries(int number_of_tries) {
        this.number_of_tries = number_of_tries;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Boolean getTested() {
        return tested;
    }

    public void setTested(Boolean tested) {
        this.tested = tested;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int number_of_tries;
    private LocalDate last_update;
}