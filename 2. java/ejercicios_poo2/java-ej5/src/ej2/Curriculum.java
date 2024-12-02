package ej2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Documentable {
    private String persona;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades=" + habilidades +
                '}');
    }
}
